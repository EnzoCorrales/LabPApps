<%-- 
    Document   : index
    Created on : 15 oct. 2019, 15:55:20
    Author     : tecnologo
--%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
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
        <title>UyTube</title>
        <link rel="stylesheet" type="text/css" href="IndexStyle.css">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    </head>
    <body>
        <div class="row">
            <%
                FabricaSistema f = new FabricaSistema();
                ISistema s = f.getSistema();
                Collection<DtVideo> dtvid = s.ListaTVideos();
                Iterator<DtVideo> it = dtvid.iterator();
                String url = null;
                String Auxurl = "https://www.youtube.com/embed/iR1sAex__VA";//M5
                String name = "null";
                String nick = null;
                while (it.hasNext()) {
                    DtVideo dtvids = it.next();
                    Auxurl = dtvids.getURL();
                    url = Auxurl.substring(17, 28);
                    name = dtvids.getNomVideo();
                    nick = dtvids.getPropietario();
            %> 
            <div class="col-sm-2 nopadding">
                <p align="Left Aligned"><a href="Video.jsp?value=<%=name%>&usr=<%=nick%>"><%=name%></a></p>
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe src="//img.youtube.com/vi/<%=url%>/0.jpg" frameborder="0" scrolling="no"></iframe>
                </div>
            </div>
                <% } %>
        </div>
    </body>
</html>
