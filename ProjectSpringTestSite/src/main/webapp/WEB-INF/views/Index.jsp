<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal vUniversal = new Universal();
            Custom vCustom = new Custom();
            Layout vLayout = new Layout(vCustom);
            int vLevel = 0;
            int vPage = 0;
            
            out.println(vUniversal.WriteHeader(vLevel, 0));
        %>
    </head>
        <%
            out.println(vLayout.WriteWebpage(vPage,vLevel));
        %>

</html>