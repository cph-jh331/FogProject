
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
    <%List<Part> woodList = (List<Part>) request.getSession().getAttribute("woodMap");%>
    <%List<Part> roofList = (List<Part>) request.getSession().getAttribute("roofMap");%>
    <%List<Part> miscList = (List<Part>) request.getSession().getAttribute("miscMap");%>
    <body>
        <div class="container">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Type</th>
                        <th>Kategori</th>
                        <th>Længde</th>
                        <th>Antal</th>
                        <th>Pakke Type</th>
                        <th>Beskrivelse</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Part part : woodList)
                        {
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
                <thead>
                <th>Type</th>
                <th>Kategori</th>
                <th>Længde</th>
                <th>Antal</th>
                <th>Pakke Type</th>
                <th>Beskrivelse</th>
                </thead>

                      <%
                        for (Part part : roofList)
                        {
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

                <thead>
                <th>Type</th>
                <th>Kategori</th>
                <th>Længde</th>
                <th>Antal</th>
                <th>Pakke Type</th>
                <th>Beskrivelse</th>
                </thead>

                      <%
                        for (Part part : miscList)
                        {
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

                </tbody>
            </table>




        </div>
    </body>
</html>
