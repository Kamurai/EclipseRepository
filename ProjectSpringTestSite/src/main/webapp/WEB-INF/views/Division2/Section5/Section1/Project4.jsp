<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.Universal" %>
<%@page import="division2.section5.section1.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal vUniversal = new Universal();
            Custom vCustom = new Custom();
            Layout vLayout = new Layout(vCustom);
            int vLevel = 3;
            int vPage = 4;
            
            out.println(vUniversal.WriteHeader(vLevel, 2));
        %>
    </head>
    <body>
        <%
            out.println(vLayout.WriteWebpage(vPage,vLevel));
        %>
    </body>
</html>
