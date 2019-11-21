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

package com.liferay.headless.commerce.admin.catalog.internal.resource.v1_0;

import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Product;
import com.liferay.headless.commerce.admin.catalog.resource.v1_0.ProductResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseProductResourceImpl implements ProductResource {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/'  -u 'test@liferay.com:test'
	 */
	@Override
	@GET
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/products/")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Page<Product> getProductsPage(
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/' -d $'{"active": ___, "attachments": ___, "catalogId": ___, "categories": ___, "configuration": ___, "createDate": ___, "defaultSku": ___, "description": ___, "displayDate": ___, "expando": ___, "expirationDate": ___, "externalReferenceCode": ___, "metaDescription": ___, "metaKeyword": ___, "metaTitle": ___, "modifiedDate": ___, "name": ___, "neverExpire": ___, "productOptions": ___, "productSpecifications": ___, "productType": ___, "relatedProducts": ___, "shippingConfiguration": ___, "shortDescription": ___, "skus": ___, "subscriptionConfiguration": ___, "tags": ___, "taxConfiguration": ___, "urls": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Override
	@Consumes({"application/json", "application/xml"})
	@POST
	@Path("/products/")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Product postProduct(Product product) throws Exception {
		return new Product();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/by-externalReferenceCode/{externalReferenceCode}'  -u 'test@liferay.com:test'
	 */
	@Override
	@DELETE
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "externalReferenceCode")
		}
	)
	@Path("/products/by-externalReferenceCode/{externalReferenceCode}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Response deleteProductByExternalReferenceCode(
			@NotNull @Parameter(hidden = true)
			@PathParam("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/by-externalReferenceCode/{externalReferenceCode}'  -u 'test@liferay.com:test'
	 */
	@Override
	@GET
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "externalReferenceCode")
		}
	)
	@Path("/products/by-externalReferenceCode/{externalReferenceCode}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Product getProductByExternalReferenceCode(
			@NotNull @Parameter(hidden = true)
			@PathParam("externalReferenceCode") String externalReferenceCode)
		throws Exception {

		return new Product();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/by-externalReferenceCode/{externalReferenceCode}' -d $'{"active": ___, "attachments": ___, "catalogId": ___, "categories": ___, "configuration": ___, "createDate": ___, "defaultSku": ___, "description": ___, "displayDate": ___, "expando": ___, "expirationDate": ___, "externalReferenceCode": ___, "metaDescription": ___, "metaKeyword": ___, "metaTitle": ___, "modifiedDate": ___, "name": ___, "neverExpire": ___, "productOptions": ___, "productSpecifications": ___, "productType": ___, "relatedProducts": ___, "shippingConfiguration": ___, "shortDescription": ___, "skus": ___, "subscriptionConfiguration": ___, "tags": ___, "taxConfiguration": ___, "urls": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Override
	@Consumes({"application/json", "application/xml"})
	@PATCH
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.PATH, name = "externalReferenceCode")
		}
	)
	@Path("/products/by-externalReferenceCode/{externalReferenceCode}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Response patchProductByExternalReferenceCode(
			@NotNull @Parameter(hidden = true)
			@PathParam("externalReferenceCode") String externalReferenceCode,
			Product product)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/{id}'  -u 'test@liferay.com:test'
	 */
	@Override
	@DELETE
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "id")})
	@Path("/products/{id}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Response deleteProduct(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/{id}'  -u 'test@liferay.com:test'
	 */
	@Override
	@GET
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "id")})
	@Path("/products/{id}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Product getProduct(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id)
		throws Exception {

		return new Product();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/headless-commerce-admin-catalog/v1.0/products/{id}' -d $'{"active": ___, "attachments": ___, "catalogId": ___, "categories": ___, "configuration": ___, "createDate": ___, "defaultSku": ___, "description": ___, "displayDate": ___, "expando": ___, "expirationDate": ___, "externalReferenceCode": ___, "metaDescription": ___, "metaKeyword": ___, "metaTitle": ___, "modifiedDate": ___, "name": ___, "neverExpire": ___, "productOptions": ___, "productSpecifications": ___, "productType": ___, "relatedProducts": ___, "shippingConfiguration": ___, "shortDescription": ___, "skus": ___, "subscriptionConfiguration": ___, "tags": ___, "taxConfiguration": ___, "urls": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Override
	@Consumes({"application/json", "application/xml"})
	@PATCH
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "id")})
	@Path("/products/{id}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Response patchProduct(
			@NotNull @Parameter(hidden = true) @PathParam("id") Long id,
			Product product)
		throws Exception {

		Response.ResponseBuilder responseBuilder = Response.ok();

		return responseBuilder.build();
	}

	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	public void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {

		this.contextHttpServletRequest = contextHttpServletRequest;
	}

	public void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {

		this.contextHttpServletResponse = contextHttpServletResponse;
	}

	public void setContextUriInfo(UriInfo contextUriInfo) {
		this.contextUriInfo = contextUriInfo;
	}

	public void setContextUser(User contextUser) {
		this.contextUser = contextUser;
	}

	protected void preparePatch(Product product, Product existingProduct) {
	}

	protected <T, R> List<R> transform(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		java.util.Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	protected AcceptLanguage contextAcceptLanguage;
	protected Company contextCompany;
	protected HttpServletRequest contextHttpServletRequest;
	protected HttpServletResponse contextHttpServletResponse;
	protected UriInfo contextUriInfo;
	protected User contextUser;

}