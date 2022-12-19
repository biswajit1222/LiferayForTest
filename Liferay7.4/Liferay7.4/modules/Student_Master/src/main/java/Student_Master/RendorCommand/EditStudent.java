package Student_Master.RendorCommand;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;
import Student_Master.constants.Student_MasterPortletKeys;
@Component(
		property = {
			"javax.portlet.name=" +Student_MasterPortletKeys.STUDENT_MASTER,
			"mvc.command.name=editStudent"
		},
		service = MVCRenderCommand.class
	)
public class EditStudent implements MVCRenderCommand{
	//private static final Log_LOG=LogFactoryUtil.getLog(EditStudent.class);
	private static final Log _LOG = LogFactoryUtil.getLog(EditStudent.class);
	@SuppressWarnings("deprecation")
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("inside EditStudent111111::::::::::::::");
		String SId = renderRequest.getParameter("studentId");
		long studentId= Long.parseLong(SId);
		_LOG.info("Student Id:::::::"+SId);
		Student student = null;
		try {
		
			student = StudentLocalServiceUtil.getStudent(studentId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			_LOG.info("Studentid may be Not avaliable");
			
		}
		renderRequest.setAttribute("studentId", student.getStudentId());
		renderRequest.setAttribute("firstName", student.getFirstName());
		renderRequest.setAttribute("lastName", student.getLastName());
		renderRequest.setAttribute("contactNo", student.getContactNo());
		renderRequest.setAttribute("workLocation", student.getWorkLocation());
		return "/EditStudent.jsp";
	}

}
