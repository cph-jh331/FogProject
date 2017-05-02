<%-- 
    Document   : signedin
    Created on : 28-Apr-2017, 10:48:36
    Author     : marcofrydshou1
--%>

<%@page import="logic.Register"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% Register r = (Register) session.getAttribute("r");%>
    
    <head>
        <style>
            
a:link, a:visited {
    background-color: #21912c;
    color: white;
    padding: 16px 37px;
    text-align: center;
    text-decoration: chocolate;
    display: inline-table;    
}

.wrapper {
    text-align: center;
}

.button {
    position: relative;
    top: 50%;
}


a:hover, a:active {
    background-color: greenyellow;
}
</style>
        
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/modalcss.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <link rel="stylesheet" href="css/standardcss.css">
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif|Roboto" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <br>
        <br>
        <br>
        
        <h1 id="undertitle" class="text-center">Du er nu oprettet som bruger!</h1>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
      
        <h2 id="undertitle" class="text-center"> Klik i venstre hjørne for at ansøge om byggetilladelse til din personlige carport</h2>
        

<a href="https://www.bygogmiljoe.dk" target="_blank">Klik her for byggetilladelse</a>
    
    </body>
</html>
