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

package com.liferay.commerce.initializer.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;

import com.liferay.commerce.account.service.CommerceAccountLocalService;
import com.liferay.commerce.user.service.CommerceUserLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserIdMapperLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.net.URI;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Riccardo Ferrari
 */
@Component(service = CommerceUsersImporter.class)
public class CommerceUsersImporter {

	public void importCommerceUsers(
			File commerceUsersFile, ClassLoader classLoader,
			String imageDependenciesPath, ServiceContext serviceContext)
		throws Exception {

		MappingJsonFactory mappingJsonFactory = new MappingJsonFactory();

		JsonParser jsonFactoryParser = mappingJsonFactory.createParser(
			commerceUsersFile);

		JsonToken jsonToken = jsonFactoryParser.nextToken();

		if (jsonToken != JsonToken.START_ARRAY) {
			throw new Exception("JSON Array Expected");
		}

		int importCount = 0;

		while (jsonFactoryParser.nextToken() != JsonToken.END_ARRAY) {
			TreeNode treeNode = jsonFactoryParser.readValueAsTree();

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				treeNode.toString());

			if (_log.isDebugEnabled()) {
				_log.debug(jsonObject);
			}

			_importUser(
				jsonObject, classLoader, imageDependenciesPath, serviceContext);

			importCount += 1;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Imported users count: " + importCount);
		}

		jsonFactoryParser.close();
	}

	private void _importUser(
			JSONObject jsonObject, ClassLoader classLoader,
			String imageDependenciesPath, ServiceContext serviceContext)
		throws Exception {

		long creatorUserId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		boolean autoPassword = true;
		String password1 = "";
		String password2 = "";
		boolean autoScreenName = false;
		String screenName = jsonObject.getString("screenname");
		String emailAddress = jsonObject.getString("email");
		long facebookId = 0;
		String openId = "";
		Locale locale = serviceContext.getLocale();
		String firstName = jsonObject.getString("first_name");
		String middleName = "";
		String lastName = jsonObject.getString("last_name");
		long prefixId = 0;
		long suffixId = 0;

		String gender = jsonObject.getString("gender");

		boolean male = "male".equals(gender);

		String birthday = jsonObject.getString("birthday");

		String[] birthdayTokens = birthday.split("-");

		int birthdayMonth = Integer.valueOf(birthdayTokens[1]) - 1;
		int birthdayDay = Integer.valueOf(birthdayTokens[2]);
		int birthdayYear = Integer.valueOf(birthdayTokens[0]);

		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;

		User user = _userLocalService.fetchUserByScreenName(
			serviceContext.getCompanyId(), screenName);

		if (user != null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"User already exists with screen name: " + screenName);
			}

			return;
		}

		user = _userLocalService.fetchUserByEmailAddress(
			serviceContext.getCompanyId(), emailAddress);

		if (user != null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"User already exists with email address: " + emailAddress);
			}

			return;
		}

		user = _userLocalService.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		String profilePicture = jsonObject.getString("profile_picture");

		if (Validator.isNotNull(profilePicture)) {
			InputStream inputStream = null;

			URI uri = new URI(imageDependenciesPath + profilePicture);

			String scheme = uri.getScheme();

			if (StringUtil.equalsIgnoreCase(scheme, "file")) {
				inputStream = new FileInputStream(uri.getPath());
			}
			else {
				inputStream = classLoader.getResourceAsStream(
					imageDependenciesPath + profilePicture);
			}

			byte[] portraitBytes = FileUtil.getBytes(inputStream);

			_userLocalService.updatePortrait(user.getUserId(), portraitBytes);
		}

		String externalUserId = jsonObject.getString("externalUserId");

		if (Validator.isNotNull(externalUserId)) {
			_userIdMapperLocalService.updateUserIdMapper(
				user.getUserId(), "movielens", "Movielens userid",
				externalUserId);
		}

		_commerceUserLocalService.updateActive(user.getUserId(), true);

		_commerceAccountLocalService.addPersonalCommerceAccount(
			user.getUserId(), StringPool.BLANK, StringPool.BLANK,
			serviceContext);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CommerceUsersImporter.class);

	@Reference
	private CommerceAccountLocalService _commerceAccountLocalService;

	@Reference
	private CommerceUserLocalService _commerceUserLocalService;

	@Reference
	private UserIdMapperLocalService _userIdMapperLocalService;

	@Reference
	private UserLocalService _userLocalService;

}