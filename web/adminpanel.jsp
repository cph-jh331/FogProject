<%-- 
    Document   : userPanel
    Created on : 28-04-2017, 09:16:49
    Author     : Lasse Andersen
--%>

<%@page import="logic.User"%>
<%@page import="logic.SvgDrawing"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% User admin = (User) session.getAttribute("user");%>
    <% List<SvgDrawing> svgMapReqApproval = (List<SvgDrawing>) session.getAttribute("svgMapReqApproval");%>
    <% List<SvgDrawing> svgMapApproved = (List<SvgDrawing>) session.getAttribute("svgMapApproved");%>
    <% List<SvgDrawing> svgMapDone = (List<SvgDrawing>) session.getAttribute("svgMapDone");%>
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
                        <li id="makeLink" class="list-group-item">
                            <div id="makeLink2" class="input-group">
                                <li><a href="loggedinadmin.jsp">Back To Admin</a>
                                </li>
                                <li id="makeLink" class="list-group-item">
                                    <form action="controllerServlet" method="post">
                                        <input type="hidden" name="action" value="logout"/>
                                        <input class="btn btn-success" type="submit" name="logout" value="Logout"/>
                                    </form>
                                </li>
                            </div>
                        </li>
                    </ul>


                </div>



        </nav>
        <div class="container">
            <%--Brugers tegninger til godkendelse--%>
            <h1>Hej <%= admin.getFirstName()%> </h1>
            <div class="jumbotron">
                <table class="table table-bordered">

                    <p style="color: white"> Tegninger der venter godkendelse: <%= svgMapReqApproval.size()%> </p>                         
                    <thead class="bg-primary">
                    <th> Tegning id: </th>
                    <th> Kundenr:
                    <th> Dato oprettet: </th>
                    <th> Status: </th>
                    <th> Se Tegning: </th>


                    </thead>
                    <tbody class="bg-primary">

                        <tr>
                            <%for (SvgDrawing drawing : svgMapReqApproval)
                                {
                            %>
                            <td>
                                <%= drawing.getSvgId()%>
                            </td>
                            <td>
                                <%= drawing.getCustomerId()%>
                            </td>
                            <td>
                                <%= drawing.getDateCreated()%>
                            </td>
                            <td>
                                <%= drawing.getStatusToString()%>
                            </td>
                            <td>
                                <div id="popupWindow2">
                                    <form action="controllerServlet" method="post">
                                        <input type="hidden" name="action" value="seeDrawing">
                                        <input type="hidden" name="drawId" value ="<%=drawing.getSvgId()%>"/>
                                        <input class="btn btn-default" type="submit" value="Se Tegning">
                                    </form>
                                </div>     
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <table class="table table-bordered">

                    <p style="color: white"> Godkendte tegninger: <%= svgMapApproved.size()%> </p>                         
                    <thead class="bg-primary">
                    <th> Tegning id: </th>
                    <th> Kundenr: </th>
                    <th> Dato oprettet: </th>
                    <th> Status: </th>
                    <th> Se Tegning: </th>


                    </thead>
                    <tbody class="bg-primary">

                        <tr>
                            <%for (SvgDrawing drawing : svgMapApproved)
                                {
                            %>
                            <td>
                                <%= drawing.getSvgId()%>
                            </td>
                            <td>
                                <%= drawing.getCustomerId()%>
                            </td>
                            <td>
                                <%= drawing.getDateCreated()%>
                            </td>
                            <td>
                                <%= drawing.getStatusToString()%>
                            </td>
                            <td>
                                <div id="popupWindow2">
                                    <form action="controllerServlet" method="post">
                                        <input type="hidden" name="action" value="seeDrawing">
                                        <input type="hidden" name="drawId" value ="<%=drawing.getSvgId()%>"/>
                                        <input class="btn btn-default" type="submit" value="Se Tegning">
                                    </form>
                                </div>     
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