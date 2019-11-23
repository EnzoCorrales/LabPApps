<%-- 
    Document   : PerfilUsr
    Created on : Oct 14, 2019, 2:47:39 PM
    Author     : tecnologo
--%>


<%@page import="WSClient.DtLR"%>
<%@page import="WSClient.DtVideo"%>
<%@page import="WSClient.DtCanal"%>
<%@page import="WSClient.DtUsuario"%>
<%@page import="java.sql.*"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
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
            WSClient.SistemaService service = new WSClient.SistemaService();
            WSClient.Sistema port = service.getSistemaPort();
            
            String prop = request.getParameter("usr");
            String nick = (String) session.getAttribute("username");
            String c = null;
            String ape = null;
            String desc = null;
            String img = null;
            int d = 0, m = 0, a = 0;
            if (prop != null) {
                DtUsuario dtusr = port.getDataUsuario(prop);
                DtCanal dtcusr = dtusr.getCanal();
                c = dtcusr.getNombre();
                ape = dtusr.getApellido();
                desc = dtcusr.getDescripcion();
                img = dtusr.getImagen();
                if (img == null) {
                    img = "blank-profile-picture-973460_960_720.png";
                }
            }
        %>
        <h1 class="titulos"><img src="Imagenes/<%=img%>" class="imgPerfil">  <%=prop%></h1>
            <%
                if (nick != null) {%>
        <form action="SuscribirseServlet" method="post">
            <input type="hidden" id="usr" name="usr" value="<%=prop%>">
            <% if (!port.loSigue(nick, prop)) {%>
            <input name="Suscribirse" type="submit" class="titulos" value="Suscribirse">
            <%}%>
        </form>

        <form action="DejarDeSeguirServlet" method="post">
            <input type="hidden" id="usr" name="usr" value="<%=prop%>">
            <% if (port.loSigue(nick, prop)) {%>
            <input name="Desuscribirse" type="submit" class="titulos" value="Desuscribirse">
            <%}%>
        </form>
        <%
        } else {%> 
        <a href="Login.jsp" target="_parent"><input name="Suscribirse" type="submit" class="titulos" value="Suscribirse"></a>
            <%}%>
        <h2 class="titulo2"><%=c%></h2>
        <div class="tabs">
            <div class="tab">
                <input type="radio" id="tab-1" name="tab-group-1" checked>
                <label for="tab-1">Videos</label>

                <div class="content">
                    <%
                        DtUsuario dtusrr = port.getDataUsuario(prop);
                        Collection<DtVideo> dtvids = dtusrr.getVideos();
                        Iterator<DtVideo> it = dtvids.iterator();
                        String url = "https://www.youtube.com/embed/SlPhMPnQ58k";//M5
                        String name = "null";
                        String Auxurl = null;
                        if (!it.hasNext()) {
                            url = "https://www.youtube.com/embed/CevxZvSJLk8";//KP
                        }%>
                    <div class="container-fluid">
                        <div class="row">
                            <%
                                while (it.hasNext()) {
                                    DtVideo dtvid = it.next();
                                    if (dtvid != null) {
                                        url = dtvid.getUrl();
                                        Auxurl = url.substring(17, 28);
                                        name = dtvid.getNomVideo();
                                        prop = dtvid.getPropietario();
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
                            Collection<DtLR> dtlr = port.listaListaReproducion(prop);
                            Iterator<DtLR> it2 = dtlr.iterator();
                            String lista = "null";
                            if (!it2.hasNext()) {
                                lista = "no tiene";
                            }
                            while (it2.hasNext()) {
                                DtLR dtl = it2.next();
                                if (dtl != null) {
                                    lista = dtl.getNombre();
                                    prop = dtl.getPropietario();
                                }
                        %>   
                        <li><a class="no" href="Lista.jsp?value=<%=lista%>&usr=<%=prop%>"><%=lista%></a></li>
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
                            Collection<DtUsuario> seguidos = port.listaSeguidos(prop);
                            Iterator<DtUsuario> it4 = seguidos.iterator();
                            String seguido = "null";
                            if (!it4.hasNext()) {
                                seguido = "no tiene";
                            }
                            while (it4.hasNext()) {
                                DtUsuario dtusr = it4.next();
                                if (dtusr != null) {
                                    seguido = dtusr.getNick();
                                }
                                DtCanal dtc = dtusr.getCanal();
                                String nomC2 = dtc.getNombre();
                        %>   
                        <li><a href="PerfilUsr.jsp?usr=<%=seguido%>"><%=seguido%></a></li>
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
                            Collection<DtUsuario> seguidores = port.listaSeguidores(prop);
                            Iterator<DtUsuario> it5 = seguidores.iterator();
                            String seguidor = "null";
                            if (!it5.hasNext()) {
                                seguidor = "no tiene";
                            }
                            while (it5.hasNext()) {
                                DtUsuario dtusr = it5.next();
                                //if (dtusr != null) {
                                seguidor = dtusr.getNick();
                                //}
                                DtCanal dtc = dtusr.getCanal();
                                String nomC2 = dtc.getNombre();

                        %>   
                        <li><a href="PerfilUsr.jsp?usr=<%=seguidor%>"><%=seguidor%></a></li>
                            <%}%>
                    </ul> 
                </div> 
            </div>

            <div class="tab">
                <input type="radio" id="tab-5" name="tab-group-1">
                <label for="tab-5">Info</label>

                <div class="content">
                    <ul>    
                        <%
                            if (prop != null) {
                                DtUsuario dtusr = port.getDataUsuario(prop);
                                DtCanal dtcusr = dtusr.getCanal();
                                c = dtcusr.getNombre();
                                ape = dtusr.getApellido();
                                desc = dtcusr.getDescripcion();
                                d = dtusr.getFechaPub().getDia();
                                m = dtusr.getFechaPub().getMes();
                                a = dtusr.getFechaPub().getAnio();
                            }
                        %>   
                        <li><p>Apellido: <%=ape%></p></li>
                        <li><p>Descripcion: <%=desc%></p></li>
                        <li><p>Fecha de nacimiento: <%=d%>/<%=m%>/<%=a%></p></li>
                    </ul> 
                </div> 
            </div>
        </div>
    </body>
</html>
