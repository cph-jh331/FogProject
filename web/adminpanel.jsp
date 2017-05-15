<%-- 
    Document   : userPanel
    Created on : 28-04-2017, 09:16:49
    Author     : Lasse Andersen
--%>

<%@page import="java.util.List"%>
<%@page import="logic.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Customer customer = (Customer) session.getAttribute("user");%>
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
                                <li><a href="loggedinadmin.jsp">Back To Admin</a></li>
                            </div>
                            <form action="controllerServlet" method="post">
                                <input type="hidden" name="action" value="logout"/>
                                <input class="btn btn-success" type="submit" name="logout" value="Logout"/>
                            </form>
                        </li>                        
                        <!--<li><a href="login.jsp"><span class="glyphicon   fdsafdsf  glyphicon-login"></span>Login</a></li>-->
                    </ul>


                </div>



        </nav>
        <div class="container">
            <%--Brugers tegninger til godkendelse--%>
            <h1>Hej <%= customer.getCusName()%> </h1>
            <div class="jumbotron">
                <form action="controllerServlet" method="post">
                    <input type="hidden" name="action" value="godkend"/>
                    <div id="rates">
                        <input type="submit" class="btn-success" value="Accepter">
                        </form>

                        <form action="controllerServlet" method="post">
                            <input type="hidden" name="action" value="removesvg"/>
                            <div id="rates">
                                <input type="submit" class="btn-success" value="Afvis">
                                </form>  
                            </div>
                        </form>
                        <table class="table table-bordered">
                            <p style="color: red"> Tegninger til godkendelse: </p>
                            <thead class="bg-primary">
                            <th> Navn: </th>
                            <th> Nummer: </th>
                            <th> Email: </th>
                            <th> Tegning: </th>
                            </thead>
                            <%-- <% List<Svg> svgList = (List<Svg>) session.getAttribute("svgList");% --%>
                            <tr class="btn-basic">
                                <td>
                                    <%=customer.getCusName()%>
                                </td>
                                <td> <%=customer.getCusPhone()%> </td>
                                <td>
                                    <%=customer.getCusEmail()%>
                                </td>
                                <td>
                                    <button class="btn-success" name="action" onclick="myFunction()">Vis tegning fra: <%= customer.getCusName()%></button>
                                    <button id="myBtn" style="padding: 1px 2px; ">Vis tegning Fra: <%= customer.getCusName()%></button>  <!-- The Modal -->
                                    <div id="myModal" class="modal">
                                        <!-- Modal content -->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <span class="close">&times;</span>
                                            </div>
                                            <div class="">
                                                <p></p>
                                            </div>
                                            <button class="btn-success" name="action" onclick="myFunction()">Vis tegning fra: <%= customer.getCusName()%></button>
                                        </div>
                                        <!--Vis tegning-->
                                </td>
                            </tr>
                        </table>
                    </div>
                    <%--De godkendte tegninger--%>
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
                                    <%=customer.getCusName()%>
                                </td>
                                <td> <%=customer.getCusPhone()%> </td>
                                <td>
                                    <%=customer.getCusEmail()%>
                                </td>
                                <td>
                                    <%-- <form action="controllerServlet" method="post">
                                         <input type="hidden" name="action" value="draw"/>
                                    --%>

                                    <div class="btn-success">
                                        <button id="Btn" style="padding: 1px 1px; ">Vis tegning Fra: <%= customer.getCusName()%></button>  <!-- The Modal -->
                                        <div id="myModal" class="modal">
                                            <!-- Modal content -->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <span class="close">&times;</span>
                                                    <h2></h2>
                                                </div>
                                                <div class="block">
                                                    <p></p>
                                                </div>
                                                <button class="btn-success" name="action" style="padding: 1px 2px; " onclick="myFunction()">Vis tegning fra: <%= customer.getCusName()%></button>  
                                                </td>
                                                </tr>
                                            </div>
                                        </div>
                        </table>
                    </div>
            </div>                             
    </body>
    <script>

        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

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
        window.onclick = function (event) {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        };
    </script>
    <script>

        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("Btn");

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
        window.onclick = function (event) {
            if (event.target === modal) {
                modal.style.display = "none";
            }
        };
    </script>

    <script type="text/javascript">


        function myFunction()
        {
            window.open("tegning.html");
        }
        var rates = document.getElementById('rates').value;
        var rate_value;

        if (rates === 'accept') {
            rate_value = document.getElementById('r1').value;

        } else if (rates === 'refuse') {
            rate_value = document.getElementById('r2').value;

        }

        document.getElementById('results').innerHTML = rate_value;


    </script>
</html>