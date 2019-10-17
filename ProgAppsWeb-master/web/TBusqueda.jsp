<%-- 
    Document   : TBusqueda
    Created on : Oct 13, 2019, 6:53:00 PM
    Author     : kangaru
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <%
                Collection<String> videos = (Collection<String>) session.getAttribute("Resultados");
                Iterator<String> it = videos.iterator();
                while(it.hasNext()){
                    String nom = it.next();%>
                    <a href="Video.jsp?value=<%=nom%>"><%=nom%></a>
                <%}%>
            
        </center>
    </body>
</html>
