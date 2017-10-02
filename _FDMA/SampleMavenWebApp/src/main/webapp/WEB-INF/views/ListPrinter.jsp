<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List Printer</title>
</head>
<body>
	<%
		List<?> list = (List<?>) request.getAttribute("list");

		for(int x = 0; x < list.size(); x++)
		{ 
	%>
			<li>
				<% out.println(list.get(x)); %>
			</li>
		<% } %>

	<ol>
		<c:forEach items="${list}" var="item">
			<li>
        		<c:out value="${item}"/>
      		</li>
   		</c:forEach>
	</ol>
	
</body>
</html>