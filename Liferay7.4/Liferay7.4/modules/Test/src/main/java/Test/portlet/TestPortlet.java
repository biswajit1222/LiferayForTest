package Test.portlet;
import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import Service.model.Foo;
import Service.service.FooLocalServiceUtil;
import Test.constants.TestPortletKeys;

/**
 * @author biswajit.nayak01
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Test",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TestPortletKeys.TEST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TestPortlet extends MVCPortlet {
	/*
	 * @Override public void render(RenderRequest renderRequest, RenderResponse
	 * renderResponse) throws IOException, PortletException {
	 * 
	 * Foo fooObject = FooLocalServiceUtil.createFoo(123456l);
	 * fooObject.setCompanyId(1241412l); FooLocalServiceUtil.addFoo(fooObject);
	 * List<Foo> foo= null; foo=FooLocalServiceUtil.getFoos(-1, -1);
	 * System.out.println("foo:::::::::"+foo);
	 * System.out.println("foo:::::::::"+foo.size()); super.render(renderRequest,
	 * renderResponse);
	 * 
	 * }
	 */
}