<%-- 
    Document   : Index2
    Created on : Oct 12, 2019, 9:28:31 PM
    Author     : kangaru
--%>
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
            <a href="MiPerfil.jsp" target="iFrame" class="derecha"><img src="https://pbs.twimg.com/media/Do4L0ULXUAAbQLZ.png" class="imgPerfil">
                <%
                    HttpSession sesion = request.getSession(false);
                    if (sesion != null) {
                        String user = (String) sesion.getAttribute("username");%>
                <h2 class="derecha"><%=user%></h2>
                <%} else {%>
            </a>
            <a href="Login.html">
                <input type="button" value="Iniciar Sesión"/>
            </a>
            <%}%>
            <a href="Index2.jsp" class="izquierda"><img src="logo.png" class="izquierda"></a>
        </div>
        <ul>
            <li><a href="index.jsp?value=todos" target="iFrame" class="a1">Inicio</a></li>  
            <li><a href="MiPerfil.jsp" target="iFrame" class="a1">Mi Perfil</a></li>
            <li><a href="AltaVideo.jsp" target="iFrame">Subir Video</a></li>
            <li><a href="AltaListaDR.jsp" target="iFrame">+ Crear lista</a></li>
            <li><a href="Lista.jsp?value=Megusta" target="iFrame">Me gusta</a></li>
                <%
                    FabricaSistema f = new FabricaSistema();
                    ISistema s = f.getSistema();
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
            <li><a href="musica.jsp?value=Música" target="iFrame">Música</a></li>
            <li><a href="musica.jsp?value=Videojuegos" target="iFrame">Juegos</a></li>
            <li><a href="musica.jsp?value=Deporte" target="iFrame" class="a1">Deportes</a></li>
            <li><a href="Login.html">Salir</a></li>
        </ul>
        <div class="Iframes">
            <iframe id="iFrame" name="iFrame" width="98%" height="700" src="index.jsp" ></iframe>
        </div>
    </body>
</html>
