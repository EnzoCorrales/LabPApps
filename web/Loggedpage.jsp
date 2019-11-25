<%-- 
    Document   : Homepage2
    Created on : Nov 14, 2019, 7:52:18 PM
    Author     : gabrixstar
--%>

<%@page import="DT.DtLR"%>
<%@page import="DT.DtUsuario"%>
<%@page import="DT.DtCategoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="HomepageStyle.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>JSP Page</title>
    </head>
    <body>
        <div class="s-layout">
            <!-- Sidebar -->
            <div class="s-layout__sidebar">
                <a class="s-sidebar__trigger" href="#0">
                    <i class="material-icons">view_headline</i>
                </a>

                <nav class="s-sidebar__nav">
                    <ul>

                        <li>
                            <a class="s-sidebar__nav-link"  href="Loggedpage.jsp">
                                <i class="material-icons" >home</i><em>Home</em>
                            </a>
                        </li>
                        <li>
                            <a class="s-sidebar__nav-link" id="web" href="MiPerfil.jsp" target="iFrame">
                                <i class="material-icons">person</i><em>Mi Perfil</em>
                            </a>
                        </li>
                        <li>
                            <a class="s-sidebar__nav-link" id="web" href="AltaVideo.jsp" target="iFrame">
                                <i class="material-icons">video_call</i><em>Subir Video</em>
                            </a>
                        </li>
                        <li>
                            <a class="s-sidebar__nav-link" id="web" href="AltaListaDR.jsp" target="iFrame">
                                <i class="material-icons">featured_play_list</i><em>Crear Lista</em>
                            </a>
                        </li>

                        <%
                            FabricaSistema f = new FabricaSistema();
                            ISistema s = f.getSistema();
                            HttpSession sesion = request.getSession(false);
                            String user = (String) sesion.getAttribute("username");
                            Collection<DtLR> listas = s.ListaListaReproducion(user);
                            Iterator<DtLR> it = listas.iterator();
                            while (it.hasNext()) {
                                DtLR dtlr = it.next();
                                String nombreLR = dtlr.getNombre();
                                String prop = dtlr.getPropietario();
                        %>
                        <li>
                            <a class="s-sidebar__nav-link" href="Lista.jsp?value=<%=nombreLR%>&usr=<%=prop%>" target="iFrame">
                                <i class="material-icons">library_music</i><em><%=nombreLR%></em>
                            </a>
                        </li>
                        <% }%>


                        <%

                            Collection<DtCategoria> listadtc = s.ListaCategorias();
                            Iterator<DtCategoria> it2 = listadtc.iterator();
                            while (it2.hasNext()) {
                                DtCategoria dtc = it2.next();
                                String cat = dtc.getCategoria();
                        %>
                        <li>
                            <a class="s-sidebar__nav-link" href="musica.jsp?value=<%=cat%>" target="iFrame">
                                <i class="material-icons">library_music</i><em><%=cat%></em>
                            </a>
                        </li>
                        <% }%>
                        <li>
                            <a class="s-sidebar__nav-link" href="Login.jsp">
                                <i class="material-icons">arrow_back</i><em>Salir</em>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <!-- Content -->
            <main class="s-layout__content">
                <h1 class="izquierda">
                    <a href="Loggedpage.jsp"><img src="Imagenes/UyTube.png" class="izquierda"></a>
                </h1>
                <h4 class="derecha">
                    <%
                        String img = null;
                        if (sesion != null) {
                            DtUsuario usrdt = s.getDataUsuario(user);
                            img = usrdt.getImagen();
                            if (img == null) {
                                img = "blank-profile-picture-973460_960_720.png";
                            }
                    %>
                    <a href="MiPerfil.jsp" target="iFrame" class="derecha"><img src="Imagenes/<%=img%>" class="imgPerfil"></a>
                        <%} else {%>
                    <a href="Login.jsp">
                        <input type="button" value="Iniciar Sesión"/>
                    </a>
                    <%}%>
                </h4>
                <form action="Busqueda" method="post" target="iFrame">
                    <div class="wrap">
                        <div class="search">
                            <input type="text" class="searchTerm" placeholder="Buscar" name="Buscar">
                            <button type="submit" class="searchButton" >
                                <i class="material-icons prefix">search</i>
                            </button>
                            <div class="Filtro">
                                <select name="Ordenamiento" class="Filtros">
                                    <option value="Opcion">Seleccione una opción</option>
                                    <option value="Alfabeticamente">Alfábeticamente(A-Z a-z)</option>
                                    <option value="Anio">Año(descendente)</option>
                                </select>
                                <br/>
                                <select name="Filtro" class="Filtros">
                                    <option value="Opcion">Seleccione una opcion</option>
                                    <option value="Videos">Videos</option>
                                    <option value="Listas">Listas de Reproducción</option>
                                    <option value="Canales">Canales</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="wrap2">
                    <div class="search">
                        <a href="BusquedaMovil.jsp" class="searchButton">
                            <i class="material-icons prefix">search</i>
                        </a>
                    </div>
                </div>
                <iframe frameBorder="0" id="iFrame" name="iFrame" class="Iframes" src="index.jsp" ></iframe>
            </main>
        </div>
    </body>
</html>