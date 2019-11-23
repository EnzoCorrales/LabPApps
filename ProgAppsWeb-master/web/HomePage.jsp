<%-- 
    Document   : HomePage
    Created on : Oct 26, 2019, 12:38:25 AM
    Author     : gabrixstar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="DT.DtCategoria"%>
<%@page import="java.util.Collection"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>UyTube</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    </head>
    <body>
        <div class="header">
            <input type="checkbox" id="btn-menu">
            <label for="btn-menu"><img src="https://res.cloudinary.com/teepublic/image/private/s--a5R8DPne--/t_Resized%20Artwork/c_fit,g_north_west,h_1054,w_1054/co_ffffff,e_outline:53/co_ffffff,e_outline:inner_fill:53/co_bbbbbb,e_outline:3:1000/c_mpad,g_center,h_1260,w_1260/b_rgb:eeeeee/c_limit,f_jpg,h_630,q_90,w_630/v1545426786/production/designs/3587564_2.jpg" alt="">
            </label>
        </div>
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
        <div class="titulos">
            <h4 class="linea"></h4>
            <h4 class="derecha">
                <a href="Login.jsp">
                    <input class="inicio" type="button" value="Iniciar Sesión"/>
                </a>
            </h4>
        </div>
        <iframe frameBorder="0" id="iFrame" name="iFrame" class="Iframes" src="index.jsp" ></iframe>
    </body>
</html>
