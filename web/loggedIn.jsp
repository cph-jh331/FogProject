<%-- 
    Document   : login
    Created on : 31-03-2017, 10:17:34
    Author     : Pva
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% User user = (User) session.getAttribute("user");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Welcome to Fog  </title>
    </head>
    <body>


        <div class="container">
            <h1>Hello World!<%= user.getUserName()%> </h1>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">placeholderting
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li class="dropdown-header">Type</li>
                    <li><a href="#">Tag</a></li>
                    <li><a href="#">Understern</a></li>
                    <li><a href="#">Overstern</a></li>
                    <li><a href="#">Vandbræt</a></li>
                    <li><a href="#">Stolpe</a></li>
                    <li><a href="#">Spær</a></li>
                    <li><a href="#">Skur</a></li>
                    <li><a href="#">Rem</a></li>
                    <li><a href="#">Skruer</a></li>
                    <li><a href="#">Hulbånd</a></li>
                    <li><a href="#">Beslag</a></li>
                    <li><a href="#">Bolt/Møtrik</a></li>
                    
                    <li class="divider"></li>
                    <li class="dropdown-header">fisk2</li>
                    <li><a href="#">About Us</a></li>
                </ul>
            </div>
            
            <form class="alert-danger" action="controllerServlet" method="post">
                
                <input type="hidden" name="action" value="seeTypeCategory"/>
                
                <select class="btn btn-danger dropdown-toggle" name="TypeCategory">
                    <li class="dropdown-header">Type</li>
                    <li><option class="form-control" value="Tag">Tag</option></li>
                    <option class="dropdown-item" type="button" value="Understern">Understern</option>                    
                    <option class="form-control" value="Overstern">Overstern</option>                    
                    <option class="form-control"  value="Skur">Skur</option>                    
                    <option class="form-control" value="Bolt/møtrik">Bolt/Møtrik</option>                    
                    <option class="form-control" value="Skruer">Skruer</option>                    
                    <option class="form-control" value="Hulbånd">Hulbånd</option>                    
                    <option class="form-control" value="Vandbræt">Vandbræt</option>                    
                    <option class="form-control" value="Stolpe">Stolpe</option>                    
                    <option class="form-control" value="Spær">Spær</option>                    
                    <option class="form-control" value="Rem">Rem</option>                    
                    <option class="form-control" value="Hulbånd">Hulbånd</option>
                </ul>                    
                </select>
                <input type="submit" value="vælg">
                
                
            </form>
            
            <form action="controllerServlet" method="post">
                <input type="hidden" name="action" value="seelist">
                <input type="number" name="length" value="" placeholder="Længde" required  />
                <input type="number" name="width" value="" placeholder="Bredde" required />
                <input type="number" name="height" value="" placeholder="Højde" required/>
                <input type="submit" value="trykher">
            </form>
        </div>
    </body>
</html>
