<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Checkout Cart</title>
		<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
		<jsp:include page="/WEB-INF/views/Header.jsp" />
	</head>
	
	<body>
		
		<section id="checkoutFormBorder">
			
			<div id="enterText">
        		Enter Details :
        	</div>
        	
        	<div id="checkOutForm">
        		
        		<div>
        			<form action="checkoutUser" method="POST">
	        			
	        			<input id="inputReg" type="text" name="firstname" placeholder='First name' required>
		        		<input id="inputReg" type="text" name="lastname" placeholder='Last name' required>
		        		<input id="inputReg" type="email" name="email" placeholder='Email' required>
		        		<input id="inputReg" type="text" name="phonenumber" placeholder='Phone Number' required>
		        		<input id="inputReg" type="text" name="cardnumber" placeholder='Card Number' required>
		        		<input id="inputReg" type="text" name="expirydate" placeholder='Exp Date' required>
		        		
		        		<div id="shippingaddress">
		        			Enter shipping address :
		        		</div>
		        		
		        		<input id="inputReg" type="text" name="street" placeholder='Street' required>
		        		<input id="inputReg" type="text" name="city" placeholder='City' required>
		        		<input id="inputReg" type="text" name="state" placeholder='State' required>
		        		<input id="inputReg" type="text" name="zip" placeholder='ZipCode' required>
		        		<input id="inputReg" type="text" name="country" placeholder='Country' required>
		        		
		        		<div id="buttonDiv">
		        			<input id="buttonregister" type="submit" value="Place Order">
		        		</div>
		        	</form>
		        
		        </div>
	        	
	        </div>
		
		</section>
		
		<jsp:include page="/WEB-INF/views/Footer.jsp" />
	</body>


</html>