package Student_Master.portlet;

import Student_Master.constants.Student_MasterPortletKeys;
import studentRestAPI1.application.StudentRestAPI1Application;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalService;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.headless.commerce.admin.account.dto.v1_0.User;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropertiesUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import StudentMasterService.model.Student;
import StudentMasterService.model.StudentModel;
import StudentMasterService.model.StudentTable;
import StudentMasterService.model.impl.StudentImpl;
import StudentMasterService.service.StudentLocalServiceUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author biswajit.nayak01
 * @param <Serializable>
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
		//"javax.portlet.init-param.view-template=/AddStudent.jsp",
		"javax.portlet.name=" + Student_MasterPortletKeys.STUDENT_MASTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Student_MasterPortlet<Serializable> extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String city="Biswa";
		String x=renderRequest.getContextPath();
		HttpServletRequest servletreq=PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletRequest servletreq1=PortalUtil.getOriginalServletRequest(servletreq);
	String x2=	servletreq.getContextPath();
		System.out.println("---------------------------------");
		System.out.println(""+servletreq1);
		System.out.println(""+x2);
		System.out.println("---------------------------------");
		System.out.println("servletreq"+servletreq.getRequestedSessionId());
		String xx=ParamUtil.getString(servletreq1,Student_MasterPortletKeys.ARTICLE_ID);
		System.out.println(Student_MasterPortletKeys.ARTICLE_ID);
		System.out.println(xx);
		/*
		 * if(Validator.isNull(xx)) {
		 * System.out.println("Validator.isNull(xx)"+Validator.isNull(xx));
		 * System.out.println("ccccccccccccccccccccccccc"+xx);
		 * System.out.println(servletreq1.toString());
		 * System.out.println("ARTICLE_ID"+Student_MasterPortletKeys.ARTICLE_ID); }
		 * System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+x);
		 */
		try {
		ThemeDisplay theme=(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		System.out.println(" theme theme themetheme theme theme theme"+theme.getUserId());
		System.out.println(" theme theme themetheme theme theme theme"+theme.getUser());
		System.out.println(" theme theme themetheme theme theme theme"+theme.getURLPortal());
		PortletSession as=renderRequest.getPortletSession();
		System.out.println(as);
		  DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(StudentModel.class,"student",PortalClassLoaderUtil.getClassLoader());
		 // DynamicQuery dynamicQuery= (DynamicQuery) DynamicQueryFactoryUtil.getDynamicQueryFactory();
		  System.out.println("----------------------------------------------------");
			/*
			 * dynamicQuery.add(RestrictionsFactoryUtil.like("student.firstName",
			 * "%"+city+"%"));
			 */ 
		  //dynamicQuery.add(PropertyFactoryUtil.forName("student.firstName").like(city));
		 // dynamicQuery.setProjection(PropertyFactoryUtil.forName("student.firstName"));
		//  List<Object>students11 =StudentLocalServiceUtil.dynamicQuery(dynamicQuery);
		  //System.out.println("students11 students11 students11 students11 students11"+students11);
		  System.out.println("....................................................");
		  
		  ProjectionList proj=ProjectionFactoryUtil.projectionList();
		  proj.add(PropertyFactoryUtil.forName("student.firstName"));
		  proj.add(PropertyFactoryUtil.forName("student.lastName"));
		  dynamicQuery.setProjection(proj);
		  List<Object[]>students11 =StudentLocalServiceUtil.dynamicQuery(dynamicQuery);
		  //List<Student>students1 =StudentLocalServiceUtil.dynamicQuery(dynamicQuery);
		 //String students2=students1.get(0).getFirstName().toString().toLowerCase();
		  System.out.println("list1 list1 list1 v v v list1 list1 "+students11);
		  //-----------------------------------------------------------------------------
		  long companyId =201;
		  String company1=null;
		    if(company1!=null) {
		    	company1=new String(Base64.getDecoder().decode(company1));
		        }
		    System.out.println("company1 company1 company1 company1 company1 "+company1);
		  //CompanyThreadLocal.getCompanyId();
		  System.out.println(companyId);
		  ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(companyId, Student.class.getName());
		   System.out.println(expandoBridge);
		  Enumeration<String> attributes =  expandoBridge.getAttributeNames();
		//  Map<String,Serializable> attributeNameValuePair=  (Map<String, Serializable>) expandoBridge.getAttributeNames();
		   System.out.println(attributes);
		  while(attributes.hasMoreElements()){
		  System.out.println("ExpandoBridgeFactoryUtil..........."+attributes.nextElement());
		  }
		  
			/*
			 * for (Map.Entry<String, Serializable> entry :
			 * attributeNameValuePair.entrySet()) { System.out.println("Attribute Name = " +
			 * entry.getKey() + ", Attribute Value = " + entry.getValue()); }
			 */
		  //---------------------------------------------------------------------------------
		  for( Object[] stu :students11) {
			  //System.out.println("inside for"); 
			System.out.println(stu[0]+"................."+stu[1]);
			 
		  }
		List<Student> students =StudentLocalServiceUtil.getStudents(-1, -1);
		//StudentLocalServiceUtil.FoundByWorkLoction(WorkLocation)
		renderRequest.setAttribute("students",students );
		renderRequest.setAttribute("bulu","bulu1234" );
		String param3=  ParamUtil.get(renderRequest, "param3", StringPool.BLANK);
		System.out.println("param3333333333333333333333333"+param3);
		super.render(renderRequest, renderResponse);
		}catch(Exception e){
			System.out.println("erroerr11"+e);
			}
	}
}