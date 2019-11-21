/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.headless.commerce.admin.catalog.internal.graphql.query.v1_0;

import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Attachment;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Catalog;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Category;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Option;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.OptionCategory;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.OptionValue;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Product;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductConfiguration;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductOption;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductOptionValue;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductShippingConfiguration;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductSpecification;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductSubscriptionConfiguration;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.ProductTaxConfiguration;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.RelatedProduct;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Sku;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Specification;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.AttachmentResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.CatalogResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.CategoryResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.OptionCategoryResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.OptionResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.OptionValueResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductConfigurationResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductOptionResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductOptionValueResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductShippingConfigurationResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductSpecificationResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductSubscriptionConfigurationResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductTaxConfigurationResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.RelatedProductResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.SkuResource;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.SpecificationResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
public class Query {

	public static void setAttachmentResourceComponentServiceObjects(
		ComponentServiceObjects<AttachmentResource>
			attachmentResourceComponentServiceObjects) {

		_attachmentResourceComponentServiceObjects =
			attachmentResourceComponentServiceObjects;
	}

	public static void setCatalogResourceComponentServiceObjects(
		ComponentServiceObjects<CatalogResource>
			catalogResourceComponentServiceObjects) {

		_catalogResourceComponentServiceObjects =
			catalogResourceComponentServiceObjects;
	}

	public static void setCategoryResourceComponentServiceObjects(
		ComponentServiceObjects<CategoryResource>
			categoryResourceComponentServiceObjects) {

		_categoryResourceComponentServiceObjects =
			categoryResourceComponentServiceObjects;
	}

	public static void setOptionResourceComponentServiceObjects(
		ComponentServiceObjects<OptionResource>
			optionResourceComponentServiceObjects) {

		_optionResourceComponentServiceObjects =
			optionResourceComponentServiceObjects;
	}

	public static void setOptionCategoryResourceComponentServiceObjects(
		ComponentServiceObjects<OptionCategoryResource>
			optionCategoryResourceComponentServiceObjects) {

		_optionCategoryResourceComponentServiceObjects =
			optionCategoryResourceComponentServiceObjects;
	}

	public static void setOptionValueResourceComponentServiceObjects(
		ComponentServiceObjects<OptionValueResource>
			optionValueResourceComponentServiceObjects) {

		_optionValueResourceComponentServiceObjects =
			optionValueResourceComponentServiceObjects;
	}

	public static void setProductResourceComponentServiceObjects(
		ComponentServiceObjects<ProductResource>
			productResourceComponentServiceObjects) {

		_productResourceComponentServiceObjects =
			productResourceComponentServiceObjects;
	}

	public static void setProductConfigurationResourceComponentServiceObjects(
		ComponentServiceObjects<ProductConfigurationResource>
			productConfigurationResourceComponentServiceObjects) {

		_productConfigurationResourceComponentServiceObjects =
			productConfigurationResourceComponentServiceObjects;
	}

	public static void setProductOptionResourceComponentServiceObjects(
		ComponentServiceObjects<ProductOptionResource>
			productOptionResourceComponentServiceObjects) {

		_productOptionResourceComponentServiceObjects =
			productOptionResourceComponentServiceObjects;
	}

	public static void setProductOptionValueResourceComponentServiceObjects(
		ComponentServiceObjects<ProductOptionValueResource>
			productOptionValueResourceComponentServiceObjects) {

		_productOptionValueResourceComponentServiceObjects =
			productOptionValueResourceComponentServiceObjects;
	}

	public static void
		setProductShippingConfigurationResourceComponentServiceObjects(
			ComponentServiceObjects<ProductShippingConfigurationResource>
				productShippingConfigurationResourceComponentServiceObjects) {

		_productShippingConfigurationResourceComponentServiceObjects =
			productShippingConfigurationResourceComponentServiceObjects;
	}

	public static void setProductSpecificationResourceComponentServiceObjects(
		ComponentServiceObjects<ProductSpecificationResource>
			productSpecificationResourceComponentServiceObjects) {

		_productSpecificationResourceComponentServiceObjects =
			productSpecificationResourceComponentServiceObjects;
	}

	public static void
		setProductSubscriptionConfigurationResourceComponentServiceObjects(
			ComponentServiceObjects<ProductSubscriptionConfigurationResource>
				productSubscriptionConfigurationResourceComponentServiceObjects) {

		_productSubscriptionConfigurationResourceComponentServiceObjects =
			productSubscriptionConfigurationResourceComponentServiceObjects;
	}

	public static void
		setProductTaxConfigurationResourceComponentServiceObjects(
			ComponentServiceObjects<ProductTaxConfigurationResource>
				productTaxConfigurationResourceComponentServiceObjects) {

		_productTaxConfigurationResourceComponentServiceObjects =
			productTaxConfigurationResourceComponentServiceObjects;
	}

	public static void setRelatedProductResourceComponentServiceObjects(
		ComponentServiceObjects<RelatedProductResource>
			relatedProductResourceComponentServiceObjects) {

		_relatedProductResourceComponentServiceObjects =
			relatedProductResourceComponentServiceObjects;
	}

	public static void setSkuResourceComponentServiceObjects(
		ComponentServiceObjects<SkuResource>
			skuResourceComponentServiceObjects) {

		_skuResourceComponentServiceObjects =
			skuResourceComponentServiceObjects;
	}

	public static void setSpecificationResourceComponentServiceObjects(
		ComponentServiceObjects<SpecificationResource>
			specificationResourceComponentServiceObjects) {

		_specificationResourceComponentServiceObjects =
			specificationResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {attachmentByExternalReferenceCode(externalReferenceCode: ___){attachment, displayDate, expirationDate, externalReferenceCode, id, neverExpire, options, priority, src, title, type}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Attachment attachmentByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_attachmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			attachmentResource ->
				attachmentResource.getAttachmentByExternalReferenceCode(
					externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {attachment(id: ___){attachment, displayDate, expirationDate, externalReferenceCode, id, neverExpire, options, priority, src, title, type}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Attachment attachment(@GraphQLName("id") Long id) throws Exception {
		return _applyComponentServiceObjects(
			_attachmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			attachmentResource -> attachmentResource.getAttachment(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeAttachments(externalReferenceCode: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AttachmentPage productByExternalReferenceCodeAttachments(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_attachmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			attachmentResource -> new AttachmentPage(
				attachmentResource.
					getProductByExternalReferenceCodeAttachmentsPage(
						externalReferenceCode, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeImages(externalReferenceCode: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AttachmentPage productByExternalReferenceCodeImages(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_attachmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			attachmentResource -> new AttachmentPage(
				attachmentResource.getProductByExternalReferenceCodeImagesPage(
					externalReferenceCode, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdAttachments(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AttachmentPage productIdAttachments(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_attachmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			attachmentResource -> new AttachmentPage(
				attachmentResource.getProductIdAttachmentsPage(
					id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdImages(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AttachmentPage productIdImages(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_attachmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			attachmentResource -> new AttachmentPage(
				attachmentResource.getProductIdImagesPage(
					id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {catalogByExternalReferenceCode(externalReferenceCode: ___){currencyCode, defaultLanguageId, externalReferenceCode, id, name, system}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Catalog catalogByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_catalogResourceComponentServiceObjects,
			this::_populateResourceContext,
			catalogResource ->
				catalogResource.getCatalogByExternalReferenceCode(
					externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {catalog(id: ___){currencyCode, defaultLanguageId, externalReferenceCode, id, name, system}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Catalog catalog(@GraphQLName("id") Long id) throws Exception {
		return _applyComponentServiceObjects(
			_catalogResourceComponentServiceObjects,
			this::_populateResourceContext,
			catalogResource -> catalogResource.getCatalog(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {catalogs(filter: ___, page: ___, pageSize: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CatalogPage catalogs(
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_catalogResourceComponentServiceObjects,
			this::_populateResourceContext,
			catalogResource -> new CatalogPage(
				catalogResource.getCatalogsPage(
					_filterBiFunction.apply(catalogResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(catalogResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeCategories(externalReferenceCode: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CategoryPage productByExternalReferenceCodeCategories(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_categoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			categoryResource -> new CategoryPage(
				categoryResource.
					getProductByExternalReferenceCodeCategoriesPage(
						externalReferenceCode, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdCategories(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CategoryPage productIdCategories(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_categoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			categoryResource -> new CategoryPage(
				categoryResource.getProductIdCategoriesPage(
					id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {options(filter: ___, page: ___, pageSize: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public OptionPage options(
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_optionResourceComponentServiceObjects,
			this::_populateResourceContext,
			optionResource -> new OptionPage(
				optionResource.getOptionsPage(
					_filterBiFunction.apply(optionResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(optionResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {optionByExternalReferenceCode(externalReferenceCode: ___){catalogId, description, externalReferenceCode, facetable, fieldType, id, key, name, priority, required, skuContributor, optionValues}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Option optionByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_optionResourceComponentServiceObjects,
			this::_populateResourceContext,
			optionResource -> optionResource.getOptionByExternalReferenceCode(
				externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {option(id: ___){catalogId, description, externalReferenceCode, facetable, fieldType, id, key, name, priority, required, skuContributor, optionValues}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Option option(@GraphQLName("id") Long id) throws Exception {
		return _applyComponentServiceObjects(
			_optionResourceComponentServiceObjects,
			this::_populateResourceContext,
			optionResource -> optionResource.getOption(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {optionCategories(filter: ___, page: ___, pageSize: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public OptionCategoryPage optionCategories(
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_optionCategoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			optionCategoryResource -> new OptionCategoryPage(
				optionCategoryResource.getOptionCategoriesPage(
					_filterBiFunction.apply(
						optionCategoryResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(
						optionCategoryResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {optionCategory(id: ___){description, id, key, priority, title}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public OptionCategory optionCategory(@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_optionCategoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			optionCategoryResource -> optionCategoryResource.getOptionCategory(
				id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {optionByExternalReferenceCodeOptionValues(externalReferenceCode: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public OptionValuePage optionByExternalReferenceCodeOptionValues(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_optionValueResourceComponentServiceObjects,
			this::_populateResourceContext,
			optionValueResource -> new OptionValuePage(
				optionValueResource.
					getOptionByExternalReferenceCodeOptionValuesPage(
						externalReferenceCode, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {optionIdOptionValues(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public OptionValuePage optionIdOptionValues(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_optionValueResourceComponentServiceObjects,
			this::_populateResourceContext,
			optionValueResource -> new OptionValuePage(
				optionValueResource.getOptionIdOptionValuesPage(
					id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {products(filter: ___, page: ___, pageSize: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductPage products(
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_productResourceComponentServiceObjects,
			this::_populateResourceContext,
			productResource -> new ProductPage(
				productResource.getProductsPage(
					_filterBiFunction.apply(productResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(productResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCode(externalReferenceCode: ___){active, catalogId, categories, configuration, createDate, defaultSku, description, displayDate, expando, expirationDate, externalReferenceCode, id, attachments, metaDescription, metaKeyword, metaTitle, modifiedDate, name, neverExpire, productOptions, productId, productSpecifications, productType, relatedProducts, shippingConfiguration, shortDescription, skus, subscriptionConfiguration, tags, taxConfiguration, urls}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Product productByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_productResourceComponentServiceObjects,
			this::_populateResourceContext,
			productResource ->
				productResource.getProductByExternalReferenceCode(
					externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {product(id: ___){active, catalogId, categories, configuration, createDate, defaultSku, description, displayDate, expando, expirationDate, externalReferenceCode, id, attachments, metaDescription, metaKeyword, metaTitle, modifiedDate, name, neverExpire, productOptions, productId, productSpecifications, productType, relatedProducts, shippingConfiguration, shortDescription, skus, subscriptionConfiguration, tags, taxConfiguration, urls}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Product product(@GraphQLName("id") Long id) throws Exception {
		return _applyComponentServiceObjects(
			_productResourceComponentServiceObjects,
			this::_populateResourceContext,
			productResource -> productResource.getProduct(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeConfiguration(externalReferenceCode: ___){allowBackOrder, allowedOrderQuantities, displayAvailability, displayStockQuantity, inventoryEngine, lowStockAction, maxOrderQuantity, minOrderQuantity, minStockQuantity, multipleOrderQuantity}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductConfiguration productByExternalReferenceCodeConfiguration(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_productConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productConfigurationResource ->
				productConfigurationResource.
					getProductByExternalReferenceCodeConfiguration(
						externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdConfiguration(id: ___){allowBackOrder, allowedOrderQuantities, displayAvailability, displayStockQuantity, inventoryEngine, lowStockAction, maxOrderQuantity, minOrderQuantity, minStockQuantity, multipleOrderQuantity}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductConfiguration productIdConfiguration(
			@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_productConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productConfigurationResource ->
				productConfigurationResource.getProductIdConfiguration(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productOption(id: ___){catalogId, description, facetable, fieldType, id, key, name, optionId, priority, required, skuContributor, productOptionValues}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductOption productOption(@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_productOptionResourceComponentServiceObjects,
			this::_populateResourceContext,
			productOptionResource -> productOptionResource.getProductOption(
				id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeProductOptions(externalReferenceCode: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductOptionPage productByExternalReferenceCodeProductOptions(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productOptionResourceComponentServiceObjects,
			this::_populateResourceContext,
			productOptionResource -> new ProductOptionPage(
				productOptionResource.
					getProductByExternalReferenceCodeProductOptionsPage(
						externalReferenceCode, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdProductOptions(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductOptionPage productIdProductOptions(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productOptionResourceComponentServiceObjects,
			this::_populateResourceContext,
			productOptionResource -> new ProductOptionPage(
				productOptionResource.getProductIdProductOptionsPage(
					id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productOptionIdProductOptionValues(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductOptionValuePage productOptionIdProductOptionValues(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productOptionValueResourceComponentServiceObjects,
			this::_populateResourceContext,
			productOptionValueResource -> new ProductOptionValuePage(
				productOptionValueResource.
					getProductOptionIdProductOptionValuesPage(
						id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeShippingConfiguration(externalReferenceCode: ___){depth, freeShipping, height, shippable, shippingExtraPrice, shippingSeparately, weight, width}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductShippingConfiguration
			productByExternalReferenceCodeShippingConfiguration(
				@GraphQLName("externalReferenceCode") String
					externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_productShippingConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productShippingConfigurationResource ->
				productShippingConfigurationResource.
					getProductByExternalReferenceCodeShippingConfiguration(
						externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdShippingConfiguration(id: ___){depth, freeShipping, height, shippable, shippingExtraPrice, shippingSeparately, weight, width}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductShippingConfiguration productIdShippingConfiguration(
			@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_productShippingConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productShippingConfigurationResource ->
				productShippingConfigurationResource.
					getProductIdShippingConfiguration(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdProductSpecifications(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductSpecificationPage productIdProductSpecifications(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_productSpecificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productSpecificationResource -> new ProductSpecificationPage(
				productSpecificationResource.
					getProductIdProductSpecificationsPage(
						id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeSubscriptionConfiguration(externalReferenceCode: ___){enable, length, numberOfLength, subscriptionType, subscriptionTypeSettings}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductSubscriptionConfiguration
			productByExternalReferenceCodeSubscriptionConfiguration(
				@GraphQLName("externalReferenceCode") String
					externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_productSubscriptionConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productSubscriptionConfigurationResource ->
				productSubscriptionConfigurationResource.
					getProductByExternalReferenceCodeSubscriptionConfiguration(
						externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdSubscriptionConfiguration(id: ___){enable, length, numberOfLength, subscriptionType, subscriptionTypeSettings}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductSubscriptionConfiguration productIdSubscriptionConfiguration(
			@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_productSubscriptionConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productSubscriptionConfigurationResource ->
				productSubscriptionConfigurationResource.
					getProductIdSubscriptionConfiguration(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeTaxConfiguration(externalReferenceCode: ___){id, taxCategory, taxable}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductTaxConfiguration
			productByExternalReferenceCodeTaxConfiguration(
				@GraphQLName("externalReferenceCode") String
					externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_productTaxConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productTaxConfigurationResource ->
				productTaxConfigurationResource.
					getProductByExternalReferenceCodeTaxConfiguration(
						externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdTaxConfiguration(id: ___){id, taxCategory, taxable}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductTaxConfiguration productIdTaxConfiguration(
			@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_productTaxConfigurationResourceComponentServiceObjects,
			this::_populateResourceContext,
			productTaxConfigurationResource ->
				productTaxConfigurationResource.getProductIdTaxConfiguration(
					id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeRelatedProducts(externalReferenceCode: ___, page: ___, pageSize: ___, type: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public RelatedProductPage productByExternalReferenceCodeRelatedProducts(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("type") String type,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_relatedProductResourceComponentServiceObjects,
			this::_populateResourceContext,
			relatedProductResource -> new RelatedProductPage(
				relatedProductResource.
					getProductByExternalReferenceCodeRelatedProductsPage(
						externalReferenceCode, type,
						Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdRelatedProducts(id: ___, page: ___, pageSize: ___, type: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public RelatedProductPage productIdRelatedProducts(
			@GraphQLName("id") Long id, @GraphQLName("type") String type,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_relatedProductResourceComponentServiceObjects,
			this::_populateResourceContext,
			relatedProductResource -> new RelatedProductPage(
				relatedProductResource.getProductIdRelatedProductsPage(
					id, type, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {relatedProduct(id: ___){id, priority, productExternalReferenceCode, productId, type}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public RelatedProduct relatedProduct(@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_relatedProductResourceComponentServiceObjects,
			this::_populateResourceContext,
			relatedProductResource -> relatedProductResource.getRelatedProduct(
				id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productByExternalReferenceCodeSkus(externalReferenceCode: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public SkuPage productByExternalReferenceCodeSkus(
			@GraphQLName("externalReferenceCode") String externalReferenceCode,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_skuResourceComponentServiceObjects, this::_populateResourceContext,
			skuResource -> new SkuPage(
				skuResource.getProductByExternalReferenceCodeSkusPage(
					externalReferenceCode, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productIdSkus(id: ___, page: ___, pageSize: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public SkuPage productIdSkus(
			@GraphQLName("id") Long id, @GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_skuResourceComponentServiceObjects, this::_populateResourceContext,
			skuResource -> new SkuPage(
				skuResource.getProductIdSkusPage(
					id, Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {skuByExternalReferenceCode(externalReferenceCode: ___){cost, depth, displayDate, expirationDate, externalReferenceCode, gtin, height, id, inventoryLevel, manufacturerPartNumber, neverExpire, options, price, productId, promoPrice, published, purchasable, sku, weight, width}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Sku skuByExternalReferenceCode(
			@GraphQLName("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return _applyComponentServiceObjects(
			_skuResourceComponentServiceObjects, this::_populateResourceContext,
			skuResource -> skuResource.getSkuByExternalReferenceCode(
				externalReferenceCode));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {sku(id: ___){cost, depth, displayDate, expirationDate, externalReferenceCode, gtin, height, id, inventoryLevel, manufacturerPartNumber, neverExpire, options, price, productId, promoPrice, published, purchasable, sku, weight, width}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Sku sku(@GraphQLName("id") Long id) throws Exception {
		return _applyComponentServiceObjects(
			_skuResourceComponentServiceObjects, this::_populateResourceContext,
			skuResource -> skuResource.getSku(id));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {specifications(filter: ___, page: ___, pageSize: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public SpecificationPage specifications(
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_specificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			specificationResource -> new SpecificationPage(
				specificationResource.getSpecificationsPage(
					_filterBiFunction.apply(
						specificationResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(
						specificationResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {specification(id: ___){description, facetable, id, key, optionCategory, title}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Specification specification(@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_specificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			specificationResource -> specificationResource.getSpecification(
				id));
	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductByExternalReferenceCodeConfigurationTypeExtension {

		public GetProductByExternalReferenceCodeConfigurationTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductConfiguration
				productByExternalReferenceCodeConfiguration()
			throws Exception {

			return _applyComponentServiceObjects(
				_productConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productConfigurationResource ->
					productConfigurationResource.
						getProductByExternalReferenceCodeConfiguration(
							_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductByExternalReferenceCodeTypeExtension {

		public GetProductByExternalReferenceCodeTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public Product productByExternalReferenceCode() throws Exception {
			return _applyComponentServiceObjects(
				_productResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productResource ->
					productResource.getProductByExternalReferenceCode(
						_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductByExternalReferenceCodeCategoriesPageTypeExtension {

		public GetProductByExternalReferenceCodeCategoriesPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public CategoryPage productByExternalReferenceCodeCategories(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_categoryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				categoryResource -> new CategoryPage(
					categoryResource.
						getProductByExternalReferenceCodeCategoriesPage(
							_attachment.getExternalReferenceCode(),
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetSpecificationTypeExtension {

		public GetSpecificationTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public Specification specification() throws Exception {
			return _applyComponentServiceObjects(
				_specificationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				specificationResource -> specificationResource.getSpecification(
					_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdProductSpecificationsPageTypeExtension {

		public GetProductIdProductSpecificationsPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductSpecificationPage productIdProductSpecifications(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_productSpecificationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productSpecificationResource -> new ProductSpecificationPage(
					productSpecificationResource.
						getProductIdProductSpecificationsPage(
							_attachment.getId(),
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdConfigurationTypeExtension {

		public GetProductIdConfigurationTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public ProductConfiguration productIdConfiguration() throws Exception {
			return _applyComponentServiceObjects(
				_productConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productConfigurationResource ->
					productConfigurationResource.getProductIdConfiguration(
						_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdRelatedProductsPageTypeExtension {

		public GetProductIdRelatedProductsPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public RelatedProductPage productIdRelatedProducts(
				@GraphQLName("type") String type,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_relatedProductResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				relatedProductResource -> new RelatedProductPage(
					relatedProductResource.getProductIdRelatedProductsPage(
						_attachment.getId(), type,
						Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductOptionIdProductOptionValuesPageTypeExtension {

		public GetProductOptionIdProductOptionValuesPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductOptionValuePage productOptionIdProductOptionValues(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_productOptionValueResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productOptionValueResource -> new ProductOptionValuePage(
					productOptionValueResource.
						getProductOptionIdProductOptionValuesPage(
							_attachment.getId(),
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetOptionTypeExtension {

		public GetOptionTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public Option option() throws Exception {
			return _applyComponentServiceObjects(
				_optionResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				optionResource -> optionResource.getOption(
					_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetCatalogByExternalReferenceCodeTypeExtension {

		public GetCatalogByExternalReferenceCodeTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public Catalog catalogByExternalReferenceCode() throws Exception {
			return _applyComponentServiceObjects(
				_catalogResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				catalogResource ->
					catalogResource.getCatalogByExternalReferenceCode(
						_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductOptionTypeExtension {

		public GetProductOptionTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public ProductOption productOption() throws Exception {
			return _applyComponentServiceObjects(
				_productOptionResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productOptionResource -> productOptionResource.getProductOption(
					_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetCatalogTypeExtension {

		public GetCatalogTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public Catalog catalog() throws Exception {
			return _applyComponentServiceObjects(
				_catalogResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				catalogResource -> catalogResource.getCatalog(
					_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductByExternalReferenceCodeSkusPageTypeExtension {

		public GetProductByExternalReferenceCodeSkusPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public SkuPage productByExternalReferenceCodeSkus(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_skuResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				skuResource -> new SkuPage(
					skuResource.getProductByExternalReferenceCodeSkusPage(
						_attachment.getExternalReferenceCode(),
						Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdShippingConfigurationTypeExtension {

		public GetProductIdShippingConfigurationTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductShippingConfiguration productIdShippingConfiguration()
			throws Exception {

			return _applyComponentServiceObjects(
				_productShippingConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productShippingConfigurationResource ->
					productShippingConfigurationResource.
						getProductIdShippingConfiguration(_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetRelatedProductTypeExtension {

		public GetRelatedProductTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public RelatedProduct relatedProduct() throws Exception {
			return _applyComponentServiceObjects(
				_relatedProductResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				relatedProductResource ->
					relatedProductResource.getRelatedProduct(
						_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Catalog.class)
	public class GetAttachmentByExternalReferenceCodeTypeExtension {

		public GetAttachmentByExternalReferenceCodeTypeExtension(
			Catalog catalog) {

			_catalog = catalog;
		}

		@GraphQLField
		public Attachment attachmentByExternalReferenceCode() throws Exception {
			return _applyComponentServiceObjects(
				_attachmentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				attachmentResource ->
					attachmentResource.getAttachmentByExternalReferenceCode(
						_catalog.getExternalReferenceCode()));
		}

		private Catalog _catalog;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class
		GetProductByExternalReferenceCodeShippingConfigurationTypeExtension {

		public GetProductByExternalReferenceCodeShippingConfigurationTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductShippingConfiguration
				productByExternalReferenceCodeShippingConfiguration()
			throws Exception {

			return _applyComponentServiceObjects(
				_productShippingConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productShippingConfigurationResource ->
					productShippingConfigurationResource.
						getProductByExternalReferenceCodeShippingConfiguration(
							_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetSkuByExternalReferenceCodeTypeExtension {

		public GetSkuByExternalReferenceCodeTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public Sku skuByExternalReferenceCode() throws Exception {
			return _applyComponentServiceObjects(
				_skuResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				skuResource -> skuResource.getSkuByExternalReferenceCode(
					_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdTaxConfigurationTypeExtension {

		public GetProductIdTaxConfigurationTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductTaxConfiguration productIdTaxConfiguration()
			throws Exception {

			return _applyComponentServiceObjects(
				_productTaxConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productTaxConfigurationResource ->
					productTaxConfigurationResource.
						getProductIdTaxConfiguration(_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdCategoriesPageTypeExtension {

		public GetProductIdCategoriesPageTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public CategoryPage productIdCategories(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_categoryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				categoryResource -> new CategoryPage(
					categoryResource.getProductIdCategoriesPage(
						_attachment.getId(), Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductByExternalReferenceCodeAttachmentsPageTypeExtension {

		public GetProductByExternalReferenceCodeAttachmentsPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public AttachmentPage productByExternalReferenceCodeAttachments(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_attachmentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				attachmentResource -> new AttachmentPage(
					attachmentResource.
						getProductByExternalReferenceCodeAttachmentsPage(
							_attachment.getExternalReferenceCode(),
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdProductOptionsPageTypeExtension {

		public GetProductIdProductOptionsPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductOptionPage productIdProductOptions(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_productOptionResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productOptionResource -> new ProductOptionPage(
					productOptionResource.getProductIdProductOptionsPage(
						_attachment.getId(), Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Catalog.class)
	public class GetAttachmentTypeExtension {

		public GetAttachmentTypeExtension(Catalog catalog) {
			_catalog = catalog;
		}

		@GraphQLField
		public Attachment attachment() throws Exception {
			return _applyComponentServiceObjects(
				_attachmentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				attachmentResource -> attachmentResource.getAttachment(
					_catalog.getId()));
		}

		private Catalog _catalog;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetOptionByExternalReferenceCodeOptionValuesPageTypeExtension {

		public GetOptionByExternalReferenceCodeOptionValuesPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public OptionValuePage optionByExternalReferenceCodeOptionValues(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_optionValueResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				optionValueResource -> new OptionValuePage(
					optionValueResource.
						getOptionByExternalReferenceCodeOptionValuesPage(
							_attachment.getExternalReferenceCode(),
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductTypeExtension {

		public GetProductTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public Product product() throws Exception {
			return _applyComponentServiceObjects(
				_productResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productResource -> productResource.getProduct(
					_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdImagesPageTypeExtension {

		public GetProductIdImagesPageTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public AttachmentPage productIdImages(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_attachmentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				attachmentResource -> new AttachmentPage(
					attachmentResource.getProductIdImagesPage(
						_attachment.getId(), Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetOptionIdOptionValuesPageTypeExtension {

		public GetOptionIdOptionValuesPageTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public OptionValuePage optionIdOptionValues(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_optionValueResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				optionValueResource -> new OptionValuePage(
					optionValueResource.getOptionIdOptionValuesPage(
						_attachment.getId(), Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdAttachmentsPageTypeExtension {

		public GetProductIdAttachmentsPageTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public AttachmentPage productIdAttachments(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_attachmentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				attachmentResource -> new AttachmentPage(
					attachmentResource.getProductIdAttachmentsPage(
						_attachment.getId(), Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class
		GetProductByExternalReferenceCodeProductOptionsPageTypeExtension {

		public GetProductByExternalReferenceCodeProductOptionsPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductOptionPage productByExternalReferenceCodeProductOptions(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_productOptionResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productOptionResource -> new ProductOptionPage(
					productOptionResource.
						getProductByExternalReferenceCodeProductOptionsPage(
							_attachment.getExternalReferenceCode(),
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class
		GetProductByExternalReferenceCodeRelatedProductsPageTypeExtension {

		public GetProductByExternalReferenceCodeRelatedProductsPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public RelatedProductPage productByExternalReferenceCodeRelatedProducts(
				@GraphQLName("type") String type,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_relatedProductResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				relatedProductResource -> new RelatedProductPage(
					relatedProductResource.
						getProductByExternalReferenceCodeRelatedProductsPage(
							_attachment.getExternalReferenceCode(), type,
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetSkuTypeExtension {

		public GetSkuTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public Sku sku() throws Exception {
			return _applyComponentServiceObjects(
				_skuResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				skuResource -> skuResource.getSku(_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetOptionCategoryTypeExtension {

		public GetOptionCategoryTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public OptionCategory optionCategory() throws Exception {
			return _applyComponentServiceObjects(
				_optionCategoryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				optionCategoryResource ->
					optionCategoryResource.getOptionCategory(
						_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class
		GetProductByExternalReferenceCodeTaxConfigurationTypeExtension {

		public GetProductByExternalReferenceCodeTaxConfigurationTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductTaxConfiguration
				productByExternalReferenceCodeTaxConfiguration()
			throws Exception {

			return _applyComponentServiceObjects(
				_productTaxConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productTaxConfigurationResource ->
					productTaxConfigurationResource.
						getProductByExternalReferenceCodeTaxConfiguration(
							_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdSkusPageTypeExtension {

		public GetProductIdSkusPageTypeExtension(Attachment attachment) {
			_attachment = attachment;
		}

		@GraphQLField
		public SkuPage productIdSkus(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_skuResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				skuResource -> new SkuPage(
					skuResource.getProductIdSkusPage(
						_attachment.getId(), Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductByExternalReferenceCodeImagesPageTypeExtension {

		public GetProductByExternalReferenceCodeImagesPageTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public AttachmentPage productByExternalReferenceCodeImages(
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page)
			throws Exception {

			return _applyComponentServiceObjects(
				_attachmentResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				attachmentResource -> new AttachmentPage(
					attachmentResource.
						getProductByExternalReferenceCodeImagesPage(
							_attachment.getExternalReferenceCode(),
							Pagination.of(page, pageSize))));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetOptionByExternalReferenceCodeTypeExtension {

		public GetOptionByExternalReferenceCodeTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public Option optionByExternalReferenceCode() throws Exception {
			return _applyComponentServiceObjects(
				_optionResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				optionResource ->
					optionResource.getOptionByExternalReferenceCode(
						_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class
		GetProductByExternalReferenceCodeSubscriptionConfigurationTypeExtension {

		public GetProductByExternalReferenceCodeSubscriptionConfigurationTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductSubscriptionConfiguration
				productByExternalReferenceCodeSubscriptionConfiguration()
			throws Exception {

			return _applyComponentServiceObjects(
				_productSubscriptionConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productSubscriptionConfigurationResource ->
					productSubscriptionConfigurationResource.
						getProductByExternalReferenceCodeSubscriptionConfiguration(
							_attachment.getExternalReferenceCode()));
		}

		private Attachment _attachment;

	}

	@GraphQLTypeExtension(Attachment.class)
	public class GetProductIdSubscriptionConfigurationTypeExtension {

		public GetProductIdSubscriptionConfigurationTypeExtension(
			Attachment attachment) {

			_attachment = attachment;
		}

		@GraphQLField
		public ProductSubscriptionConfiguration
				productIdSubscriptionConfiguration()
			throws Exception {

			return _applyComponentServiceObjects(
				_productSubscriptionConfigurationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				productSubscriptionConfigurationResource ->
					productSubscriptionConfigurationResource.
						getProductIdSubscriptionConfiguration(
							_attachment.getId()));
		}

		private Attachment _attachment;

	}

	@GraphQLName("AttachmentPage")
	public class AttachmentPage {

		public AttachmentPage(Page attachmentPage) {
			items = attachmentPage.getItems();
			page = attachmentPage.getPage();
			pageSize = attachmentPage.getPageSize();
			totalCount = attachmentPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Attachment> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("CatalogPage")
	public class CatalogPage {

		public CatalogPage(Page catalogPage) {
			items = catalogPage.getItems();
			page = catalogPage.getPage();
			pageSize = catalogPage.getPageSize();
			totalCount = catalogPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Catalog> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("CategoryPage")
	public class CategoryPage {

		public CategoryPage(Page categoryPage) {
			items = categoryPage.getItems();
			page = categoryPage.getPage();
			pageSize = categoryPage.getPageSize();
			totalCount = categoryPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Category> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("OptionPage")
	public class OptionPage {

		public OptionPage(Page optionPage) {
			items = optionPage.getItems();
			page = optionPage.getPage();
			pageSize = optionPage.getPageSize();
			totalCount = optionPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Option> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("OptionCategoryPage")
	public class OptionCategoryPage {

		public OptionCategoryPage(Page optionCategoryPage) {
			items = optionCategoryPage.getItems();
			page = optionCategoryPage.getPage();
			pageSize = optionCategoryPage.getPageSize();
			totalCount = optionCategoryPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<OptionCategory> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("OptionValuePage")
	public class OptionValuePage {

		public OptionValuePage(Page optionValuePage) {
			items = optionValuePage.getItems();
			page = optionValuePage.getPage();
			pageSize = optionValuePage.getPageSize();
			totalCount = optionValuePage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<OptionValue> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductPage")
	public class ProductPage {

		public ProductPage(Page productPage) {
			items = productPage.getItems();
			page = productPage.getPage();
			pageSize = productPage.getPageSize();
			totalCount = productPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Product> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductConfigurationPage")
	public class ProductConfigurationPage {

		public ProductConfigurationPage(Page productConfigurationPage) {
			items = productConfigurationPage.getItems();
			page = productConfigurationPage.getPage();
			pageSize = productConfigurationPage.getPageSize();
			totalCount = productConfigurationPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<ProductConfiguration> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductOptionPage")
	public class ProductOptionPage {

		public ProductOptionPage(Page productOptionPage) {
			items = productOptionPage.getItems();
			page = productOptionPage.getPage();
			pageSize = productOptionPage.getPageSize();
			totalCount = productOptionPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<ProductOption> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductOptionValuePage")
	public class ProductOptionValuePage {

		public ProductOptionValuePage(Page productOptionValuePage) {
			items = productOptionValuePage.getItems();
			page = productOptionValuePage.getPage();
			pageSize = productOptionValuePage.getPageSize();
			totalCount = productOptionValuePage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<ProductOptionValue> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductShippingConfigurationPage")
	public class ProductShippingConfigurationPage {

		public ProductShippingConfigurationPage(
			Page productShippingConfigurationPage) {

			items = productShippingConfigurationPage.getItems();
			page = productShippingConfigurationPage.getPage();
			pageSize = productShippingConfigurationPage.getPageSize();
			totalCount = productShippingConfigurationPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<ProductShippingConfiguration> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductSpecificationPage")
	public class ProductSpecificationPage {

		public ProductSpecificationPage(Page productSpecificationPage) {
			items = productSpecificationPage.getItems();
			page = productSpecificationPage.getPage();
			pageSize = productSpecificationPage.getPageSize();
			totalCount = productSpecificationPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<ProductSpecification> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductSubscriptionConfigurationPage")
	public class ProductSubscriptionConfigurationPage {

		public ProductSubscriptionConfigurationPage(
			Page productSubscriptionConfigurationPage) {

			items = productSubscriptionConfigurationPage.getItems();
			page = productSubscriptionConfigurationPage.getPage();
			pageSize = productSubscriptionConfigurationPage.getPageSize();
			totalCount = productSubscriptionConfigurationPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<ProductSubscriptionConfiguration> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductTaxConfigurationPage")
	public class ProductTaxConfigurationPage {

		public ProductTaxConfigurationPage(Page productTaxConfigurationPage) {
			items = productTaxConfigurationPage.getItems();
			page = productTaxConfigurationPage.getPage();
			pageSize = productTaxConfigurationPage.getPageSize();
			totalCount = productTaxConfigurationPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<ProductTaxConfiguration> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("RelatedProductPage")
	public class RelatedProductPage {

		public RelatedProductPage(Page relatedProductPage) {
			items = relatedProductPage.getItems();
			page = relatedProductPage.getPage();
			pageSize = relatedProductPage.getPageSize();
			totalCount = relatedProductPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<RelatedProduct> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("SkuPage")
	public class SkuPage {

		public SkuPage(Page skuPage) {
			items = skuPage.getItems();
			page = skuPage.getPage();
			pageSize = skuPage.getPageSize();
			totalCount = skuPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Sku> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("SpecificationPage")
	public class SpecificationPage {

		public SpecificationPage(Page specificationPage) {
			items = specificationPage.getItems();
			page = specificationPage.getPage();
			pageSize = specificationPage.getPageSize();
			totalCount = specificationPage.getTotalCount();
		}

		@GraphQLField
		protected java.util.Collection<Specification> items;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(AttachmentResource attachmentResource)
		throws Exception {

		attachmentResource.setContextAcceptLanguage(_acceptLanguage);
		attachmentResource.setContextCompany(_company);
		attachmentResource.setContextHttpServletRequest(_httpServletRequest);
		attachmentResource.setContextHttpServletResponse(_httpServletResponse);
		attachmentResource.setContextUriInfo(_uriInfo);
		attachmentResource.setContextUser(_user);
	}

	private void _populateResourceContext(CatalogResource catalogResource)
		throws Exception {

		catalogResource.setContextAcceptLanguage(_acceptLanguage);
		catalogResource.setContextCompany(_company);
		catalogResource.setContextHttpServletRequest(_httpServletRequest);
		catalogResource.setContextHttpServletResponse(_httpServletResponse);
		catalogResource.setContextUriInfo(_uriInfo);
		catalogResource.setContextUser(_user);
	}

	private void _populateResourceContext(CategoryResource categoryResource)
		throws Exception {

		categoryResource.setContextAcceptLanguage(_acceptLanguage);
		categoryResource.setContextCompany(_company);
		categoryResource.setContextHttpServletRequest(_httpServletRequest);
		categoryResource.setContextHttpServletResponse(_httpServletResponse);
		categoryResource.setContextUriInfo(_uriInfo);
		categoryResource.setContextUser(_user);
	}

	private void _populateResourceContext(OptionResource optionResource)
		throws Exception {

		optionResource.setContextAcceptLanguage(_acceptLanguage);
		optionResource.setContextCompany(_company);
		optionResource.setContextHttpServletRequest(_httpServletRequest);
		optionResource.setContextHttpServletResponse(_httpServletResponse);
		optionResource.setContextUriInfo(_uriInfo);
		optionResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			OptionCategoryResource optionCategoryResource)
		throws Exception {

		optionCategoryResource.setContextAcceptLanguage(_acceptLanguage);
		optionCategoryResource.setContextCompany(_company);
		optionCategoryResource.setContextHttpServletRequest(
			_httpServletRequest);
		optionCategoryResource.setContextHttpServletResponse(
			_httpServletResponse);
		optionCategoryResource.setContextUriInfo(_uriInfo);
		optionCategoryResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			OptionValueResource optionValueResource)
		throws Exception {

		optionValueResource.setContextAcceptLanguage(_acceptLanguage);
		optionValueResource.setContextCompany(_company);
		optionValueResource.setContextHttpServletRequest(_httpServletRequest);
		optionValueResource.setContextHttpServletResponse(_httpServletResponse);
		optionValueResource.setContextUriInfo(_uriInfo);
		optionValueResource.setContextUser(_user);
	}

	private void _populateResourceContext(ProductResource productResource)
		throws Exception {

		productResource.setContextAcceptLanguage(_acceptLanguage);
		productResource.setContextCompany(_company);
		productResource.setContextHttpServletRequest(_httpServletRequest);
		productResource.setContextHttpServletResponse(_httpServletResponse);
		productResource.setContextUriInfo(_uriInfo);
		productResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			ProductConfigurationResource productConfigurationResource)
		throws Exception {

		productConfigurationResource.setContextAcceptLanguage(_acceptLanguage);
		productConfigurationResource.setContextCompany(_company);
		productConfigurationResource.setContextHttpServletRequest(
			_httpServletRequest);
		productConfigurationResource.setContextHttpServletResponse(
			_httpServletResponse);
		productConfigurationResource.setContextUriInfo(_uriInfo);
		productConfigurationResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			ProductOptionResource productOptionResource)
		throws Exception {

		productOptionResource.setContextAcceptLanguage(_acceptLanguage);
		productOptionResource.setContextCompany(_company);
		productOptionResource.setContextHttpServletRequest(_httpServletRequest);
		productOptionResource.setContextHttpServletResponse(
			_httpServletResponse);
		productOptionResource.setContextUriInfo(_uriInfo);
		productOptionResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			ProductOptionValueResource productOptionValueResource)
		throws Exception {

		productOptionValueResource.setContextAcceptLanguage(_acceptLanguage);
		productOptionValueResource.setContextCompany(_company);
		productOptionValueResource.setContextHttpServletRequest(
			_httpServletRequest);
		productOptionValueResource.setContextHttpServletResponse(
			_httpServletResponse);
		productOptionValueResource.setContextUriInfo(_uriInfo);
		productOptionValueResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			ProductShippingConfigurationResource
				productShippingConfigurationResource)
		throws Exception {

		productShippingConfigurationResource.setContextAcceptLanguage(
			_acceptLanguage);
		productShippingConfigurationResource.setContextCompany(_company);
		productShippingConfigurationResource.setContextHttpServletRequest(
			_httpServletRequest);
		productShippingConfigurationResource.setContextHttpServletResponse(
			_httpServletResponse);
		productShippingConfigurationResource.setContextUriInfo(_uriInfo);
		productShippingConfigurationResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			ProductSpecificationResource productSpecificationResource)
		throws Exception {

		productSpecificationResource.setContextAcceptLanguage(_acceptLanguage);
		productSpecificationResource.setContextCompany(_company);
		productSpecificationResource.setContextHttpServletRequest(
			_httpServletRequest);
		productSpecificationResource.setContextHttpServletResponse(
			_httpServletResponse);
		productSpecificationResource.setContextUriInfo(_uriInfo);
		productSpecificationResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			ProductSubscriptionConfigurationResource
				productSubscriptionConfigurationResource)
		throws Exception {

		productSubscriptionConfigurationResource.setContextAcceptLanguage(
			_acceptLanguage);
		productSubscriptionConfigurationResource.setContextCompany(_company);
		productSubscriptionConfigurationResource.setContextHttpServletRequest(
			_httpServletRequest);
		productSubscriptionConfigurationResource.setContextHttpServletResponse(
			_httpServletResponse);
		productSubscriptionConfigurationResource.setContextUriInfo(_uriInfo);
		productSubscriptionConfigurationResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			ProductTaxConfigurationResource productTaxConfigurationResource)
		throws Exception {

		productTaxConfigurationResource.setContextAcceptLanguage(
			_acceptLanguage);
		productTaxConfigurationResource.setContextCompany(_company);
		productTaxConfigurationResource.setContextHttpServletRequest(
			_httpServletRequest);
		productTaxConfigurationResource.setContextHttpServletResponse(
			_httpServletResponse);
		productTaxConfigurationResource.setContextUriInfo(_uriInfo);
		productTaxConfigurationResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			RelatedProductResource relatedProductResource)
		throws Exception {

		relatedProductResource.setContextAcceptLanguage(_acceptLanguage);
		relatedProductResource.setContextCompany(_company);
		relatedProductResource.setContextHttpServletRequest(
			_httpServletRequest);
		relatedProductResource.setContextHttpServletResponse(
			_httpServletResponse);
		relatedProductResource.setContextUriInfo(_uriInfo);
		relatedProductResource.setContextUser(_user);
	}

	private void _populateResourceContext(SkuResource skuResource)
		throws Exception {

		skuResource.setContextAcceptLanguage(_acceptLanguage);
		skuResource.setContextCompany(_company);
		skuResource.setContextHttpServletRequest(_httpServletRequest);
		skuResource.setContextHttpServletResponse(_httpServletResponse);
		skuResource.setContextUriInfo(_uriInfo);
		skuResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			SpecificationResource specificationResource)
		throws Exception {

		specificationResource.setContextAcceptLanguage(_acceptLanguage);
		specificationResource.setContextCompany(_company);
		specificationResource.setContextHttpServletRequest(_httpServletRequest);
		specificationResource.setContextHttpServletResponse(
			_httpServletResponse);
		specificationResource.setContextUriInfo(_uriInfo);
		specificationResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<AttachmentResource>
		_attachmentResourceComponentServiceObjects;
	private static ComponentServiceObjects<CatalogResource>
		_catalogResourceComponentServiceObjects;
	private static ComponentServiceObjects<CategoryResource>
		_categoryResourceComponentServiceObjects;
	private static ComponentServiceObjects<OptionResource>
		_optionResourceComponentServiceObjects;
	private static ComponentServiceObjects<OptionCategoryResource>
		_optionCategoryResourceComponentServiceObjects;
	private static ComponentServiceObjects<OptionValueResource>
		_optionValueResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductResource>
		_productResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductConfigurationResource>
		_productConfigurationResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductOptionResource>
		_productOptionResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductOptionValueResource>
		_productOptionValueResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductShippingConfigurationResource>
		_productShippingConfigurationResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductSpecificationResource>
		_productSpecificationResourceComponentServiceObjects;
	private static ComponentServiceObjects
		<ProductSubscriptionConfigurationResource>
			_productSubscriptionConfigurationResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductTaxConfigurationResource>
		_productTaxConfigurationResourceComponentServiceObjects;
	private static ComponentServiceObjects<RelatedProductResource>
		_relatedProductResourceComponentServiceObjects;
	private static ComponentServiceObjects<SkuResource>
		_skuResourceComponentServiceObjects;
	private static ComponentServiceObjects<SpecificationResource>
		_specificationResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private Company _company;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;
	private User _user;

}