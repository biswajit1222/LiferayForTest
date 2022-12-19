package Student_Master.ActionCommand;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import StudentMasterService.service.StudentLocalServiceUtil;
import Student_Master.constants.Student_MasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + Student_MasterPortletKeys.STUDENT_MASTER,
		"mvc.command.name=DeleteStudent" }, service = MVCActionCommand.class)
public class StudentDelete extends BaseMVCActionCommand {
	private static final Log _log = LogFactoryUtil.getLog(StudentAdd.class);

	@SuppressWarnings("deprecation")
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("inside Delete Student do processAction ::::::");
		String studentId1 = actionRequest.getParameter("studentID");
		long studentId = Long.parseLong(studentId1);
		StudentLocalServiceUtil.deleteStudent(studentId);
		_log.info("Student Record Deleted Sucessfully:::::id:"+ studentId );
	}
}
