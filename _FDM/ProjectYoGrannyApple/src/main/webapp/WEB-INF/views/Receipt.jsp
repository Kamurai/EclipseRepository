<%@page import="org.springframework.ui.Model"%>
<%@page import="com.fdmgroup.appleGram.Checkout"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Receipt</title>
		<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
		<jsp:include page="/WEB-INF/views/Header.jsp" />
	</head>
	
	<body id="receiptBody">
		
		<%Checkout customer=new Checkout();
		  customer=(Checkout)request.getAttribute("customerReciept");%>
		
		<section id="receiptBorder">
			
			<div id="successText">
		 		<span id="textColor"><%=customer.getFirstname()%></span>, your order has been placed succesfully!
			</div>
			
			<div id="orderDetails">
				
				<div id="productDetails">
					
					<div id="product">
						<c:forEach items="${ items }" var="product" varStatus="loop">
							<li>
								<span>You ordered <c:out value="${ product.value }"/> <c:out value="${ product.key.name }"/> apples</span>
							</li>
						</c:forEach>
					</div>
					
					<div id="cost">
						<p>Your total cost for this order is: $<c:out value="${ total }" /> 
					</div>
					
					<div id="copy">
						A copy of receipt is send to :</br>
						<span id="textColor"><%=customer.getEmail()%></span>
					</div>
				
				</div>
				
				<div id="address">
					
					<div id="shipText">
						Order shipped to :
					</div>
					
					<div id="textColor">
						<div id="cusName">
							<%=customer.getFirstname()+" "+customer.getLastname()%>
						</div>
						
						<div id="street">
							<%=customer.getStreet()%>,
					    </div>
					    
						<div id="city">
							<%=customer.getCity() %>
					    </div>
					    <div id="state">
					    	<%=customer.getState() %>
					    </div>
					    <div id="zip">
					    	<%=customer.getZip() %>
					    </div>
					    <div id="country">
					    	<%=customer.getCountry() %>
					    </div>
					    
				    </div>
				    
				    <div id="delivery">
				    	Your order will be delivered on </br>
				    	<span id="textColor">Monday, September 18.</span>
				    </div>
			    </div>
		
		</section>
		
		
		
		
		
		
		
		
		
		
		<jsp:include page="/WEB-INF/views/Footer.jsp" />
	</body>
</html>