<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>
	<form action="updateCart" method="POST">
		<table>
			<c:forEach var="x" begin="0" end="${ il.size()-1 }" varStatus="item">
			    <tr>
			    	<td>
			    		<c:out value="${x+1}" />
			    	</td>
			    	<td>
			    		<c:out value="${il[x].name}" />
			    	</td>
			    	<td>
			    		<input name="${il[x].name}" type="number" min="0" max="${il[x].quantityAvailable}" value="${cart.getRecordById(il[x].id).quantityRequested}"/>
			    	</td>
			    	<td>
			    		<c:out value="${il[x].quantityAvailable}" />
			    	</td>
			    	<td>
			    		$<c:out value="${il[x].price}" />
			    	</td>
			    	<td>
			    		<c:out value="${il[x].description}" />
			    	</td>
			    </tr>
			</c:forEach>
		</table>
		
		<input type="submit" value="Update Cart" />
	</form>
</body>
</html>