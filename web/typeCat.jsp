<%-- 
    Document   : typeCat
    Created on : 12-04-2017, 17:20:12
    Author     : Lasse Andersen
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css"> 
        <title>Stykliste</title>
    </head>
    <body>
        <div class="container">
            <table class="table table-bordered">
                <h1>Det her er type category siden!</h1>
                <thead>
                <th>Type</th>
                <th>Kategori</th>
                <th>Længde</th>
                <th>Antal</th>
                <th>Pakke Type</th>
                <th>Beskrivelse</th>
                </thead>
                <%String type = (String) session.getAttribute("type");%>
                <% List<Part> catList = (List<Part>) session.getAttribute("catList");%>
                <% for (Part part : catList) {
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
                <form action="controllerServlet" method="post" >
                    <input type="hidden" name="action" value="addToDatabase" />
                    <tr>
                        <td>
                            <input class="form-control" type="text" name="Type"  placeholder="Type"/>
                        </td>
                        <td>
                            <input class="form-control" type="text" name="Kategori" value="<%=type%>" placeholder="Kategori" disabled/>
                        </td>
                        <td>
                            <input class="form-control" type="text" name="Længde" placeholder="Længde" disabled/>
                        </td>
                        <td>
                            <input class="form-control" type="text" name="Antal" placeholder="Antal" disabled/>
                        </td>
                        <td>
                            <input class="form-control" type="text" name="Pakketype" placeholder="Pakke Type" />
                        </td>
                        <td>
                            <input class="form-control" type="text" name="Beskrivelse" placeholder="Beskrivelse"/>
                        </td>

                    </tr>

                    </tbody>
            </table>
            <input type="submit" value="Tilføj" class="btn btn-success"/>


        </form>
    </div>

    <p id="demo">JavaScript can change HTML content.</p>

    <button type="button" onclick='document.getElementById("demo").innerHTML = "Hello JavaScript!"'>Click Me!</button>
</body>
</html>
