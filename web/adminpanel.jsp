<%-- 
    Document   : userPanel
    Created on : 28-04-2017, 09:16:49
    Author     : Lasse Andersen
--%>

<%@page import="java.util.List"%>
<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% User user = (User) session.getAttribute("user");%>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <link rel="stylesheet" href="css/standardcss.css">
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif|Roboto" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Admin Panel</title>
        <%--Alt her er også nyt --%>
    </head>
    <body>
        <!-- Beginning of navbar setup. using default to customize color in css with #id    -->
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
                        <li> <a href="index.html">Home</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/">Byggecenter</a></li>
                        <li><a href="https://johannesfog.dk/designhus/">Designhus</a></li>
                        <li><a href="https://johannesfog.dk/pro/">FogPro</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/om-fog/">Om Fog</a></li>
                    </ul>
                    <!-- Setup of the right side of nav-bar 2 different links for now. No href yet missing pages -->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="loggedIn.jsp">Back To Admin</a></li>
                </div>
                </li>
                <!--<li><a href="login.jsp"><span class="glyphicon glyphicon-login"></span>Login</a></li>-->
                </ul>

            </div>
        </div>
    </div>
</nav>

<div class="container">
    <h1>Hej <%= user.getUserName()%> </h1>

    <div class="jumbotron">
        <table class="table table-bordered">

            <p style="color: white"> Tegninger til godkendelse: </p>
            <thead class="bg-primary">
            <th> Navn: </th>
            <th> Nummer: </th>
            <th> Email: </th>
            <th> Tegning: </th>
            </thead>
            <%-- <% List<Svg> svgList = (List<Svg>) session.getAttribute("svgList");% --%>

            <tr class="btn-basic">
                <td>
                    <%=user.getUserName()%>
                </td>
                <td> Mobilnummer her </td>
                <td>
                    <%=user.getEmail()%>

                </td>
                <td>
                    <%-- <form action="controllerServlet" method="post">
                         <input type="hidden" name="action" value="draw"/>
                    --%>
                    <form action="controllerServlet" method="post">
                        <input type="hidden" name="action" value="hej"/>
                        <div id="rates">
                            <input type="radio" id="r1" name="rate" value="accept" />Accepter
                            <input type="radio" id="r2" name="rate" value="refuse" />Kassér
                            <br>
                            <input type="submit" class="btn-success" value="Send">
<<<<<<< HEAD
=======
                            <button class="btn-success" name="action" onclick="myFunction()">Vis tegning fra: <%= user.getUserName()%></button>
>>>>>>> 8cd58bed855a91d853052c2325bdb4d248b1845a
                        </div>

                </td>
            </tr>

        </table>
        </form>
<<<<<<< HEAD
                            <button class="btn-success" name="action" onclick="myFunction()">Vis tegning fra: <%= user.getUserName()%></button>
=======
>>>>>>> 8cd58bed855a91d853052c2325bdb4d248b1845a
    </div>
    <div class="jumbotron">
        <table class="table table-bordered">

            <p style="color: white"> Godkendte tegninger: </p>
            <thead class="bg-primary">
            <th> Navn: </th>
            <th> Nummer: </th>
            <th> Email: </th>
            <th> Tegning: </th>
            </thead>
            <%-- <% List<Svg> svgList = (List<Svg>) session.getAttribute("svgList");% --%>

            <tr class="btn-basic">
                <td>
                    <%=user.getUserName()%>
                </td>
                <td> Mobilnummer her </td>
                <td>
                    <%=user.getEmail()%>

                </td>
                <td>
                    <%-- <form action="controllerServlet" method="post">
                         <input type="hidden" name="action" value="draw"/>
                    --%>
<<<<<<< HEAD
                    

                    <button class="btn-success" name="action" style="padding: 1px 2px; " onclick="myFunction()">Vis tegning fra: <%= user.getUserName()%></button>  
=======
                    <button class="btn-success" name="action" style="padding: 1px 2px; " onclick="myFunction()">Vis tegning fra: <%= user.getUserName()%></button>  
                    

>>>>>>> 8cd58bed855a91d853052c2325bdb4d248b1845a
                </td>
            </tr>

        </table>
    </div>
</div>
</body>
<script type="text/javascript">

    function myFunction()
    {
        window.open("tegning.html");
    }
    var rates = document.getElementById('rates').value;
    var rate_value;
    if (rates == 'accept') {
        rate_value = document.getElementById('r1').value;

    } else if (rates == 'refuse') {
        rate_value = document.getElementById('r2').value;

    }

    document.getElementById('results').innerHTML = rate_value;
</script>
</html>
