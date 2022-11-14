
package Student_Master.ActionCommand;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;
import Student_Master.constants.Student_MasterPortletKeys;
import dbservice.service.studentLocalServiceUtil;

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
		String fName = actionRequest.getParameter("firstName");
		_log.info("Student firstname:::" + fName);
		String LName = actionRequest.getParameter("lastName");
		_log.info("Student lastname:::" + LName);
		String phNo1 = actionRequest.getParameter("phoneNumber");
		long phNo = Long.parseLong(phNo1);
		_log.info("Student contactNo:::" + phNo);
		String city = actionRequest.getParameter("city");
		_log.info("Student city:::::" + city);
		long studentId = CounterLocalServiceUtil.increment(Student.class.getName());
		_log.info("Student id id:::::" + studentId);
		Student student = StudentLocalServiceUtil.createStudent(studentId);
		student.setStudentId(studentId);
		_log.info("Student added Sucessfully:::::" + studentId);
		student.setFirstName(fName);
		student.setLastName(LName);
		student.setContactNo(phNo);
		student.setWorkLocation(city);
		String location = "odisha";
		List<Student> student1 = StudentLocalServiceUtil.getDataByWorkLocation(location);
		JSONFactoryUtil.createJSONObject();
		studentLocalServiceUtil.
		System.out.println("city city city city::::::::::::::::::::::" + student1);
		 StudentLocalServiceUtil.addStudent(student);
		_log.info("Student added Sucessfully:::::" + student);
	}
}
