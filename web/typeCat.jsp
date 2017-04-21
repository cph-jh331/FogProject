<%-- 
    Document   : typeCat
    Created on : 12-04-2017, 17:20:12
    Author     : Lasse Andersen
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Part"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%String type = (String) session.getAttribute("type");%>
    <%String category = (String) session.getAttribute("category");%>
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
            <div class="jumbotron">
                <table class="table table-bordered">
                    <h2>Det her er <%=type%>!</h2>
                    <thead class="bg-success">
                    <th>Type</th>
                    <th>Kategori</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Pakke Type</th>
                    <th>Beskrivelse</th>
                    </thead>
                    <% List<Part> catList = (List<Part>) session.getAttribute("catList");%>
                    <% for (Part part : catList)
                        {
                    %>
                    <tr class="bg-primary">
                        <td>
                            <%=part.getType()%>  
                        </td>                    
                        <td>
                            <%=part.getCategory()%>
                        </td>
                        <td>
                            <%=part.getLength()%>
                        </td>
                        <td>
                            <%=part.getPacketSize()%>
                        </td>
                        <td>
                            <%=part.getUnitName()%>
                        </td>
                        <td>
                            <%=part.getDescription()%>
                        </td>
                        <td>

                            <form action="controllerServlet" method="post">
                                <input type="hidden" name="action" value="removeFromDatabase"/>
                                <input type="hidden" name="removeItem" value="<%=part.getPartId()%>"/>
                                <input class="btn btn-danger" type="submit" value="Fjern"/>
                            </form>

                        </td>
                    </tr>
                    <%
                        }
                    %>
                    <form action="controllerServlet" method="post" >
                        <input type="hidden" name="action" value="addToDatabase" />
                        <tr class="bg-primary">
                            <td>
                                <input class="form-control" type="text" name="Type"  placeholder="Type" required/>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="Kategori" value="<%=category%>" placeholder="Kategori" disabled/>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="Længde" placeholder="Længde" disabled/>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="Antal" placeholder="Antal" disabled/>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="Pakketype" placeholder="Pakke Type" required/>
                            </td>
                            <td>
                                <input class="form-control" type="text" name="Beskrivelse" placeholder="Beskrivelse" required/>
                            </td>
                            <td>
                                <input type="submit" value="Tilføj" class="btn btn-success"/>                            
                            </td>
                        </tr>
                        </tbody>
                </table>
                </form>
            </div>

        </div>
    </body>
</html>
