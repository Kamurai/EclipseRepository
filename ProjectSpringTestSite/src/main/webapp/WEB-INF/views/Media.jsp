<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal vUniversal = new Universal();
            Custom vCustom = new Custom();
            Layout vLayout = new Layout(vCustom);
            int vPage = 2;
            int vLevel = 0;
            int vDivision = 0;

            out.println(vUniversal.getHead(vLevel, vDivision));
        %>
    </head>
    <body>
        <%
            out.println(vLayout.getBody(vPage, vLevel));
        %>
    </body>
</html>