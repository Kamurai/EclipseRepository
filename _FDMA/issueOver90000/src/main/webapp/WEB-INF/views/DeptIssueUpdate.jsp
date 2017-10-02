<%@page import="com.fdmgroup.Entity.Status"%>
<%@page import="com.fdmgroup.Entity.Department"%>
<%@page import="com.fdmgroup.Entity.Issue"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update Issue</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/Styles.css">
	</head>

	<body class="mainbody">
		<jsp:include page="Header1.jsp"/>
		<%ArrayList<Department> list=(ArrayList<Department>)request.getAttribute("deptList");%>
		<%ArrayList<Status> statuslist=(ArrayList<Status>)request.getAttribute("statusList");%>
		<%Issue issue=(Issue)request.getAttribute("issue");%>
		<section id="updateBorder">
			
			<div id="title">
				Title Of Issue : <%=issue.getTitle() %> 
			</div>
			
			<div id="userdesc">
				Description : </br>
				<%=issue.getUserDescription() %>
			</div>
			
			<div id="tableBorder1">
				<table>
					<tr>
						<th>#</th>
						<th>Submitted By</th>
						<th>Date Submitted</th>
						<th>Comments</th>
					</tr>
					<tr>
						<td><%=issue.getIssueId() %></td>
						<td><%=issue.getSubmittedByUsername() %></td>
						<td><%=issue.getDateSubmitted() %></td>
						<td><%=issue.getAdminComment() %></td>
					</tr>
				</table>
			</div>
			
			<div id="comment">
				<form action="addcommentdept" method="POST">
					<input id="logInput1" type="text" name="description" placeholder="Add comment" required>
					<input id="" type="hidden" name="issueId" value="<%=issue.getIssueId()%>">
					<a href=""><input id="commentButton" type="submit" value="Submit Comment"></a>
				</form>
			</div>
			
			<div id="issueDisplay">
				<div id="layers">
					Submitted By : <%=issue.getSubmittedByUsername() %>
				</div>
				
				<div id="layers">
					Date Submitted : <%=issue.getDateSubmitted() %>
				</div>
				
				<div id="layers">
					Assigned to : <%=issue.getAssignedToUsername()%>
				</div>
				
				<div id="layers">
					Date Resolved : <%=issue.getDateResolved() %>
				</div>
				
				<div id="layers1">
					<form action="updateissuedept" method="POST">
						<select name="department">
		        				<option value="" disabled selected hidden>Department</option>
		        				<%for(int i=0;i<list.size();i++)
		        					{
		        						Department deptList=list.get(i);%>
		        				<option value="<%=deptList.getDeptId()%>"><%=deptList.getDeptName()%></option>
							    <%} %>
						</select>
						
						<select name="status">
		        				<option value="" disabled selected hidden>Status</option>
		        				<%for(int i=0;i<statuslist.size();i++)
		        					{
		        						Status statusList=statuslist.get(i);%>
		        				<option value="<%=statusList.getStatusId()%>"><%=statusList.getStatusName()%></option>
							    <%} %>
						</select>
						
						<select name="priority">
				        	<option value="" disabled selected hidden>Priority</option>
							<option value="1">1 (Highest)</option>
							<option value="2">2</option>
							<option value="3">3</option>
						    <option value="4">4</option>
							<option value="5">5 (Least)</option>
						</select>
						
						<a href=""><input id="updateIssueButton" type="submit" value="Update Issue"></a>
						
					</form>
				</div>
				
				
			</div>
			
		</section>
	
	
	
	
	
		<jsp:include page="Footer.jsp"/>
	</body>
</html>