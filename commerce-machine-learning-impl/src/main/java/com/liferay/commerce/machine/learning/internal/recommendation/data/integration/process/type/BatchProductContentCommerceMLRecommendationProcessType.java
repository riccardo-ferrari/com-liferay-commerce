package com.liferay.commerce.machine.learning.internal.recommendation.data.integration.process.type;

import com.liferay.commerce.data.integration.process.type.ProcessType;
import com.liferay.commerce.machine.learning.internal.data.integration.BaseCommerceMLProcessType;
import org.osgi.service.component.annotations.Component;

/**
 * @author Riccardo Ferrari
 */
@Component(
	immediate = true,
	property = {
		"commerce.data.integration.process.type.key=" + ProductContentCommerceMLRecommendationProcessType.KEY,
		"commerce.data.integration.process.type.order=100"
	},
	service = ProcessType.class
)
public class BatchProductContentCommerceMLRecommendationProcessType
	extends BaseCommerceMLProcessType {

	public static final String KEY =
		"batch-product-content-commerce-ml-recommendation";

	@Override
	public String getKey() {
		return KEY;
	}
}
