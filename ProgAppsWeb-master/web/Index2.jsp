<%-- 
    Document   : Index2
    Created on : Oct 12, 2019, 9:28:31 PM
    Author     : kangaru
--%>
<%@page import="WSClient.DtLR"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>UyTube</title>
    </head>
    <body>
        <header>
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
            </div>
        </form>
        <div class="titulos">
            <h4 class="linea">-</h4>
            <%
                String usuario = (String) session.getAttribute("username");
                String nick = request.getParameter("usr");
                WSClient.SistemaService service = new WSClient.SistemaService();
                WSClient.Sistema port = service.getSistemaPort();
                WSClient.DtUsuario v = port.getDataUsuario(usuario);
            %>
            <h2 class="derecha"><a href="MiPerfil.jsp" target="iFrame" class="derecha"><img src="Imagenes/<%=v.getImagen()%>" class="imgPerfil"><%=usuario%></a></h2>
                <a href="Index2.jsp" class="izquierda"><img src="Screenshot_2019-10-20 Make A High-Quality Logo In Just 5 Minutes For Under $30 .png" class="izquierda"></a>
        </div>
        <ul>
            <li><a href="index.jsp?value=todos" target="iFrame" class="a1">Inicio</a></li>  
            <li><a href="MiPerfil.jsp" target="iFrame" class="a1">Mi Perfil</a></li>
            <li><a href="AltaVideo.jsp" target="iFrame">Subir Video</a></li>
            <li><a href="AltaListaDR.jsp" target="iFrame">+ Crear lista</a></li>
                <%
                    //String nombreLR = port.getDataLR(nick,usuario).getNombre();
                   // String prop = port.getDataLR(nick,usuario).getPropietario();
                   
                   List<DtLR> Listas = port.listaListaReproducion(usuario);
                   for(DtLR dtlr : Listas){
                %>
            <li><a href="Lista.jsp?value=<%=dtlr.getNombre()%>&usr=<%=dtlr.getPropietario()%>" target="iFrame"><%=dtlr.getNombre()%></a></li>
                <%
                    }
                    java.util.List<WSClient.DtCategoria> result2 = port.listaCategorias();
                    for (WSClient.DtCategoria cat : result2) {
                %>
            <li><a href="musica.jsp?value=<%=cat.getCategoria()%>" target="iFrame"><%=cat.getCategoria()%></a></li>
                <%}%>
            <li><a href="Login.jsp">Salir</a></li>
        </ul>
        <div class="Iframes">
            <iframe id="iFrame" name="iFrame" width="98%" height="700" src="index.jsp" ></iframe>
        </div>
        <iframe frameBorder="0" id="iFrame" name="iFrame" class="Iframes" src="index.jsp" ></iframe>
    </body>
</html>
