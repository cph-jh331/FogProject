<%-- 
    Document   : drawing
    Created on : 06-05-2017, 13:07:35
    Author     : bloch
--%>

<%@page import="logic.SvgDrawing"%>
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
                <% SvgDrawing svgDrawing = (SvgDrawing) request.getSession().getAttribute("svgDrawing");%>
                <% String whatToDo = (String) request.getSession().getAttribute("whatToDo");%>
                <% String uiDanishSubmitButton = (String) request.getSession().getAttribute("seeDrawingSubmitButton");%>
                <%= svgDrawing.getSvgInline()%>
                <div class="btn-group">
                <form action="controllerServlet" method="post">
                    <input type="hidden" name="action" value="<%=whatToDo%>"/>
                    <input type="hidden" name="drawId" value="<%=svgDrawing.getSvgId()%>"/>
                    <input type="submit" class="btn btn-success" value="<%=uiDanishSubmitButton%>"/>
                </form>
                <form action="controllerServlet" method="post">
                    <input type="hidden" name="action" value="svgRemoveDrawing"/>
                    <input type="submit" class="btn btn-danger" value="Slet Tegning"/>
                </form>
                </div>
            </div>
        </div>
    </body>
</html>
