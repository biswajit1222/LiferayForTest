package org.Student.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.fasterxml.jackson.core.JsonFactory;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JSONRequired;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;

/**
 * @author biswajit.nayak01
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest" }, service = Application.class)
public class FirstRestForStudentApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	// @Produces("text/plain")
	@Produces("application/json")
	
	public JSONArray morning(@PathParam("name") String name, @QueryParam("drink") String drink) {
		JSONArray jsonArray=	JSONFactoryUtil.createJSONArray();
 List<Student> stu = StudentLocalServiceUtil.getStudents(-1, -1);
	JSONObject jsonObject=	JSONFactoryUtil.createJSONObject();
	for(Student student:stu) {
		jsonObject.put("StudentId", student.getStudentId());
		jsonObject.put("FirstName", student.getFirstName());
		jsonObject.put("LastName", student.getLastName());
		jsonObject.put("Workloc", student.getWorkLocation());
		jsonObject.put("ContactNo", student.getContactNo());
		jsonArray.put(jsonObject);
	}
	System.out.println("jsonArray jsonArray jsonArray v"+jsonArray);
		/*
		 * List<Student> stu11 = new ArrayList<Student>(); System.out.println("stu " +
		 * stu); try { if (stu != null) {
		 * 
		 * for (Student stu1 : stu) { System.out.println("stu11111111111111" + stu1);
		 * stu11.add(stu1); } System.out.println("11111111111111111111111111" + stu11);
		 * }
		 */
		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		// Student stu =StudentLocalServiceUtil.fetchStudent(201);
		
		/*
		 * } catch(Exception e) { System.out.println("exception"+e); }
		 */
	
return jsonArray;
}

}