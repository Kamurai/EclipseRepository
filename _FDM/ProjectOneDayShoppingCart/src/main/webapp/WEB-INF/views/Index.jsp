<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>
	<table>
		<c:forEach var=x begin="0" end="${ il.getSize()-1 }" varStatus="il">
		    <tr>
		    	<td>
		    		${x+1}
		    	</td>
		    	<td>
		    		${il.get(x).name}
		    	</td>
		    	<td>
		    		${cart.getQuantityRequestedByItemId(il.get(x).id)}
		    	</td>
		    	<td>
		    		${il.get(x).quantityAvailable}
		    	</td>
		    	<td>
		    		$${il.get(x).price}
		    	</td>
		    	<td>
		    		${il.get(x).description}
		    	</td>
		    </tr>
		</c:forEach>
	</table>
</body>
</html>