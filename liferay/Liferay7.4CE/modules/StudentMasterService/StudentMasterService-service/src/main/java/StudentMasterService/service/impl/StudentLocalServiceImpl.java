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

package StudentMasterService.service.impl;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;
import StudentMasterService.service.base.StudentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=StudentMasterService.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	public List<Student> getDataByWorkLocation(String Location)
			throws com.liferay.portal.kernel.exception.SystemException {
		List<Student> locData=studentPersistence.findByworkLocation(Location);
		return  locData;
		
	}
	public List<Student> FoundByWorkLoction(String WorkLocation)
			throws com.liferay.portal.kernel.exception.SystemException {
			List<Student>student=studentPersistence.findByworkLocation(WorkLocation);
			return student.stream().sorted().collect(Collectors.toList());	
}
}