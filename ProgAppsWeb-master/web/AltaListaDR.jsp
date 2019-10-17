<%-- 
    Document   : AltaListaDR
    Created on : Oct 15, 2019, 1:33:44 PM
    Author     : gabrixstar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="AltaListaDRstyle.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="Campo">Crear Lista</h1>
        <form action="AltaListaDRServlet" method="post">
            <div class="Inserts">
                <ul>
                    <li class="Campo">Nombre Lista : <input type="text" name="NombreLDRPpart"></li> 
                    <li class="Campo"><input type="radio" name="privado" value="publico" checked> Publica <input type="radio" name="privado" value="privado"> Privada</li>
                    <li><input type="submit" class="BtnConfirmar" name="Confirmar" value="Confirmar"></li>
                </ul>
            </div>
        </form>
    </body>
</html>
