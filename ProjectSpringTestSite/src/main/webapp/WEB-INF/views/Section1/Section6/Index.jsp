<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.Universal" %>
<%@page import="section1.section6.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal uni = new Universal();
            Custom cust = new Custom();
            Layout lay = new Layout(cust);
            int level = 2;
            int pagenumber = 0;
            int extension = 3;

            out.println(uni.WriteHeader(level, 1));
        %>
    </head>
    <body>
        <%
            out.println(lay.WriteWebpage(pagenumber,level,extension));
        %>
    </body>
</html>