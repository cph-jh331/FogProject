<%-- 
    Document   : login
    Created on : 31-03-2017, 10:17:34
    Author     : Pva
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% User user = (User) session.getAttribute("user");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Fog  </title>
    </head>
    <body>
        <h1>Hello World!<%= user.getUserName()%> </h1>
    </body>
</html>
