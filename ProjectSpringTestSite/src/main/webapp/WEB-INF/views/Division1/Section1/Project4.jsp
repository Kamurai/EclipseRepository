<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.Universal" %>
<%@page import="division1.section1.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal vUniversal = new Universal();
            Custom vCustom = new Custom();
            Layout vLayout = new Layout(vCustom);
            int vPage = 4;
            int vLevel = 2;
            int vDivision = 1;
            
            out.println(vUniversal.getHead(vLevel, vDivision));
        %>
    </head>
    <body>
        <%
            out.println(vLayout.getBody(vPage, vLevel));
        %>
    </body>
</html>
