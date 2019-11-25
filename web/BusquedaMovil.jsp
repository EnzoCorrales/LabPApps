<%-- 
    Document   : Homepage2
    Created on : Nov 14, 2019, 7:52:18 PM
    Author     : gabrixstar
--%>

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
        <link rel="stylesheet" type="text/css" href="BusquedaMovil.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>JSP Page</title>
    </head>
    <body>
        <div class="s-layout">
            <!-- Sidebar -->
            <div class="s-layout__sidebar">
                <a class="s-sidebar__trigger" href="#0">
                </a>
            </div>
            <!-- Content -->
            <main class="s-layout__content">
                <h4 class="izquierda">
                    <%
                        HttpSession sesion = request.getSession(false);
                         if(sesion.getAttribute("username")!=null){               
                    %>
                    <a href="Loggedpage.jsp"><img src="Imagenes/UyTube.png" class="izquierda"></a>
                    <%}else{%>
                    <a href="Homepage2.jsp"><img src="Imagenes/UyTube.png" class="izquierda"></a>
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
            </main>
        </div>
    </body>
</html>

