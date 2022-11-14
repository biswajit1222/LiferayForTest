<%@ include file="/init.jsp" %>
<!-- <p>
	<b><liferay-ui:message key="student_master.caption"/></b>
</p> -->
<script type="text/javascript" charset="utf8"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.16/js/dataTables.jqueryui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/dataTables.jqueryui.min.css" />
 
<h2 id="stu">welcome to Student Potral</h2>
<style>
/* #stu{
  text-align: center;
} */
</style>

<%-- <%-- <portlet:resourceURL id="addResource" var="addresourceval">
 <portlet:param name="Country" value=""${country}"/>
</portlet:resourceURL> --%> 
<aui:select name="Country"id="country"onClick="get()">
    <aui:option value="Select">Select</aui:option>
    <aui:option value="INDIA">INDIA</aui:option>                       
    <aui:option value="USA">USA</aui:option>                            
    <aui:option value="LONDON">LONDON</aui:option>                            
    <aui:option value="RUSSIA">RUSSIA</aui:option>    
</aui:select>









<portlet:renderURL var="addStudentUrl">
<portlet:param name="mvcRenderCommandName" value="addStudent"/>

</portlet:renderURL>
<aui:button id="button" type ="submit" value ="add Student"
onClick="<%= addStudentUrl.toString()%>">
</aui:button>


<body>

	<table id="student" class="table table-bordered table-striped"
		style="width: 100%";">
		<thead>
			<tr>
			   
				<th>First Name</th>
				<th>Last Name</th>
				<th>Mobile Number</th>
				<th>City</th>
				<th>ACTIONS</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.contactNo}</td>
					<td>${student.workLocation}</td>
				<td>
				
				<portlet:renderURL var="addStudentUrl">
   				<portlet:param name="mvcRenderCommandName" value="addStudent"/>
				</portlet:renderURL>
				
				<aui:button type ="submit" value ="Add Student"
				onClick="<%= addStudentUrl.toString()%>"
				style="background-color: blue" /> &nbsp;&nbsp; 
				
				<liferay-portlet:renderURL var="editStudentURL">
				<liferay-portlet:param name="mvcRenderCommandName"
				value="editStudent" />
				<liferay-portlet:param name="studentId" value="${student.studentId}" />
				</liferay-portlet:renderURL> 
								
				<aui:button cssClass="button" type="submit"
				onClick="<%=editStudentURL.toString()%>" value="Edit "
				style="background-color: green" /> &nbsp;&nbsp; 
				
							
				<liferay-portlet:renderURL var="deleteStudentURL">
				<liferay-portlet:param name="mvcRenderCommandName" value="deleteStudent" />
				<liferay-portlet:param name="studentId" value="${student.studentId}" />
				</liferay-portlet:renderURL> 
				
				<aui:button cssClass="button" type="submit"
				onClick="<%=deleteStudentURL.toString()%>" value="Delete"
				style="background-color: red" /> &nbsp;&nbsp; 
</td>
			</c:forEach>

		</tbody>
	</table>

<%-- function deleteAlert() {
  let text = "Do you want to Delete Student, permanently data  removed from DB.";
  if (confirm(text) == true) {
	  onClick=<%=deleteStudentURL.toString()%>" value="Delete"
  } else {
    text = "You canceled!";
  }
} --%>

  

	</body>

<script>

$(document).ready(function () {            
	$('#student').DataTable({                         
	     // of the DataTable            
		 searching: true           
		 });
	 $("#stu").css("color", "green");
	  $("#stu").css("text-align", "center"); 
	}); 
$(function() {
    $("#hello").myFunction1();
});
function myFunction1(){
			 alert("Button clicked");
			console.log("Button clicked");
		 }
function get(){

}
</script>

