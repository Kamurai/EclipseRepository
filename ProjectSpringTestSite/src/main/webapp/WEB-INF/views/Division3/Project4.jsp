<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.Universal" %>
<%@page import="division3.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal vUniversal = new Universal();
            Custom vCustom = new Custom();
            Layout vLayout = new Layout(vCustom);
            int vLevel = 1;
            int vPage = 4;
            
            out.println(vUniversal.WriteHeader(vLevel, 3));
        %>
    </head>
        <%
            out.println(vLayout.WriteWebpage(vPage,vLevel));
        %>
</html>
