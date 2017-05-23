<%-- 
    Document   : failed
    Created on : 04-04-2017, 13:14:13
    Author     : Lasse Andersen
--%>

<%@page import="logic.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% User customer = (User) session.getAttribute("user");%>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <link rel="stylesheet" href="css/modalcss.css">
        <link rel="stylesheet" href="css/standardcss.css">
        <link rel="stylesheet" href="css/navbarsetup.css">
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif|Roboto" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Admin Panel</title>
        <%--Alt her er også nyt --%>
    </head>
    <body>
        <h1>Wrong Login</h1>
    </body>
</html>
