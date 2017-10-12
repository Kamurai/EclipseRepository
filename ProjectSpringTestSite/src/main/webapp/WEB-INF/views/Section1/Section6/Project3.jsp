<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.Universal" %>
<%@page import="section1.section6.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal vUniversal = new Universal();
            Custom vCustom = new Custom();
            Layout vLayout = new Layout(vCustom);
            int vLevel = 2;
            int vPage = 3;
            
            out.println(vUniversal.WriteHeader(vLevel, 1));
        %>
    </head>
    <body>
        <%
            out.println(vLayout.WriteWebpage(vPage,vLevel));
        %>
    </body>
</html>
