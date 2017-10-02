<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inventory</title>
<link href="${pageContext.request.contextPath}/resources/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp" />
	<div id="inventory">
		<ul id="inventory_table">
						<c:forEach items="${ pageResults}" var="product" varStatus="loop">
							<c:if test="${not loop.first and loop.index % 5 == 0}">
								<br/>
							</c:if>
							<li>
								<a href="Product?id=${product.id}">
									<img src="${ product.picurl}"/> <br/>
									<c:out value="${ product.name }" /><br/>
									<c:out value="${ product.price }" />
								</a>
							</li>
						</c:forEach>
		</table>

	</div>
	<jsp:include page="/WEB-INF/views/Footer.jsp" />
</body>
</html>