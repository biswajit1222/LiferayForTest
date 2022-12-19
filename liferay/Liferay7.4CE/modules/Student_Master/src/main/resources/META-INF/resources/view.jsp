<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
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
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/> 
 
<h2 id="stu">welcome to Student Potral </h2>
<%-- <form id="testAjaxForm">
    <input type="text"  id="bulu" name="<portlet:namespace />param3">
    <input type="text"  id="bulu1" name="<portlet:namespace />param1">
    <input type="text"  id="target" name="target">
    <input type="button" value="Submit" onclick="callServeResource()">
</form>
<liferay-portlet:resourceURL var="resourceUrl1" id="resouceStudent">
    <liferay-portlet:param name="param1" value="Value1"/>
    <liferay-portlet:param name="param3" value="${bulu}"/>
</liferay-portlet:resourceURL> --%>

<portlet:renderURL var="addStudentUrl">
<portlet:param name="mvcRenderCommandName" value="addStudent"/>
</portlet:renderURL>
<body>
<%-- <%final String massage=(String)request.getAttribute("bulu"); %>
welcoem team <%=massage %>
<%final String massage1=(String)request.getAttribute("id1"); %>
welcoem team <%=massage1 %> <scrpit>yy</scrpit>
<%final Object massage1=request.getAttribute("students"); %>
welcoem team <%=massage1 %> --%>


<aui:button id="button" type ="submit" value ="add Student"
onClick="<%= addStudentUrl.toString()%>">
</aui:button>

<select name="cars" id="cars" onselect="sec();">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="mercedes">Mercedes</option>
  <option value="audi">Audi</option>
</select>
<button id= "btn" onclick="get()">click me</button>
<!-- <!-- </body>
this is my body 
<input type='text' id='id1' />
<script>get()</script>
<script> 

<body> -->
<style>
td,th{text-align:center}
</style>
	<table id="student" class="table table-bordered table-striped"style="width: 100%">
	<!-- 	 <colgroup>
       <col span="1" style="width: 20%;">
       <col span="1" style="width: 20%;">
       <col span="1" style="width: 20%;">
       <col span="1" style="width: 40%;">
    </colgroup> -->
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

<%--  function deleteAlert() {
  let text = "Do you want to Delete Student, permanently data  removed from DB.";
  if (confirm(text) == true) {
	  onClick=<%=deleteStudentURL.toString()%>" value="Delete"
  } else {
    text = "You canceled!";
  }
}
 --%>
  

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
/* $(function() {
    $("#hello").myFunction1();
}); */
 function myFunction1(){
			 alert("Button clicked");
			console.log("Button clicked");
		 } 
function get(){
	console.log("inside get method11111111");
	var se="biswajit";
	var encoded = window.btoa(se);
	console.log("window.btoa(se)::::::::::"+encoded);
	$("#add").val();
	console.log("x"+x);
	//$("#add").hide();
	var x=$("#btn").prop("disabled","false");
	console.log("x"+x.val());
	console.log("x"+x.value);
	sec();
	}
	function sec(){
	console.log("inside sec id");
	var z=$("#cars").val();
	console.log("inside sec id"+z);
	var xx=document.getElementById("cars");
	console.log("inside sec cars....."+xx);
	//document.getElementById("id1").value = z;
	// how to use multiple css element in jQuery
	$("#add").css({"background-color":"red","color":"blue"});
	}
	/* function callServeResource(){
		console.log("inside callServeResource ()");
		var xx=document.getElementById("cars").value;
		console.log("inside callServeResource ()"+xx);
		var z=$("#bulu").val();
		console.log("inside sec id"+z);
	    AUI().use('aui-io-request', function(A){
	        A.io.request('${resourceUrl1}', {
	               method: 'post',
	               data: {
	                   <portlet:namespace />param2:z ,
	                   <portlet:namespace />param1:z                   
	               },
	          /*  form:{
	                   id:'testAjaxForm'
	               },  
	               on: {
	                       success: function() {
	                    alert(this.get('responseData'));
	                   }
	              }
	        });
	 
	    });
	} */
	var yy;
	function callServeResource(){
		var z=$("#bulu").val();
		$.ajax({
			type :"POST",
			url:'${resourceUrl1}',
			 data: {
                 <portlet:namespace />param2:z ,
                 <portlet:namespace />param1:z                   
             },	
			success: function(result) {
              alert(result);
              
              yy=result;
             // document.getElementById("yy").innerHTML = yy;
              $("#target").text(yy);
               }
			
		});
	}
</script>
</body>

