<%-- 
    Document   : AltaListaDR
    Created on : Oct 15, 2019, 1:33:44 PM
    Author     : gabrixstar
--%>

<%@page import="WSClient.DtCategoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="AltaListaDR.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="Campo">Crear Lista</h1>
                <form action="AltaListaDRServlet" method="post">
                    <div class="Inserts">
                        <ul>

                            <li class="Campo">Nombre Lista : <input type="text" name="NombreLDRPpart"></li>
                                <%
                                    WSClient.SistemaService service = new WSClient.SistemaService();
                                    WSClient.Sistema port = service.getSistemaPort();

                                    Collection<DtCategoria> cat = port.listaCategorias();
                                    Iterator<DtCategoria> it = cat.iterator();
                                    String nom = null;
                                    while (it.hasNext()) {
                                        DtCategoria cate2 = it.next();
                                        nom = cate2.getCategoria();%>
                            <li class="Campo"><input type = "checkbox" name = "Categoria" value= "<%=nom%>" ><%=nom%></li>
                                <%}%>
                            <li class="Campo"><input type = "radio" name = "privado" value = "publico" checked > Publica <input type = "radio" name = "privado" value = "privado"> Privada </li> 
                            <li> <input type = "submit" class="BtnConfirmar" name = "Confirmar" value = "Confirmar" > </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
