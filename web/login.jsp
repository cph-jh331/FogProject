<%-- 
    Document   : login
    Created on : 06-04-2017, 21:49:03
    Author     : Lasse, Per, Marco, John
--%>

<%@page import="logic.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <link rel="stylesheet" href="css/standardcss.css">
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif|Roboto" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Login Page</title>
    </head>
    <body>

        <nav id="navbar-color" class="navbar navbar-default">
            <div class="container-fluid">
                <!--Nav bar logo with link to picture. -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-left" href="#">
                        <img src="img/foglogo2.png" alt="FogHouse" width="110" height="50">
                    </a>
                </div>
                <!-- Menu Items -- Different boxes in nav-bar. Active beeing the page we are on atm.  No href yet missing pages -->
                <div class="collapse navbar-collapse" id="mainNavBar">
                    <ul class="nav navbar-nav">
                        <li class="active"> <a href="index.html">Home</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/">Byggecenter</a></li>
                        <li><a href="https://johannesfog.dk/designhus/">Designhus</a></li>
                        <li><a href="https://johannesfog.dk/pro/">FogPro</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/om-fog/">Om Fog</a></li>
                    </ul>
                    <!-- Setup of the right side of nav-bar 2 different links for now. No href yet missing pages -->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="signup.jsp"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
                        <li id="makeLink" class="list-group-item">
                            <div id="makeLink2" class="input-group">
                                <form action="controllerServlet" method="post">
                                    <input type="hidden" name="action" value=""/>
                                    <input class="btn btn-success" type="submit" name="Login" value="Login"/>
                                </form>
                            </div>
                        </li>
                        <!--<li><a href="login.jsp"><span class="glyphicon glyphicon-login"></span>Login</a></li>-->
                    </ul>
                </div>
            </div>
        </nav>
        <% Customer customer = (Customer) session.getAttribute("user");%>
        <div class="container">
            <div id="loginbox" class="col-lg-4">
                <div class="form-group">
                    <form action="controllerServlet" method="post">
                        <input type="hidden" name="action" value="customerlogin"/>
                        <input class="input-group" type="text" name="email" value="" placeholder="email" required/>
                        <input class="input-group" type="password" name="password" value="" placeholder="password"  required>
                        <input class="btn btn-success" type="submit" name="Login" value="Enter">
                    </form>
                </div>
                
                <h1>Customer Ske</h1>
            </div>
        </div>
    </body>
</html>
