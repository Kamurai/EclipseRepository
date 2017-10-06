<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal uni = new Universal();
            Custom cust = new Custom();
            Layout lay = new Layout(cust);
            int level = 0;
            int pagenumber = 0;
            int extension = 3;

            out.println(uni.WriteHeader(level, 0));
        %>
    </head>
        <%
            out.println(lay.WriteWebpage(pagenumber,level,extension));
        %>

</html>