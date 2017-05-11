<%-- 
Document   : login
Created on : 31-03-2017, 10:17:34
Author     : Pva
--%>

<%@page import="java.util.List"%>
<%@page import="logic.SvgDrawing"%>
<%@page import="logic.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Customer customer = (Customer) session.getAttribute("user");%>
    <% List<SvgDrawing> svgDrawings = (List<SvgDrawing>) session.getAttribute("listDrawings");%>


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
                        <%-- <li><a href="adminpanel.jsp"><span class="glyphicon glyphicon-check"></span> KundeKartotek</a></li>
 <li><a><span class="glyphicon glyphicon-user"></span><%= user.getUserName()%></a></li>
 </li> --%>
                        <!--<li><a href="login.jsp"><span class="glyphicon glyphicon-login"></span>Login</a></li>-->
                        <li id="makeLink" class="list-group-item">
                            <div id="makeLink2" class="input-group">
                                <form action="controllerServlet" method="post">
                                    <input type="hidden" name="action" value="logout"/>
                                    <input class="btn btn-success" type="submit" name="logout" value="Logout"/>
                                </form>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <h1>Hello World!<%= customer.getCusName()%> </h1>

            <div class="jumbotron">
                <h2> Lav en tegning</h2>
                <form action="controllerServlet" method="post">
                    <input type="hidden" name="action" value="genDrawing">
                    <input type="number" name="length" value="" placeholder="Længde" required  />
                    <input type="number" name="width" value="" placeholder="Bredde" required />
                    <input type="number" name="height" value="" placeholder="Højde" required/>
                    <input type="submit" value="Generer tegning">
                </form>

                <table class="table table-bordered">
                    <p style="color: white"> Dine tegninger: </p>
                    <!-- user.getcustomerid er der for at se, om det rigtige id kommer ind -->
                    <p> <%=customer.getCustomerId()%>Antal tegninger på liste: <%= svgDrawings.size()%></p>
                    <thead class="bg-primary">
                    <th> Tegning id: </th>
                    <th> Dato oprettet: </th>
                    </thead>
                    <tbody class="bg-primary">
                        <tr class="modal">
                            <%for (SvgDrawing drawing : svgDrawings) {
                            %>
                            <td>
                                <%= drawing.getSvgId()%>
                            </td>
                            <td>
                                <%= drawing.getDateCreated()%>
                                <div id="popupWindow">
                                    <form action="controllerServlet" method="post">
                                        <input type="hidden" name="action" value="seeDrawing">
                                        <input type="hidden" name="drawId" value ="<%=drawing.getSvgId()%>"/>
                                        <input id="ourBtn" class="modal-open" type="submit" value="Se Tegning">
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
                    <p style="color: white"> Dine tegninger: </p>
                    <!-- user.getcustomerid er der for at se, om det rigtige id kommer ind -->
                    <p> <%=customer.getCustomerId()%>Antal tegninger på liste: <%= svgDrawings.size()%></p>
                    <thead class="bg-primary">
                    <th> Tegning id: </th>
                    <th> Dato oprettet: </th>
                    </thead>
                    <tbody class="bg-primary">
                        <tr class="modal">
                            <%for (SvgDrawing drawing : svgDrawings) {
                            %>
                            <td>
                                <%= drawing.getSvgId()%>
                            </td>
                            <td>
                                <%= drawing.getDateCreated()%>
                                <div id="popupWindow">
                                    <form action="controllerServlet" method="post">
                                        <input type="hidden" name="action" value="seeDrawing">
                                        <input type="hidden" name="drawId" value ="<%=drawing.getSvgId()%>"/>
                                        <input id="ourBtn" class="modal-open" type="submit" value="Se Tegning">
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







<script>
    // Get the modal
    var modal = document.getElementById('popupWindow');

    // get the button
    var btn = document.getElementById("ourBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
    btn.onclick = function () {
        modal.style.display = "block";
    };
// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    };
    // When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
};
    
    
</script>



<%-- <p> Antal elemneter i listen: <%= svgDrawings.size()%></p>   
                   <!--
   <% List<SvgDrawing> svgDrawings = (List<SvgDrawing>) session.getAttribute("svgDrawings");%>  
   -->
                   <%
                             
%> --%>