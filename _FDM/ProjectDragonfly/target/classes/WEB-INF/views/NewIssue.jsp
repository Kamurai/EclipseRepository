<%@page import="com.fdmgroup.Entity.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Enter Issue</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/Styles.css">
		<jsp:include page="Header1.jsp"/>
	</head>


	<body class="mainbody">
		
		<%ArrayList<Department> list=(ArrayList<Department>)request.getAttribute("deptList");%>
		<section id="issueFormBorder">
		
			<div id="newIssueText">
				Enter you issue :
			</div>
			
			<div id="issueForm">
				<form id="logInput" action="submitissue" method="POST">
	        		<input id="logInput1" type="text" name="title" placeholder="Title for your issue" required>
	        		<input id="logInput1" type="text" name="description" placeholder="Enter your issue" required>
	        		
	        		<select name="priority">
			        	<option value="" disabled selected hidden>Priority</option>
						<option value="1">1 (Highest)</option>
						<option value="2">2</option>
						<option value="3">3</option>
					    <option value="4">4</option>
						<option value="5">5 (Least)</option>
					</select>
					
					<div id="selectStyle">
		        			<select name="department">
		        				<option value="" disabled selected hidden>Department</option>
		        				<%for(int i=0;i<list.size();i++)
		        					{
		        						Department deptList=list.get(i);%>
		        				<option value="<%=deptList.getDeptId()%>"><%=deptList.getDeptName()%></option>
							    <%} %>
							</select>
		        		</div>
	        		
	        		
					<a href=""><input id="submitButton" type="submit" value="Submit"></a>
				</form>
			</div>
			
		</section>
	
	
		<jsp:include page="Footer.jsp"/>
	</body>
</html>