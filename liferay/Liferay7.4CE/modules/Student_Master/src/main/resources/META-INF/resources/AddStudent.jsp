<%@ include file="/init.jsp"%>
<h2>Add/update Employee Page</h2>
<liferay-portlet:actionURL name="addStudent" var="addStudentURL">
	<liferay-portlet:param name="mvcActionCommand" value="addStudent" />
</liferay-portlet:actionURL>

<aui:form action="${addStudentURL}"method="POST">
<aui:input name="studentID" type="hidden" value="${studentId}"></aui:input>
<aui:input name="firstName" type="text" value="${firstName}"><aui:validator name="alpha" /></aui:input>
<aui:input name="lastName" type="text" value="${lastName}"><aui:validator name="alpha" /></aui:input>
<aui:input name="phoneNumber" type="text"value="${contactNo}"><aui:validator name="alphanum" /></aui:input>
<aui:input name="city" type="text"value="${workLocation}"><aui:validator name="alpha" /></aui:input>
<aui:button type="submit" value="Save" name="Save"></aui:button>
</aui:form>

