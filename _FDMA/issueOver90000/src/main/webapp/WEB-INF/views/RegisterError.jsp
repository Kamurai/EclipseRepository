<%@page import="com.fdmgroup.Entity.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration Failed!</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/Styles.css">
		<jsp:include page="Header.jsp"/>
	</head>
	
	<body>
		<section id="registerFormBorder">
        	
        	<div id="regFailed">
        		Registration Failed !</br>
        		<span id="regFailTry">Please try again.</span>
     		</div>

        	<div id="registerForm">
        		
        		<%ArrayList<Department> list=(ArrayList<Department>)request.getAttribute("deptList");%>
        		<div id="inputBox">
	        		
	        		<form action="register" method="POST">
	        			<input id="inputReg" type="text" name="username" placeholder="Create a username" required>
	        			<input id="inputReg" type="email" name="email" placeholder="Email" required>
	        			<input id="inputReg" type="password" name="password" placeholder="Create a password" required>
		        		<input id="inputReg" type="password" name="confirmPassword" placeholder="Confirm your password" required>	
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
		        </div>

        	    <div id="checkBoxAccept">
        	    	<div id="iAcceptBox">
        	    		<input id="checkboxRem" type="checkbox" name="" value="">
        	    	</div>
        			<div id="iAccept">
        	 			I accept
        			</div>
        			<div  id="dstTandCSec">
        				<a id="dtsTAndC" href="">DITS's terms and conditions</a>
        			</div>
        	    </div>
        	    <div id="buttonRegister">
        			<a href=""><input id="registerButton" type="submit" value="Register"></a>
        			</form>
        	    </div>
        	</div>
        	
        </section>
		
		<jsp:include page="Footer.jsp"/>
	</body>
</html>