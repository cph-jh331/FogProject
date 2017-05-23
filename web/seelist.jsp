
<%@page import="logic.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="logic.Part"%>
<%@page import="logic.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

        <title>Stykliste</title>
    </head>
    <%User user = (User) session.getAttribute("user");%>
    <%List<Part> woodList = (List<Part>) request.getSession().getAttribute("woodMap");%>
    <%List<Part> roofList = (List<Part>) request.getSession().getAttribute("roofMap");%>
    <%List<Part> miscList = (List<Part>) request.getSession().getAttribute("miscMap");%>
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
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span><%= user.getFirstName()%></a></li>


                        </li>
                        <!--<li><a href="login.jsp"><span class="glyphicon glyphicon-login"></span>Login</a></li>-->
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h2>
                    Stykliste til Carport
                </h2>
                <table class="table table-bordered">
                    <thead class="bg-success">
                        <tr>
                            <th>Type</th>
                            <th>Kategori</th>
                            <th>Længde</th>
                            <th>Antal</th>
                            <th>Pakke Type</th>
                            <th>Beskrivelse</th>
                        </tr>
                    </thead>
                    <tbody class="bg-primary">
                        <%
                            for (Part part : woodList)
                            {
                        %>
                        <tr>
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
                        </tr>
                        <%
                            }
                        %>
                    <thead class="bg-success">
                    <th>Type</th>
                    <th>Kategori</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Pakke Type</th>
                    <th>Beskrivelse</th>
                    </thead>

                    <%
                        for (Part part : roofList)
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
                    </tr>
                    <%
                        }
                    %>

                    <thead class="bg-success">
                    <th>Type</th>
                    <th>Kategori</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Pakke Type</th>
                    <th>Beskrivelse</th>
                    </thead>

                    <%
                        for (Part part : miscList)
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
                    </tr>
                    <%
                        }
                    %>

                    </tbody>
                </table>

            </div>




        </div>
    </body>
</html>
