package Student_Master.portlet;

import Student_Master.constants.Student_MasterPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import StudentMasterService.model.Student;
import StudentMasterService.service.StudentLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author biswajit.nayak01
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Student_Master",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + Student_MasterPortletKeys.STUDENT_MASTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Student_MasterPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Student> students =StudentLocalServiceUtil.getStudents(-1, -1);
		String city="odisha";
		Student student1=StudentLocalServiceUtil.findByWorkLoction(city);
		System.out.println("Student added Sucessfully city city city city :::::" + student1);
				renderRequest.setAttribute("students",students );
		super.render(renderRequest, renderResponse);
	}
}