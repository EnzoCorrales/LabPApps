<%-- 
    Document   : AltaUsr
    Created on : Oct 13, 2019, 5:29:00 PM
    Author     : gabrixstar
--%>

<%@page import="Entidades.Fecha"%>
<%@page import="Controladores.Sistema"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DT.DtCategoria"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>UyTube</title>
        <link rel="stylesheet" type="text/css" href="AltaUsrS.css">
    </head>
    <body>
        <h1 align="center">Crear Usuario</h1>
        <form action="AltaUsrServlet" method="post"> 
            <div class="wrap">
                <div class="Inserts">
                    <ul>
                        <li class="Campo">Nick : <input type="text" name="NickIns"></li> 
                        <li class="Campo">Mail : <input type="email" name="CorreoIns"></li>
                        <li class="Campo">Nombre : <input type="text" name="NameIns"></li>
                        <li class="Campo">Apellido : <input type="text" name="ApeIns"></li>
                        <li class="Campo">Fecha de Nacimiento: 
                            <input type="number" class="FechaIns" name="Fdia" min="1" max="31">
                            <input type="number" class="FechaIns" name="Fmes" min="1" max="12">
                            <input type="number" class="FechaIns" name="Fanio" min="1919" max="2019">
                        </li>
                        <li class="Campo">Contraseña : <input type="text" name="PassIns"></li>
                        <li class="Campo">Confirmar Contraseña : <input type="text" name="CPassIns"></li>
                        <li class="Campo">Canal : <input type="text" name="NombreCanal"></li>
                        <li class="Campo">Descripcion Canal : <input type="text" name="DescCanal"></li>
                        <li class="Campo">Categoria Canal :
                            <select name="categories">
                                <%
                                    Sistema s = Sistema.getInstance();
                                    s.CargarDatosPrueba();
                                    Collection<DtCategoria> dtCategorias = s.ListaCategorias();
                                    Iterator<DtCategoria> it = dtCategorias.iterator();
                                    String c = "test";
                                    while (it.hasNext()) {
                                        DtCategoria dtc = it.next();
                                        if (dtc != null) {
                                            c = dtc.getCategoria();
                                        }%>
                                <option value="<%=c%>"><%=c%></option>
                                <%}%>
                            </select>
                        </li>
                        <li class="Campo">Privacidad Canal: <input type="radio" name="privado" value="publico" checked> Publico <input type="radio" name="privado" value="privado"> Privado</li>
                        <li class="Campo">Ingresar Imagen <input type="file" name="IngImg"></li>
                        <li class="Campo"><input type="submit" class="BtnConfirmar" name="Confirmar" value="Confirmar"></li>
                        <a href="Login.html" class="BtnCancelar">Cancelar</a>
                    </ul>
                </div>
            </div>
        </form>
    </body>
</html>
