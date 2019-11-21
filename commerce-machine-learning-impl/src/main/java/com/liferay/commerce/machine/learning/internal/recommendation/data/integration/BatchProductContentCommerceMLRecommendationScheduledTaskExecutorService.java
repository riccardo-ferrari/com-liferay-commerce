package com.liferay.commerce.machine.learning.internal.recommendation.data.integration;

import com.liferay.batch.engine.BatchEngineExportTaskExecutor;
import com.liferay.batch.engine.BatchEngineTaskContentType;
import com.liferay.batch.engine.BatchEngineTaskExecuteStatus;
import com.liferay.batch.engine.model.BatchEngineExportTask;
import com.liferay.batch.engine.service.BatchEngineExportTaskLocalService;
import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcess;
import com.liferay.commerce.data.integration.model.CommerceDataIntegrationProcessLog;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLocalService;
import com.liferay.commerce.data.integration.service.CommerceDataIntegrationProcessLogLocalService;
import com.liferay.commerce.data.integration.service.ScheduledTaskExecutorService;
import com.liferay.commerce.machine.learning.internal.recommendation.data.integration.process.type.BatchProductContentCommerceMLRecommendationProcessType;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Product;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.io.IOException;
import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Ferrari
 */
@Component(
	configurationPid = "com.liferay.portal.search.elasticsearch6.configuration.ElasticsearchConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	property = "data.integration.service.executor.key=" + BatchProductContentCommerceMLRecommendationProcessType.KEY,
	service = ScheduledTaskExecutorService.class
)
public class
	BatchProductContentCommerceMLRecommendationScheduledTaskExecutorService
		implements ScheduledTaskExecutorService {

	@Override
	public String getName() {
		return BatchProductContentCommerceMLRecommendationProcessType.KEY;
	}

	@Override
	public void runProcess(long commerceDataIntegrationProcessId)
		throws IOException, PortalException {

		CommerceDataIntegrationProcess commerceDataIntegrationProcess =
			_commerceDataIntegrationProcessLocalService.
				getCommerceDataIntegrationProcess(
					commerceDataIntegrationProcessId);

		Date startDate = new Date();

		CommerceDataIntegrationProcessLog commerceDataIntegrationProcessLog =
			_commerceDataIntegrationProcessLogLocalService.
				addCommerceDataIntegrationProcessLog(
					commerceDataIntegrationProcess.getUserId(),
					commerceDataIntegrationProcess.
						getCommerceDataIntegrationProcessId(),
					null, null, BackgroundTaskConstants.STATUS_IN_PROGRESS,
					startDate, null);

		try {
			BatchEngineExportTask batchEngineExportTask =
				_getBatchEngineExportTask(commerceDataIntegrationProcess);

			_batchEngineExportTaskExecutor.execute(batchEngineExportTask);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}

			_commerceDataIntegrationProcessLogLocalService.
				updateCommerceDataIntegrationProcessLog(
					commerceDataIntegrationProcessLog.
						getCommerceDataIntegrationProcessLogId(),
					e.getMessage(), null, BackgroundTaskConstants.STATUS_FAILED,
					new Date());
		}
	}

	private BatchEngineExportTask _getBatchEngineExportTask(
			CommerceDataIntegrationProcess commerceDataIntegrationProcess)
		throws PortalException {

		UnicodeProperties typeSettingsProperties =
			commerceDataIntegrationProcess.getTypeSettingsProperties();

		String batchExportTaskId = typeSettingsProperties.getProperty(
			"batch-export-task-id");

		if (batchExportTaskId != null) {
			return _batchEngineExportTaskLocalService.getBatchEngineExportTask(
				GetterUtil.getLong(batchExportTaskId));
		}

		Map<String, Serializable> parameters = new HashMap<>();

		parameters.put(
			"commerceDataIntegrationProcessId",
			commerceDataIntegrationProcess.
				getCommerceDataIntegrationProcessId());

		BatchEngineExportTask batchEngineExportTask =
			_batchEngineExportTaskLocalService.addBatchEngineExportTask(
				commerceDataIntegrationProcess.getCompanyId(),
				commerceDataIntegrationProcess.getUserId(), null,
				Product.class.getName(),
				BatchEngineTaskContentType.JSONL.name(),
				BatchEngineTaskExecuteStatus.INITIAL.name(), null, parameters,
				"v1.0");

		typeSettingsProperties.put(
			"batch-export-task-id",
			String.valueOf(batchEngineExportTask.getBatchEngineExportTaskId()));

		commerceDataIntegrationProcess.setTypeSettingsProperties(
			typeSettingsProperties);

		_commerceDataIntegrationProcessLocalService.
			updateCommerceDataIntegrationProcess(
				commerceDataIntegrationProcess);

		return batchEngineExportTask;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BatchProductContentCommerceMLRecommendationScheduledTaskExecutorService.
			class);

	@Reference
	private BatchEngineExportTaskExecutor _batchEngineExportTaskExecutor;

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