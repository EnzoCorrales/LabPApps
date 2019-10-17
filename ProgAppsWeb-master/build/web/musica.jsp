<%-- 
    Document   : musica
    Created on : 16 oct. 2019, 12:16:32
    Author     : tecnologo
--%>

<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="DT.DtCategoria"%>
<%@page import="Entidades.Categoria"%>
<%@page import="java.sql.*"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="Entidades.Fecha"%>
<%@page import="DT.DtLR"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="DT.DtVideo"%>
<%@page import="DT.DtCanal"%>
<%@page import="DT.DtUsuario"%>
<%@page import="Controladores.Sistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Musica</title>
        <link rel="stylesheet" type="text/css" href="Musica.css">
    </head>
    <body>
        <%String valor = request.getParameter("value");%>
        <h1><%=valor%></h1>

        <%
            FabricaSistema f = new FabricaSistema();
            ISistema s = f.getSistema();
            Collection<DtVideo> dtvids = s.ListaTVideos();
            Iterator<DtVideo> it = dtvids.iterator();
            String url = null;
            String Auxurl = "https://www.youtube.com/embed/iR1sAex__VA";
            String name = "null";
            while (it.hasNext()) {
                DtVideo dtvid = it.next();
                Auxurl = dtvid.getURL();
                url = Auxurl.substring(17, 28);
                name = dtvid.getNomVideo();
                String cat = dtvid.getCategoria();
                if (cat.equalsIgnoreCase(valor)) {%>
        <div>
            <%=name%>
        </div>
        <iframe width="200" height="105" src="https://www.youtube.com/embed/<%=url%>"></iframe>
            <%
                    }
                }
            %>
    </body>
</html>
