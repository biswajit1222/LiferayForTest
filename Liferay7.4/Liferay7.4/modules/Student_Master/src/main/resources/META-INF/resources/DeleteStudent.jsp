<%@ include file="/init.jsp"%>
<h2>Edit Employee Page</h2>
<liferay-portlet:actionURL name="DeleteStudent" var="deleteStudentURL">
	<liferay-portlet:param name="mvcActionCommand" value="DeleteStudent" />
</liferay-portlet:actionURL>
<style>
h2 {
	text-align: center
}
</style>

<aui:form action="${deleteStudentURL}">
<aui:input name="studentID" type="text" value="${studentId}"></aui:input>
<aui:button type="submit" value="Delete" name="Delete"></aui:button>
</aui:form>