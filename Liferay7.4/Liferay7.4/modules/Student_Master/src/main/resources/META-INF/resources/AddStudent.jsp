<%@ include file="/init.jsp"%>
<h2>Add Employee Page</h2>
<liferay-portlet:actionURL name="addStudent" var="addStudentURL">
	<liferay-portlet:param name="mvcActionCommand" value="addStudent" />
</liferay-portlet:actionURL>

<aui:form action="${addStudentURL}"method="POST">
<aui:input name="firstName" type="text"><aui:validator name="alpha" /></aui:input>
<aui:input name="lastName" type="text"><aui:validator name="alpha" /></aui:input>
<aui:input name="phoneNumber" type="text"><aui:validator name="alphanum" /></aui:input>
<aui:input name="city" type="text"><aui:validator name="alpha" /></aui:input>
<aui:button type="submit" value="Save" name="Save"></aui:button>
</aui:form>