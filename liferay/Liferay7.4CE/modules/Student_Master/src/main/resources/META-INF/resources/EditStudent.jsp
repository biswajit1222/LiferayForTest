<%-- <%@ include file="/init.jsp"%>
<h2>Edit Employee Page</h2>
<liferay-portlet:actionURL name="EditStudent" var="addStudentURL">
	<liferay-portlet:param name="mvcActionCommand" value="EditStudent" />
</liferay-portlet:actionURL>
<style>
h2 {
	text-align: center
}
</style>

<aui:form action="${addStudentURL}"method="POST">
<aui:input name="studentID" type="hidden" value="${studentId}"></aui:input>
<aui:input name="firstName" type="text" value="${firstName}"></aui:input>
<aui:input name="lastName" type="text"value="${lastName}"></aui:input>
<aui:input name="phoneNumber" type="text"value="${contactNo}"></aui:input>
<aui:input name="city" type="text"value="${workLocation}"></aui:input>
<aui:button type="submit" value="Save" name="Save"></aui:button>
</aui:form> --%>