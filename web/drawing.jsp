<%-- 
    Document   : drawing
    Created on : 06-05-2017, 13:07:35
    Author     : bloch
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
        <title>Drawing</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <%String topDrawing = (String) request.getSession().getAttribute("topDrawing");%>
                <%=topDrawing%>
                <form action="controllerServlet" method="post">
                    <input type="hidden" name="action" value="savedrawing"/>
                    <input type="submit" class="btn-success" value="Accepter tegning"/>
                </form>
                <form action="controllerServlet" method="post">
                    <input type="hidden" name="action" value="refusedrawing"/>
                    <input type="submit" class="btn-danger" value="Fortryd tegning"/>
                </form>        

                </form>
            </div>
        </div>
    </body>
</html>
