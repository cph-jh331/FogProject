<%-- 
    Document   : login
    Created on : 06-04-2017, 21:49:03
    Author     : Lasse, Per, Marco, John
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <title>Login Page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user");%>
        <div class="container">
            <div class="form-group">
                <form action="ControllerServlet" method="post">
                    <input type="hidden" name="action" value="login"/>
                    <input type="text" name="email" value="" placeholder="username" required/>
                    <input type="password" name="password" value="" placeholder="password"  required>
                    <input class="btn btn-danger" type="submit" name="Login" value="Enter">
                </form>
            </div>
        </div>
    </body>
</html>
