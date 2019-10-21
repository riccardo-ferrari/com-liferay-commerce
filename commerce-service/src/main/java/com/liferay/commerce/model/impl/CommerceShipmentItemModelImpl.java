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

package com.liferay.commerce.model.impl;

import com.liferay.commerce.model.CommerceShipmentItem;
import com.liferay.commerce.model.CommerceShipmentItemModel;
import com.liferay.commerce.model.CommerceShipmentItemSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommerceShipmentItem service. Represents a row in the &quot;CommerceShipmentItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommerceShipmentItemModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceShipmentItemImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceShipmentItemImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceShipmentItemModelImpl
	extends BaseModelImpl<CommerceShipmentItem>
	implements CommerceShipmentItemModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce shipment item model instance should use the <code>CommerceShipmentItem</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceShipmentItem";

	public static final Object[][] TABLE_COLUMNS = {
		{"commerceShipmentItemId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"commerceShipmentId", Types.BIGINT},
		{"commerceOrderItemId", Types.BIGINT},
		{"commerceInventoryWarehouseId", Types.BIGINT},
		{"quantity", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceShipmentItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceShipmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceOrderItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceInventoryWarehouseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceShipmentItem (commerceShipmentItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceShipmentId LONG,commerceOrderItemId LONG,commerceInventoryWarehouseId LONG,quantity INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceShipmentItem";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceShipmentItem.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceShipmentItem.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.model.CommerceShipmentItem"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.model.CommerceShipmentItem"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.model.CommerceShipmentItem"),
		true);

	public static final long COMMERCESHIPMENTID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceShipmentItem toModel(
		CommerceShipmentItemSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceShipmentItem model = new CommerceShipmentItemImpl();

		model.setCommerceShipmentItemId(soapModel.getCommerceShipmentItemId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceShipmentId(soapModel.getCommerceShipmentId());
		model.setCommerceOrderItemId(soapModel.getCommerceOrderItemId());
		model.setCommerceInventoryWarehouseId(
			soapModel.getCommerceInventoryWarehouseId());
		model.setQuantity(soapModel.getQuantity());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceShipmentItem> toModels(
		CommerceShipmentItemSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceShipmentItem> models = new ArrayList<CommerceShipmentItem>(
			soapModels.length);

		for (CommerceShipmentItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.model.CommerceShipmentItem"));

	public CommerceShipmentItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceShipmentItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceShipmentItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceShipmentItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceShipmentItem.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceShipmentItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceShipmentItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceShipmentItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceShipmentItem, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceShipmentItem)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceShipmentItem, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceShipmentItem, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceShipmentItem)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceShipmentItem, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceShipmentItem, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceShipmentItem>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceShipmentItem.class.getClassLoader(),
			CommerceShipmentItem.class, ModelWrapper.class);

		try {
			Constructor<CommerceShipmentItem> constructor =
				(Constructor<CommerceShipmentItem>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CommerceShipmentItem, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceShipmentItem, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceShipmentItem, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceShipmentItem, Object>>();
		Map<String, BiConsumer<CommerceShipmentItem, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceShipmentItem, ?>>();

		attributeGetterFunctions.put(
			"commerceShipmentItemId",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getCommerceShipmentItemId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceShipmentItemId",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object commerceShipmentItemIdObject) {

					commerceShipmentItem.setCommerceShipmentItemId(
						(Long)commerceShipmentItemIdObject);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object groupIdObject) {

					commerceShipmentItem.setGroupId((Long)groupIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object companyIdObject) {

					commerceShipmentItem.setCompanyId((Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object userIdObject) {

					commerceShipmentItem.setUserId((Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object userNameObject) {

					commerceShipmentItem.setUserName((String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object createDateObject) {

					commerceShipmentItem.setCreateDate((Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object modifiedDateObject) {

					commerceShipmentItem.setModifiedDate(
						(Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"commerceShipmentId",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getCommerceShipmentId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceShipmentId",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object commerceShipmentIdObject) {

					commerceShipmentItem.setCommerceShipmentId(
						(Long)commerceShipmentIdObject);
				}

			});
		attributeGetterFunctions.put(
			"commerceOrderItemId",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getCommerceOrderItemId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceOrderItemId",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object commerceOrderItemIdObject) {

					commerceShipmentItem.setCommerceOrderItemId(
						(Long)commerceOrderItemIdObject);
				}

			});
		attributeGetterFunctions.put(
			"commerceInventoryWarehouseId",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.
						getCommerceInventoryWarehouseId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceInventoryWarehouseId",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object commerceInventoryWarehouseIdObject) {

					commerceShipmentItem.setCommerceInventoryWarehouseId(
						(Long)commerceInventoryWarehouseIdObject);
				}

			});
		attributeGetterFunctions.put(
			"quantity",
			new Function<CommerceShipmentItem, Object>() {

				@Override
				public Object apply(CommerceShipmentItem commerceShipmentItem) {
					return commerceShipmentItem.getQuantity();
				}

			});
		attributeSetterBiConsumers.put(
			"quantity",
			new BiConsumer<CommerceShipmentItem, Object>() {

				@Override
				public void accept(
					CommerceShipmentItem commerceShipmentItem,
					Object quantityObject) {

					commerceShipmentItem.setQuantity((Integer)quantityObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceShipmentItemId() {
		return _commerceShipmentItemId;
	}

	@Override
	public void setCommerceShipmentItemId(long commerceShipmentItemId) {
		_commerceShipmentItemId = commerceShipmentItemId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCommerceShipmentId() {
		return _commerceShipmentId;
	}

	@Override
	public void setCommerceShipmentId(long commerceShipmentId) {
		_columnBitmask |= COMMERCESHIPMENTID_COLUMN_BITMASK;

		if (!_setOriginalCommerceShipmentId) {
			_setOriginalCommerceShipmentId = true;

			_originalCommerceShipmentId = _commerceShipmentId;
		}

		_commerceShipmentId = commerceShipmentId;
	}

	public long getOriginalCommerceShipmentId() {
		return _originalCommerceShipmentId;
	}

	@JSON
	@Override
	public long getCommerceOrderItemId() {
		return _commerceOrderItemId;
	}

	@Override
	public void setCommerceOrderItemId(long commerceOrderItemId) {
		_commerceOrderItemId = commerceOrderItemId;
	}

	@JSON
	@Override
	public long getCommerceInventoryWarehouseId() {
		return _commerceInventoryWarehouseId;
	}

	@Override
	public void setCommerceInventoryWarehouseId(
		long commerceInventoryWarehouseId) {

		_commerceInventoryWarehouseId = commerceInventoryWarehouseId;
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceShipmentItem.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceShipmentItem toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceShipmentItem>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceShipmentItemImpl commerceShipmentItemImpl =
			new CommerceShipmentItemImpl();

		commerceShipmentItemImpl.setCommerceShipmentItemId(
			getCommerceShipmentItemId());
		commerceShipmentItemImpl.setGroupId(getGroupId());
		commerceShipmentItemImpl.setCompanyId(getCompanyId());
		commerceShipmentItemImpl.setUserId(getUserId());
		commerceShipmentItemImpl.setUserName(getUserName());
		commerceShipmentItemImpl.setCreateDate(getCreateDate());
		commerceShipmentItemImpl.setModifiedDate(getModifiedDate());
		commerceShipmentItemImpl.setCommerceShipmentId(getCommerceShipmentId());
		commerceShipmentItemImpl.setCommerceOrderItemId(
			getCommerceOrderItemId());
		commerceShipmentItemImpl.setCommerceInventoryWarehouseId(
			getCommerceInventoryWarehouseId());
		commerceShipmentItemImpl.setQuantity(getQuantity());

		commerceShipmentItemImpl.resetOriginalValues();

		return commerceShipmentItemImpl;
	}

	@Override
	public int compareTo(CommerceShipmentItem commerceShipmentItem) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), commerceShipmentItem.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceShipmentItem)) {
			return false;
		}

		CommerceShipmentItem commerceShipmentItem = (CommerceShipmentItem)obj;

		long primaryKey = commerceShipmentItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceShipmentItemModelImpl commerceShipmentItemModelImpl = this;

		commerceShipmentItemModelImpl._originalGroupId =
			commerceShipmentItemModelImpl._groupId;

		commerceShipmentItemModelImpl._setOriginalGroupId = false;

		commerceShipmentItemModelImpl._setModifiedDate = false;

		commerceShipmentItemModelImpl._originalCommerceShipmentId =
			commerceShipmentItemModelImpl._commerceShipmentId;

		commerceShipmentItemModelImpl._setOriginalCommerceShipmentId = false;

		commerceShipmentItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceShipmentItem> toCacheModel() {
		CommerceShipmentItemCacheModel commerceShipmentItemCacheModel =
			new CommerceShipmentItemCacheModel();

		commerceShipmentItemCacheModel.commerceShipmentItemId =
			getCommerceShipmentItemId();

		commerceShipmentItemCacheModel.groupId = getGroupId();

		commerceShipmentItemCacheModel.companyId = getCompanyId();

		commerceShipmentItemCacheModel.userId = getUserId();

		commerceShipmentItemCacheModel.userName = getUserName();

		String userName = commerceShipmentItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceShipmentItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceShipmentItemCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceShipmentItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceShipmentItemCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceShipmentItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceShipmentItemCacheModel.commerceShipmentId =
			getCommerceShipmentId();

		commerceShipmentItemCacheModel.commerceOrderItemId =
			getCommerceOrderItemId();

		commerceShipmentItemCacheModel.commerceInventoryWarehouseId =
			getCommerceInventoryWarehouseId();

		commerceShipmentItemCacheModel.quantity = getQuantity();

		return commerceShipmentItemCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceShipmentItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceShipmentItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceShipmentItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceShipmentItem)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CommerceShipmentItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceShipmentItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceShipmentItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceShipmentItem)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceShipmentItem>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _commerceShipmentItemId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceShipmentId;
	private long _originalCommerceShipmentId;
	private boolean _setOriginalCommerceShipmentId;
	private long _commerceOrderItemId;
	private long _commerceInventoryWarehouseId;
	private int _quantity;
	private long _columnBitmask;
	private CommerceShipmentItem _escapedModel;

}