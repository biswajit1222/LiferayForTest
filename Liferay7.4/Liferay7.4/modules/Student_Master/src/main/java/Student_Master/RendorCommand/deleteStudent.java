package Student_Master.RendorCommand;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;
import Student_Master.constants.Student_MasterPortletKeys;
@Component(
		property = {
			"javax.portlet.name=" +Student_MasterPortletKeys.STUDENT_MASTER,
			"mvc.command.name=deleteStudent"
		},
		service = MVCRenderCommand.class
	)
public class deleteStudent implements MVCRenderCommand{
	private static final Log _LOG=LogFactoryUtil.getLog(deleteStudent.class);
	@SuppressWarnings("deprecation")
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("inside Student Delete rendor method::::::::::::::");
		String SId = renderRequest.getParameter("studentId");
		long studentId= Long.parseLong(SId);
		//Student student = null;

		renderRequest.setAttribute("studentId",studentId);
		return "/DeleteStudent.jsp";
	}

}
