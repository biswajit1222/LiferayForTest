
package Student_Master.ActionCommand;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;
import Student_Master.constants.Student_MasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + Student_MasterPortletKeys.STUDENT_MASTER,
		"mvc.command.name=EditStudent" }, service = MVCActionCommand.class)
public class StudentEdit extends BaseMVCActionCommand {
	private static final Log _log = LogFactoryUtil.getLog(StudentAdd.class);

	@SuppressWarnings("deprecation")
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("inside app::::::");
		String studentId1 = actionRequest.getParameter("studentID");
		long studentId = Long.parseLong(studentId1);
		_log.info("Student id id:::::" + studentId);
		String fName = actionRequest.getParameter("firstName");
		_log.info("Student firstname:::" + fName);
		String LName = actionRequest.getParameter("lastName");
		_log.info("Student lastname:::" + LName);
		String phNo1 = actionRequest.getParameter("phoneNumber");
		long phNo = Long.parseLong(phNo1);
		_log.info("Student contactNo:::" + phNo);
		String city = actionRequest.getParameter("city");
		_log.info("Student city:::::" + city);
		Student student=StudentLocalServiceUtil.getStudent(studentId);
		    student.setStudentId(studentId);
		_log.info("Student added Sucessfully:::::" + studentId);
		student.setFirstName(fName);
		student.setLastName(LName);
		student.setContactNo(phNo);
		student.setWorkLocation(city);
		StudentLocalServiceUtil.updateStudent(student);
		_log.info("Student Updated Sucessfully:::::" + student);
	}
}
