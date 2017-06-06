<%-- 
    Document   : SignUp
    Created on : 20-Apr-2017, 11:34:33
    Author     : marcofrydshou1
--%>


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
        <title>SignUp</title>
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
                        <li> <a href="index.html">Home</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/">Byggecenter</a></li>
                        <li><a href="https://johannesfog.dk/designhus/">Designhus</a></li>
                        <li><a href="https://johannesfog.dk/pro/">FogPro</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/om-fog/">Om Fog</a></li>
                    </ul>
                </div>
        </nav>
        <main>
            <div class="container">


                <h2>Sign up</h2>

                <button class="sign" onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Sign Up</button>

                <div id="id01" class="modal">
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">×</span>



                    <form class="modal-content" action="controllerServlet" method="post">
                        <div class="container-fluid">                            
                            <input type="hidden" name="action" value="signup"> 

                            <label><b>Fornavn</b></label>
                            <input class="input-lg" type="text" placeholder="Indtast Navn" name="Fornavn" required/>
                            <label><b>Efternavn</b></label>
                            <input class="input-lg" type="text" placeholder="Indtast Efternavn" name="Efternavn" required/>
                            <label><b>Adresse</b></label>
                            <input class="input-lg" type="text" placeholder="Indtast Adresse" name="Adresse" required/>
                            <label><b>Postnummer</b></label><br>
                            <input class="input-lg" type="number" placeholder="Indtast Postnummer" name="Postnummer" required/><br>
                            <label><b>By</b></label>
                            <input class="input-lg" type="text" placeholder="Indtast By" name="By" required/><br>
                            <label><b>Tlf</b></label><br>
                            <input class="input-lg" type="number" placeholder="Indtast telefon" name="telefon" required/><br>
                            <label><b>Email</b></label>
                            <input class="input-lg" type="text" placeholder="Indtast Email" name="email" required/>

                            <label><b>Password</b></label>
                            <input class="input-lg" type="password" placeholder="Indtast Password" name="psw" required/>

                            <div class="clearfix">
                                <input type="button" value="Cancel "class="btn btn-warning" onclick="document.getElementById('id01').style.display = 'none'" class="cancelbtn"/>                                
                                <input type="submit" class="btn btn-success"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </main>

        <script>
            // Get the modal
            var modal = document.getElementById('id01');

            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function (event) {
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            };
        </script>


    </body>
</html>         

