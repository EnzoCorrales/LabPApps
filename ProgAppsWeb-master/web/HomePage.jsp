<%-- 
    Document   : HomePage
    Created on : Oct 26, 2019, 12:38:25 AM
    Author     : gabrixstar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>UyTube</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
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
            <h4 class="derecha">
                <a href="Login.jsp">
                    <input class="inicio" type="button" value="Iniciar Sesión"/>
                </a>
            </h4>
            <a href="HomePage.jsp" class="izquierda"><img src="Screenshot_2019-10-20 Make A High-Quality Logo In Just 5 Minutes For Under $30 .png" class="izquierda"></a>
        </div>
        <ul>
            <li><a href="Login.jsp" class="a1">Mi Perfil</a></li>
            <li><a href="Login.jsp">Subir Video</a></li>
            <li><a href="HomePage.jsp" class="a1">Ver Videos</a></li>
            <%
                try {
                    WSClient.SistemaService service = new WSClient.SistemaService();
                    WSClient.Sistema port = service.getSistemaPort();
                    // TODO process result here
                    java.util.List<WSClient.DtCategoria> result = port.listaCategorias();
                    for (WSClient.DtCategoria cat : result) {%>
            <li><a href="musica.jsp?value=<%=cat.getCategoria()%>" target="iFrame"><%=cat.getCategoria()%></a></li>
                <% }
            } catch (Exception ex) {
            // TODO handle custom exceptions here
            }
                %>
            <li><a href="Login.jsp">Salir</a></li>
        </ul>
        <div class="Iframes">
            <iframe id="iFrame" name="iFrame" width="98%" height="700" src="index.jsp" ></iframe>
        </div>
    </body>
</html>
