<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="main.Universal" %>
<%@ page import="division3.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal vUniversal = new Universal();
            Custom vCustom = new Custom();
            Layout vLayout = new Layout(vCustom);
            int vPage = 1;
            int vLevel = 1;
            int vDivision = 3;
            
            out.println(vUniversal.getHead(vLevel, vDivision));
        %>
    </head>
        <%
            out.println(vLayout.getBody(vPage, vLevel));
        %>
</html>