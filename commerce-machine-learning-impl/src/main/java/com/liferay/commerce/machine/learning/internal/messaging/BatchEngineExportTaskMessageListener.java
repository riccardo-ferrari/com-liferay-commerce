package com.liferay.commerce.machine.learning.internal.messaging;

import com.liferay.batch.engine.BatchEngineTaskExecuteStatus;
import com.liferay.batch.engine.model.BatchEngineExportTask;
import com.liferay.batch.engine.service.BatchEngineExportTaskLocalService;
import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcess;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLocalService;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLogLocalService;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Ferrari
 */
@Component(immediate = true, service = ModelListener.class)
public class BatchEngineExportTaskMessageListener
	extends BaseModelListener<BatchEngineExportTask> {

	@Override
	public void onAfterUpdate(BatchEngineExportTask batchEngineExportTask)
		throws ModelListenerException {

		BatchEngineTaskExecuteStatus batchEngineTaskExecuteStatus =
			BatchEngineTaskExecuteStatus.valueOf(
				batchEngineExportTask.getExecuteStatus());

		if (batchEngineTaskExecuteStatus.equals(
				BatchEngineTaskExecuteStatus.INITIAL) ||
			batchEngineTaskExecuteStatus.equals(
				BatchEngineTaskExecuteStatus.STARTED)) {

			return;
		}

		Map<String, Serializable> parameters =
			batchEngineExportTask.getParameters();

		long commerceDataIntegrationProcessId = GetterUtil.getLong(
			parameters.get("commerceDataIntegrationProcessId"));

		if (commerceDataIntegrationProcessId == 0) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Batch export task does not have a " +
						"commerceDataIntegrationId, skipping");
			}

			return;
		}

		CommerceDataIntegrationProcess commerceDataIntegrationProcess =
			_commerceDataIntegrationProcessLocalService.
				fetchCommerceDataIntegrationProcess(
					commerceDataIntegrationProcessId);

		if (commerceDataIntegrationProcess == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Can not find Commerce Data Integration Process Id: " +
						commerceDataIntegrationProcessId);
			}

			return;
		}

		long commerceDataIntegrationProcessLogId = GetterUtil.getLong(
			parameters.get("commerceDataIntegrationProcessLogId"));

		try {
			if (batchEngineTaskExecuteStatus.equals(
					BatchEngineTaskExecuteStatus.COMPLETED)) {

				if (_log.isDebugEnabled()) {
					_log.debug("Batch Export process completed, uploading");
				}

				_uploadExport(
					batchEngineExportTask, commerceDataIntegrationProcess);

				_commerceDataIntegrationProcessLogLocalService.
					updateCommerceDataIntegrationProcessLog(
						commerceDataIntegrationProcessLogId, null, null,
						BackgroundTaskConstants.STATUS_SUCCESSFUL, new Date());
			}
			else {
				_commerceDataIntegrationProcessLogLocalService.
					updateCommerceDataIntegrationProcessLog(
						commerceDataIntegrationProcessLogId, null, null,
						BackgroundTaskConstants.STATUS_FAILED, new Date());
			}
		}
		catch (Exception e) {
			_log.error(e, e);

			try {
				_commerceDataIntegrationProcessLogLocalService.
					updateCommerceDataIntegrationProcessLog(
						commerceDataIntegrationProcessLogId, null, null,
						BackgroundTaskConstants.STATUS_FAILED, new Date());
			} catch (PortalException pe) {
				_log.error(pe, pe);
			}
		}
	}

	private void _uploadExport(
			BatchEngineExportTask batchEngineExportTask, 
			CommerceDataIntegrationProcess commerceDataIntegrationProcess) 
		throws Exception{

		InputStream inputStream =
			_batchEngineExportTaskLocalService.openContentInputStream(
				batchEngineExportTask.getBatchEngineExportTaskId());

		File tempFile = FileUtil.createTempFile(inputStream);

		_log.info("Writing export to: " + tempFile.getAbsolutePath());

		inputStream.close();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BatchEngineExportTaskMessageListener.class);

	@Reference
	private BatchEngineExportTaskLocalService
		_batchEngineExportTaskLocalService;

	@Reference
	private CommerceDataIntegrationProcessLocalService
		_commerceDataIntegrationProcessLocalService;

	@Reference
	private CommerceDataIntegrationProcessLogLocalService
		_commerceDataIntegrationProcessLogLocalService;

}