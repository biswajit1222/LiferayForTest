
package Student_Master.ActionCommand;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;
import Student_Master.constants.Student_MasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + Student_MasterPortletKeys.STUDENT_MASTER,
		"mvc.command.name=addStudent" }, service = MVCActionCommand.class)
public class StudentAdd extends BaseMVCActionCommand {
	private static final Log _log = LogFactoryUtil.getLog(StudentAdd.class);
	@SuppressWarnings("deprecation")
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("inside app::::::");

		//_log.info("Student_MasterPortletKeys:::" + xx);
		String xx1=ParamUtil.getString(actionRequest,"firstName");
		_log.info("Student_MasterPortletKeys:::" + xx1);
		String studentID = actionRequest.getParameter("studentID");
		String fName = actionRequest.getParameter("firstName");
		_log.info("Student firstname:::" + fName);
		String LName = actionRequest.getParameter("lastName");
		_log.info("Student lastname:::" + LName);
		String phNo1 = actionRequest.getParameter("phoneNumber");
		long phNo = Long.parseLong(phNo1);
		_log.info("Student contactNo:::" + phNo);
		String city = actionRequest.getParameter("city");
		_log.info("Student city:::::" + city);
		Student student3=null;
		 long studentId =0;
		 String  Studentid2="";
		if(studentID.equalsIgnoreCase("")) {
			_log.info("Student studentID111111111111:::" + studentID);
		}
		else {
		  studentId = Long.parseLong(studentID);
		  _log.info("Student studentID111111111111:::" + studentId);
		 student3=StudentLocalServiceUtil.getStudent(studentId);
	     long Studentid1=student3.getStudentId();
	    _log.info("Student Studentid1 Studentid1 Studentid1 Studentid1 :::::" + Studentid1);
	    Studentid2=Studentid2.valueOf(Studentid1);
		}
		//student.setStudentId(studentId);

	    _log.info("Studentid2 Studentid2 Studentid2 Studentid2:::::" + Studentid2);
	    if(Studentid2.equalsIgnoreCase("")) {
		 studentId = CounterLocalServiceUtil.increment(Student.class.getName());
		_log.info("Student id id:::::" + studentId);
		Student student = StudentLocalServiceUtil.createStudent(studentId);
		student.setStudentId(studentId);
		student.setFirstName(fName);
		student.setLastName(LName);
		student.setContactNo(phNo);
		student.setWorkLocation(city);
		String location = "odisha";
		List<Student> student1 = StudentLocalServiceUtil.getDataByWorkLocation(location);
		JSONFactoryUtil.createJSONObject();
		 StudentLocalServiceUtil.addStudent(student);
		_log.info("Student added Sucessfully:::::" + student);
	    }
	    else {
	    	Student student1=StudentLocalServiceUtil.getStudent(studentId);
		student1.setStudentId(studentId);
		student1.setFirstName(fName);
		student1.setLastName(LName);
		student1.setContactNo(phNo);
		student1.setWorkLocation(city);
		StudentLocalServiceUtil.updateStudent(student1);
		_log.info("Student Updated Sucessfully:::::" + student1);
	    }
	}
	@ProcessAction(name="addName")
	 public void addName(ActionRequest actionRequest,
	   ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
	  actionRequest.setAttribute("userName", "Nilang");
	
	 }
}
