<%-- 
    Document   : AgregarVideo
    Created on : 20/10/2019, 04:25:08 PM
    Author     : tecnologo
--%>

<%@page import="java.util.Collection"%>
<%@page import="DT.DtVideo"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String lista = request.getParameter("value");
             FabricaSistema f = new FabricaSistema();
            ISistema s = f.getSistema();
            Collection<DtVideo> videos = s.ListaTVideos();
        %>

    </body>
</html>
