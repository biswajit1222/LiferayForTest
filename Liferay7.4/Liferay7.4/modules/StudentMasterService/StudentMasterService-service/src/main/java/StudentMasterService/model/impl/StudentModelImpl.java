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

package StudentMasterService.model.impl;

import StudentMasterService.model.Student;
import StudentMasterService.model.StudentModel;
import StudentMasterService.model.StudentSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Student service. Represents a row in the &quot;student_Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StudentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentImpl
 * @generated
 */
@JSON(strict = true)
public class StudentModelImpl
	extends BaseModelImpl<Student> implements StudentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student model instance should use the <code>Student</code> interface instead.
	 */
	public static final String TABLE_NAME = "student_Student";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"studentId", Types.BIGINT},
		{"firstName", Types.VARCHAR}, {"lastName", Types.VARCHAR},
		{"contactNo", Types.BIGINT}, {"workLocation", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("studentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workLocation", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table student_Student (uuid_ VARCHAR(75) null,studentId LONG not null primary key,firstName VARCHAR(75) null,lastName VARCHAR(75) null,contactNo LONG,workLocation VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table student_Student";

	public static final String ORDER_BY_JPQL =
		" ORDER BY student.studentId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY student_Student.studentId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long WORKLOCATION_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STUDENTID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Student toModel(StudentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Student model = new StudentImpl();

		model.setUuid(soapModel.getUuid());
		model.setStudentId(soapModel.getStudentId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setContactNo(soapModel.getContactNo());
		model.setWorkLocation(soapModel.getWorkLocation());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Student> toModels(StudentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Student> models = new ArrayList<Student>(soapModels.length);

		for (StudentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public StudentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _studentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Student, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Student)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Student, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Student, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Student)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Student, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Student, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Student>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Student.class.getClassLoader(), Student.class, ModelWrapper.class);

		try {
			Constructor<Student> constructor =
				(Constructor<Student>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Student, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Student, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Student, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Student, Object>>();
		Map<String, BiConsumer<Student, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Student, ?>>();

		attributeGetterFunctions.put("uuid", Student::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Student, String>)Student::setUuid);
		attributeGetterFunctions.put("studentId", Student::getStudentId);
		attributeSetterBiConsumers.put(
			"studentId", (BiConsumer<Student, Long>)Student::setStudentId);
		attributeGetterFunctions.put("firstName", Student::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName", (BiConsumer<Student, String>)Student::setFirstName);
		attributeGetterFunctions.put("lastName", Student::getLastName);
		attributeSetterBiConsumers.put(
			"lastName", (BiConsumer<Student, String>)Student::setLastName);
		attributeGetterFunctions.put("contactNo", Student::getContactNo);
		attributeSetterBiConsumers.put(
			"contactNo", (BiConsumer<Student, Long>)Student::setContactNo);
		attributeGetterFunctions.put("workLocation", Student::getWorkLocation);
		attributeSetterBiConsumers.put(
			"workLocation",
			(BiConsumer<Student, String>)Student::setWorkLocation);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_studentId = studentId;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_firstName = firstName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastName = lastName;
	}

	@JSON
	@Override
	public long getContactNo() {
		return _contactNo;
	}

	@Override
	public void setContactNo(long contactNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_contactNo = contactNo;
	}

	@JSON
	@Override
	public String getWorkLocation() {
		if (_workLocation == null) {
			return "";
		}
		else {
			return _workLocation;
		}
	}

	@Override
	public void setWorkLocation(String workLocation) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workLocation = workLocation;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalWorkLocation() {
		return getColumnOriginalValue("workLocation");
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Student.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Student toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Student>
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
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setUuid(getUuid());
		studentImpl.setStudentId(getStudentId());
		studentImpl.setFirstName(getFirstName());
		studentImpl.setLastName(getLastName());
		studentImpl.setContactNo(getContactNo());
		studentImpl.setWorkLocation(getWorkLocation());

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public Student cloneWithOriginalValues() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		studentImpl.setStudentId(
			this.<Long>getColumnOriginalValue("studentId"));
		studentImpl.setFirstName(
			this.<String>getColumnOriginalValue("firstName"));
		studentImpl.setLastName(
			this.<String>getColumnOriginalValue("lastName"));
		studentImpl.setContactNo(
			this.<Long>getColumnOriginalValue("contactNo"));
		studentImpl.setWorkLocation(
			this.<String>getColumnOriginalValue("workLocation"));

		return studentImpl;
	}

	@Override
	public int compareTo(Student student) {
		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Student)) {
			return false;
		}

		Student student = (Student)object;

		long primaryKey = student.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Student> toCacheModel() {
		StudentCacheModel studentCacheModel = new StudentCacheModel();

		studentCacheModel.uuid = getUuid();

		String uuid = studentCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			studentCacheModel.uuid = null;
		}

		studentCacheModel.studentId = getStudentId();

		studentCacheModel.firstName = getFirstName();

		String firstName = studentCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			studentCacheModel.firstName = null;
		}

		studentCacheModel.lastName = getLastName();

		String lastName = studentCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			studentCacheModel.lastName = null;
		}

		studentCacheModel.contactNo = getContactNo();

		studentCacheModel.workLocation = getWorkLocation();

		String workLocation = studentCacheModel.workLocation;

		if ((workLocation != null) && (workLocation.length() == 0)) {
			studentCacheModel.workLocation = null;
		}

		return studentCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Student, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Student)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

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
		Map<String, Function<Student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Student, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Student)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Student>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _studentId;
	private String _firstName;
	private String _lastName;
	private long _contactNo;
	private String _workLocation;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Student, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Student)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("studentId", _studentId);
		_columnOriginalValues.put("firstName", _firstName);
		_columnOriginalValues.put("lastName", _lastName);
		_columnOriginalValues.put("contactNo", _contactNo);
		_columnOriginalValues.put("workLocation", _workLocation);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("studentId", 2L);

		columnBitmasks.put("firstName", 4L);

		columnBitmasks.put("lastName", 8L);

		columnBitmasks.put("contactNo", 16L);

		columnBitmasks.put("workLocation", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Student _escapedModel;

}