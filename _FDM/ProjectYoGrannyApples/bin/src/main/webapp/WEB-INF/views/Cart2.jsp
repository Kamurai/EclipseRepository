<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/Header.jsp" />
		<p>Hi there, this is your cart:</p>
		<c:forEach items="${ items}" var="product" varStatus="loop">
			<li>
				<a href="product?id=${product.key.id}"></a>
				<img src="${ product.key.picurl}"/>
				<c:out value="${ product.key.name }" />
				<c:out value="${ product.key.price }" />
				<c:out value="${ product.value }" />
			</li>
		</c:forEach>
		
	<p>Your total is: <c:out value="${ total }" /> 
	</p>
	<div>
		<a href="checkout"><button>To Checkout</button></a>
		<a href="Inventory"><button>To Inventory</button></a>
	</div>
	<jsp:include page="/WEB-INF/views/Footer.jsp" />
</body>
</html>