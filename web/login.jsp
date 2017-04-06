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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <title>Welcome to Fog  </title>
    </head>


    <body>
        <div class="container">
            <h1>Hello World!<%= user.getUserName()%> </h1>

            <form action="controllerServlet" method="post">
                <input type="hidden" name="seelist" value="seelist">
                <input type="number" name="length" value="" placeholder="Længde" required  />
                <input type="number" name="width" value="" placeholder="Bredde" required />
                <input type="number" name="height" value="" placeholder="Højde" required/>
                <input type="submit" value="trykher">
            </form>
        </div>
    </body>
</html>
