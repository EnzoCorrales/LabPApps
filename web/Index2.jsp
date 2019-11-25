<%-- 
    Document   : Index2
    Created on : Oct 12, 2019, 9:28:31 PM
    Author     : kangaru
--%>
<%@page import="DT.DtCategoria"%>
<%@page import="DT.DtUsuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="DT.DtLR"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collection"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="Controladores.Sistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>UyTube</title>
    </head>
    <body>
        <form action="Busqueda" method="post" target="iFrame">
            <div class="wrap">
                <div class="search">
                    <input type="text" class="searchTerm" placeholder="Buscar" name="Buscar">
                    <button type="submit" class="searchButton" >
                        Buscar
                    </button>
                    <div class="Filtros">
                        <select name="Ordenamiento">
                            <option value="Opcion">Seleccione una opción</option>
                            <option value="Alfabeticamente">Alfábeticamente(A-Z a-z)</option>
                            <option value="Anio">Año(descendente)</option>
                        </select>
                        <br/>
                        <select name="Filtro">
                            <option value="Opcion">Seleccione una opcion</option>
                            <option value="Videos">Videos</option>
                            <option value="Listas">Listas de Reproducción</option>
                            <option value="Canales">Canales</option>
                        </select>
                    </div>
                </div>
            </div>
        </form>
        <div class="titulos">
            <h4 class="linea">-</h4>
            <%
                FabricaSistema f = new FabricaSistema();
                ISistema s = f.getSistema();
                HttpSession sesion = request.getSession(false);
                String img = null;
                if (sesion != null) {
                    String user = (String) sesion.getAttribute("username");
                    DtUsuario usrdt = s.getDataUsuario(user);
                    img = usrdt.getImagen();
                    if (img == null) {
                        img = "blank-profile-picture-973460_960_720.png";
                    }
            %>
            <h2 class="derecha"><a href="MiPerfil.jsp" target="iFrame" class="derecha"><img src="Imagenes/<%=img%>" class="imgPerfil"><%=user%></h2>
                    <%} else {%>
                </a>
                <a href="Login.jsp">
                    <input type="button" value="Iniciar Sesión"/>
                </a>
                <%}%>
                <a href="Index2.jsp" class="izquierda"><img src="Imagenes/logo.png" class="izquierda"></a>
        </div>
        <ul>
            <li><a href="index.jsp?value=todos" target="iFrame" class="a1">Inicio</a></li>  
            <li><a href="MiPerfil.jsp" target="iFrame" class="a1">Mi Perfil</a></li>
            <li><a href="AltaVideo.jsp" target="iFrame">Subir Video</a></li>
            <li><a href="AltaListaDR.jsp" target="iFrame">+ Crear lista</a></li>
                <%
                    String user = (String) sesion.getAttribute("username");
                    Collection<DtLR> listas = s.ListaListaReproducion(user);
                    Iterator<DtLR> it = listas.iterator();
                    while (it.hasNext()) {
                        DtLR dtlr = it.next();
                        String nombreLR = dtlr.getNombre();
                        String prop = dtlr.getPropietario();
                %>
            <li><a href="Lista.jsp?value=<%=nombreLR%>&usr=<%=prop%>" target="iFrame"><%=nombreLR%></a></li>
                <% }%>
            <%
                    Collection<DtCategoria> listadtc = s.ListaCategorias();
                    Iterator<DtCategoria> it2 = listadtc.iterator();
                    while (it2.hasNext()) {
                        DtCategoria dtc = it2.next();
                        String cat = dtc.getCategoria();
                %>
            <li><a href="musica.jsp?value=<%=cat%>" target="iFrame"><%=cat%></a></li>
            <% }%>
            <li><a href="Login.jsp">Salir</a></li>
        </ul>
        <div class="Iframes">
            <iframe id="iFrame" name="iFrame" width="98%" height="700" src="index.jsp" frameborder="0"></iframe>
        </div>
    </body>
</html>
