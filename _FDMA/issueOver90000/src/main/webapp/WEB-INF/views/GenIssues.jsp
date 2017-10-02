<%@page import="com.fdmgroup.Entity.Issue"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	
	<head>
		<title>General Admin Issues</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/Styles.css">
	</head>

	<body>
		<jsp:include page="Header1.jsp"/>
		
		<%ArrayList<Issue> list=(ArrayList<Issue>)request.getAttribute("genIssueList");%>
		
		<div id="navbar">
			<div id="navtab">
				<a id="navbutton" href="<%=request.getContextPath()%>/viewissues">User Issues</a>
			</div>
			
			<div id="navtab">
				<a id="navbutton" href="<%=request.getContextPath()%>/deptissues">Department admin Issues</a>
			</div>
			
			<div id="navtab">
				<a id="navbutton1" href="<%=request.getContextPath()%>/genissues">General admin Issues</a>
			</div>
		</div>
		
		
		<div id="tableBorder">
			<Table>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>User Description</th>
					<th>Department</th>
					<th>Assigned-To</th>
					<th>Submitted By</th>
					<th>Status</th>
					<th>Priority</th>
					<th>Date Submitted</th>
					<th>Date Resolved</th>
				</tr>
				<% for(int i=0;i<list.size();i++)
				{ 
					Issue issueList=list.get(i);%> 
				<tr>
					<td><%=issueList.getIssueId()%></td>
					<td><%=issueList.getTitle()%></td>
					<td><%=issueList.getUserDescription()%></td>
					<td><%=issueList.getDeptName()%></td>
					<td><%=issueList.getAssignedToUsername()%></td>
					<td><%=issueList.getSubmittedByUsername()%></td>
					<td><%=issueList.getStatus() %></td>
					<td><%=issueList.getPriority() %></td>
					<td><%=issueList.getDateSubmitted()%></td>
					<td><%=issueList.getDateResolved() %></td>
				</tr>
				<%} %>
			</Table>
			
			<div id="newIssue">
				<a id="newIssueButton" href="<%=request.getContextPath()%>/newissue">New Issue</a>
			</div>
		</div>
	
	
		<jsp:include page="Footer.jsp"/>
	</body>
</html>