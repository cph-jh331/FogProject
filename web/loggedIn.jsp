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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <link rel="stylesheet" href="css/standardcss.css">
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif|Roboto" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Welcome to Fog  </title>
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
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= user.getUserName()%></a></li>


                        </li>
                        <!--<li><a href="login.jsp"><span class="glyphicon glyphicon-login"></span>Login</a></li>-->
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container">
            <h1>Hello World!<%= user.getUserName()%> </h1>

            <div class="jumbotron">



                <form action="controllerServlet" method="post">

                    <input type="hidden" name="action" value="seeTypeCategory"/>

                    <h2> Tilføj og fjern materialer:</h2>
                    <select class="btn btn-danger dropdown-toggle, col-lg-10" name="TypeCategory">
                        <li class="dropdown-header">Type</li>
                        <option class="form-control" value="Bolt/møtrik">Bolt/Møtrik</option>                    
                        <option class="form-control" value="Hulbånd">Hulbånd</option>
                        <option class="form-control" value="Overstern">Overstern</option>                    
                        <option class="form-control" value="Rem">Rem</option>                    
                        <option class="form-control"  value="Skur">Skur</option>                    
                        <option class="form-control" value="Skruer">Skruer</option>                                            
                        <option class="form-control" value="Stolpe">Stolpe</option>                    
                        <option class="form-control" value="Spær">Spær</option>                    
                        <option class="form-control" value="Tag">Tag</option>
                        <option class="form-control" value="Understern">Understern</option>                    
                        <option class="form-control" value="Vandbræt">Vandbræt</option>                    
                        </ul>                    
                    </select>
                    <input class="btn btn-group-lg" type="submit" value="vælg">


                </form>
            </div>
            <div class="jumbotron">
                <h2> Lav en stykliste til en carport med mål</h2>
                <form action="controllerServlet" method="post">
                    <input type="hidden" name="action" value="seelist">
                    <input type="number" name="length" value="" placeholder="Længde" required  />
                    <input type="number" name="width" value="" placeholder="Bredde" required />
                    <input type="number" name="height" value="" placeholder="Højde" required/>
                    <input type="submit" value="trykher">
                </form>
            </div>
        </div>
    </body>
</html>
