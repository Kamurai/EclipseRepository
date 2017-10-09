<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.Universal" %>
<%@page import="section3.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal uni = new Universal();
            Custom cust = new Custom();
            Layout lay = new Layout(cust);
            int level = 1;
            int pagenumber = 2;
            int extension = 3;

            out.println(uni.WriteHeader(level, 3));
        %>
    </head>
        <%
            out.println(lay.WriteWebpage(pagenumber,level,extension));
        %>
</html>
