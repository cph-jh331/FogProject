
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
    <%HashMap<Integer, Part> woodMap = (HashMap<Integer, Part>) request.getSession().getAttribute("woodMap");%>
    <%HashMap<Integer, Part> roofMap = (HashMap<Integer, Part>) request.getSession().getAttribute("roofMap");%>
    <%HashMap<Integer, Part> miscMap = (HashMap<Integer, Part>) request.getSession().getAttribute("miscMap");%>
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
                        for (Map.Entry<Integer, Part> entry : woodMap.entrySet())
                        {
                    %>
                    <tr>
                        <td>
                            <%=entry.getValue().getType()%>  
                        </td>                    
                        <td>
                            <%=entry.getValue().getCategory()%>
                        </td>
                        <td>
                            <%=entry.getValue().getLength()%>
                        </td>
                        <td>

                            <%=entry.getValue().getPacketSize()%>

                        </td>
                        <td>
                            <%=entry.getValue().getUnitName()%>

                        </td>
                        <td>
                            <%=entry.getValue().getDescription()%>

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
                    for (Map.Entry<Integer, Part> entry : roofMap.entrySet())
                    {
                %>
                <tr>
                    <td>
                        <%=entry.getValue().getType()%>  
                    </td>                    
                    <td>
                        <%=entry.getValue().getCategory()%>
                    </td>
                    <td>
                        <%=entry.getValue().getLength()%>
                    </td>
                    <td>

                        <%=entry.getValue().getPacketSize()%>

                    </td>
                    <td>
                        <%=entry.getValue().getUnitName()%>

                    </td>
                    <td>
                        <%=entry.getValue().getDescription()%>

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
                    for (Map.Entry<Integer, Part> entry : miscMap.entrySet())
                    {
                %>
                <tr>
                    <td>
                        <%=entry.getValue().getType()%>  
                    </td>                    
                    <td>
                        <%=entry.getValue().getCategory()%>
                    </td>
                    <td>
                        <%=entry.getValue().getLength()%>
                    </td>
                    <td>

                        <%=entry.getValue().getPacketSize()%>

                    </td>
                    <td>
                        <%=entry.getValue().getUnitName()%>

                    </td>
                    <td>
                        <%=entry.getValue().getDescription()%>

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
