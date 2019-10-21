<%-- 
    Document   : MiPerfil
    Created on : Oct 13, 2019, 3:34:16 PM
    Author     : gabrixstar
--%>

<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
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
        <title>MiPerfil</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String nick = (String) sesion.getAttribute("username");
        %>
        <h1 class="titulos"><img src="https://pbs.twimg.com/media/Do4L0ULXUAAbQLZ.png" class="imgPerfil">  <%=nick%>
            <form action="MiPerfil.jsp">
                <%
                    FabricaSistema f = new FabricaSistema();
                    ISistema s = f.getSistema();
                %>
            </form>
        </h1>
            <%
                String c = null;
                if (nick != null) {
                    DtUsuario dtusr = s.getDataUsuario(nick);
                    DtCanal dtcusr = dtusr.getDataCanal();
                    c = dtcusr.getNombre();
                }
            %>
        <h2 class="titulo2"><%=c%></h2>
        <h3 class="titlo2"><a href="ModDataUsr.jsp?value=<%=nick%>">Modificar datos</a></h3>
        <div class="tabs">
            <div class="tab">
                <input type="radio" id="tab-1" name="tab-group-1" checked>
                <label for="tab-1">Videos</label>

                <div class="content">
                    <%
                        DtUsuario dtusrr = s.getDataUsuario(nick);
                        Collection<DtVideo> dtvids = dtusrr.getDtVideos();
                        Iterator<DtVideo> it = dtvids.iterator();
                        String url = "https://www.youtube.com/embed/SlPhMPnQ58k";//M5
                        String name = "null";
                        String Auxurl = null;
                        if (!it.hasNext()) {
                            url = "https://www.youtube.com/embed/CevxZvSJLk8";//KP
                        }%>
                        <div class="container-fluid">
                            <div class="row justify-content-around">
                                <%
                                    while (it.hasNext()) {
                                        DtVideo dtvid = it.next();
                                        if (dtvid != null) {
                                            url = dtvid.getURL();
                                            Auxurl = url.substring(17, 28);
                                            name = dtvid.getNomVideo();
                                }%>   
                                <a class="no" href="Video.jsp?value=<%=name%>&usr=<%=nick%>">
                                    <p class="no"><%=name%></p>
                                    <iframe class="no" width="200" height="105" src="https://www.youtube.com/embed/<%=Auxurl%>"></iframe>
                                </a>
                                <%}%>
                            </div>
                        </div> 
            </div>

            <div class="tab">
                <input type="radio" id="tab-2" name="tab-group-1">
                <label for="tab-2">Listas</label>
                <div class="content">
                    <ul>
                        <%
                            Collection<DtLR> dtlr = s.ListaListaReproducion(nick);
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
                            Collection<DtUsuario> seguidos = s.ListaSeguidos(nick);
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
                                DtCanal dtc = dtusr.getDataCanal();
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
                            Collection<DtUsuario> seguidores = s.ListaSeguidores(nick);
                            Iterator<DtUsuario> it5 = seguidores.iterator();
                            String seguidor = "null";
                            if (!it5.hasNext()) {
                                seguidor = "no tiene";
                            }
                            while (it5.hasNext()) {
                                DtUsuario dtusr = it5.next();
                                seguidor = dtusr.getNick();
                                DtCanal dtc = dtusr.getDataCanal();
                        %>   
                        <li><a href="PerfilUsr.jsp?usr=<%=seguidor%>"><%=seguidor%></a></li>
                            <%}%>
                    </ul> 
                </div> 
            </div>

        </div>
    </body>
</html>
