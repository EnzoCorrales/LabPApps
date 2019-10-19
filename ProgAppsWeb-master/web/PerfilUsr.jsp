<%-- 
    Document   : PerfilUsr
    Created on : Oct 14, 2019, 2:47:39 PM
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
        <link rel="stylesheet" type="text/css" href="MiPerfilstyle.css">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String prop = (String) session.getAttribute("value");
        %>
        <h1 class="titulos"><img src="https://pbs.twimg.com/media/Do4L0ULXUAAbQLZ.png" class="imgPerfil">  <%=prop%>
            <form action="PerfilUsr.jsp">
                <%
                    FabricaSistema f = new FabricaSistema();
                    ISistema s = f.getSistema();
                %>
                <input class="no" type="submit" class="titulos" value="Suscribirse">
            </form>
        </h1>
            <%
                String c = null;
                if (prop != null) {
                    DtUsuario dtusr = s.getDataUsuario(prop);
                    DtCanal dtcusr = dtusr.getDataCanal();
                    c = dtcusr.getNombre();
                }
            %>
        <h2 class="titulo2"><%=c%></h2>
        <div class="tabs">
            <div class="tab">
                <input type="radio" id="tab-1" name="tab-group-1" checked>
                <label for="tab-1">Videos</label>

                <div class="content">
                    <%
                        DtUsuario dtusrr = s.getDataUsuario(prop);
                        Collection<DtVideo> dtvids = dtusrr.getDtVideos();
                        Iterator<DtVideo> it = dtvids.iterator();
                        String url = "https://www.youtube.com/embed/SlPhMPnQ58k";//M5
                        String name = "null";
                        String Auxurl = null;
                        if (!it.hasNext()) {
                            url = "https://www.youtube.com/embed/CevxZvSJLk8";//KP
                        }%>
                    <div class="container-fluid">
                        <div class="row">
                             <!--<div class="col-md-4">-->
                        <%
                        while (it.hasNext()) {
                            DtVideo dtvid = it.next();
                            if (dtvid != null) {
                                url = dtvid.getURL();
                                Auxurl = url.substring(17, 28);
                                name = dtvid.getNomVideo();
                            }%>                               
                                 <a class="no" href="Video.jsp?value=<%=name%>&usr=<%=prop%>">
                                    <p class="no"><%=name%></p>
                                    <iframe class="no" width="200" height="105" src="https://www.youtube.com/embed/<%=Auxurl%>"></iframe>
                                </a>
                            
                        <%}%>
                            
                    </div>
                        </div>
                </div> 
            </div>

            <div class="tab">
                <input type="radio" id="tab-2" name="tab-group-1">
                <label for="tab-2">Listas</label>
                <div class="content">
                    <ul>
                        <%
                            Collection<DtLR> dtlr = s.ListaListaReproducion(prop);
                            Iterator<DtLR> it2 = dtlr.iterator();
                            String lista = "null";
                            if (!it2.hasNext()) {
                                lista = "no tiene";
                            }
                            while (it2.hasNext()) {
                                DtLR dtl = it2.next();
                                if (dtl != null) {
                                    lista = dtl.getNombre();
                                }
                        %>   
                        <li><%=lista%></li>
                            <%}%>
                    </ul>
                </div> 
            </div>
            <div class="tab">
                <input type="radio" id="tab-3" name="tab-group-1">
                <label for="tab-3">Seguidos</label>

                <div class="content">
                    <ul>
                        <%
                            Collection<DtUsuario> seguidos = s.ListaSeguidos(prop);
                            Iterator<DtUsuario> it3 = seguidos.iterator();
                            String seguido = "null";
                            if (!it3.hasNext()) {
                                seguido = "no tiene";
                            }
                            while (it3.hasNext()) {
                                DtUsuario dtusr = it3.next();
                                if (dtusr != null) {
                                    seguido = dtusr.getNick();
                                }
                        %>   
                        <li><%=seguido%></li>
                            <%}%>
                    </ul>
                </div> 
            </div>

            <div class="tab">
                <input type="radio" id="tab-4" name="tab-group-1">
                <label for="tab-4">Seguidores</label>

                <div class="content">
                    <ul>
                        <%
                            Collection<DtUsuario> seguidores = s.ListaSeguidores(prop);
                            Iterator<DtUsuario> it4 = seguidores.iterator();
                            String seguidor = "null";
                            if (!it4.hasNext()) {
                                seguidor = "no tiene";
                            }
                            while (it4.hasNext()) {
                                DtUsuario dtusr = it4.next();
                                if (dtusr != null) {
                                    seguidor = dtusr.getNick();
                                }

                        %>   
                        <li><%=seguidor%></li>
                            <%}%>
                    </ul>
                </div> 
            </div>

        </div>
    </body>
</html>
