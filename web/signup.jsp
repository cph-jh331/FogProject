<%-- 
    Document   : SignUp
    Created on : 20-Apr-2017, 11:34:33
    Author     : marcofrydshou1
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Sign up</title>
        <meta charset="UTF-8">

        <link rel="stylesheet" href="css/modalcss.css">
    
    <style>
        <%--style for sign up button--%>
    .sign {
        background-color: #33e03c;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
    }
    
     <%--style for Nav Bar--%>
     ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #0013a3;
}

li {
    float: right;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #0013a3;
}
    </style>

    </head>

    <body>

        <ul class="nav navbar-nav">
                  <a class="navbar-left" href="#">
                        <img src="img/foglogo2.png" alt="FogHouse" width="110" height="50">
                    </a>
                        <li class="active"> <a href="index.html">Home</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/">Byggecenter</a></li>
                        <li><a href="https://johannesfog.dk/designhus/">Designhus</a></li>
                        <li><a href="https://johannesfog.dk/pro/">FogPro</a></li>
                        <li><a href="https://johannesfog.dk/byggecenter/om-fog/">Om Fog</a></li>
                    </ul>

                <h2>Sign up</h2>

                <button class="sign" onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Sign Up</button>

                <div id="id01" class="modal">
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">×</span>


                       
                    <form class="modal-content " action="controllerServlet" method="post">
                        <div class="container">
                                <input type="hidden" name="action" value="signup"> 
                        
                                <label><b>Fornavn</b></label>
                                <input type="text" placeholder="Indtast Navn" name="Fornavn" required>
                                <label><b>Efternavn</b></label>
                                <input type="text" placeholder="Indtast Efternavn" name="Efternavn" required>
                                <label><b>Adresse</b></label>
                                <input type="text" placeholder="Indtast Adresse" name="Adresse" required>
                                <label><b>Postnummer</b></label>
                                <input type="text" placeholder="Indtast Postnummer" name="Postnummer" required>
                                <label><b>By</b></label>
                                <input type="text" placeholder="Indtast By" name="By" required>
                                <label><b>Tlf</b></label>
                                <input type="text" placeholder="Indtast telefon" name="telefon" required>

                                <label><b>Email</b></label>
                                <input type="text" placeholder="Indtast Email" name="email" required>

                                <label><b>Password</b></label>
                                <input type="password" placeholder="Indtast Password" name="psw" required>

                                <div class="clearfix">
                                    <button type="button" onclick="document.getElementById('id01').style.display = 'none'" class="cancelbtn">Cancel</button>
                                    <button type="submit" class="signupbtn" >Sign Up</button> 

                                </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
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

