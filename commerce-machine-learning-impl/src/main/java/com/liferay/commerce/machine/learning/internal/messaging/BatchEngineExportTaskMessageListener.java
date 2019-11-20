package com.liferay.commerce.machine.learning.internal.messaging;

import com.liferay.batch.engine.BatchEngineTaskExecuteStatus;
import com.liferay.batch.engine.model.BatchEngineExportTask;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLocalService;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLogLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Riccardo Ferrari
 */
@Component(immediate = true, service = ModelListener.class)
public class BatchEngineExportTaskMessageListener
	extends BaseModelListener<BatchEngineExportTask> {

	@Override
	public void onAfterUpdate(BatchEngineExportTask batchEngineExportTask)
		throws ModelListenerException {

		String className = batchEngineExportTask.getClassName();

		String executeStatus = batchEngineExportTask.getExecuteStatus();

		Map<String, Serializable> parameters =
			batchEngineExportTask.getParameters();

		_log.info(String.format("Export task for %s, completed with status %s", className, executeStatus));
	}

	private static Log _log = LogFactoryUtil.getLog(
		BatchEngineExportTaskMessageListener.class);

	@Reference
	private CommerceDataIntegrationProcessLocalService
		_commerceDataIntegrationProcessLocalService;

	@Reference
	private CommerceDataIntegrationProcessLogLocalService
		_commerceDataIntegrationProcessLogLocalService;
}
