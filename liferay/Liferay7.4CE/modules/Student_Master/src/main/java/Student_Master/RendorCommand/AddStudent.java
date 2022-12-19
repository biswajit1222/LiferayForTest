package Student_Master.RendorCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import Student_Master.constants.Student_MasterPortletKeys;
@Component(
		property = {
			"javax.portlet.name=" +Student_MasterPortletKeys.STUDENT_MASTER,
			"mvc.command.name=addStudent"
		},
		service = MVCRenderCommand.class
	)
public class AddStudent implements MVCRenderCommand{
	//private static final Log_LOG=LogFactoryUtil.getLog(addEmplyoee.class);
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("inside app11111111::::::::::::::");
		return "/AddStudent.jsp";
		//return "/EditStudent.jsp";
	}

}
