<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="main.*" %>
<!DOCTYPE HTML>

<html>
    <head>
        <%
            Universal universal = new Universal();
            Custom custom = new Custom();
            Layout layout = new Layout(custom);
            int vLevel = 0;
            int vPage = 2;
            int vExtension = 3;

            out.println(universal.WriteHeader(vLevel, 0));
        %>
    </head>
    <body>
        <%
            out.println(layout.WriteWebpage(vPage,vLevel,vExtension));
        %>
    </body>
</html>