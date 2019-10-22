<%-- 
    Document   : Login
    Created on : Oct 13, 2019, 2:21:56 PM
    Author     : kangaru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="LogInStyle.css"> 

        <title>Log In</title>
    </head>
    <body>
        <!--<center>--> 
        <div class="cuerpo">
            <h2>Iniciar Sesión</h2> 
            <br/>

            <%
                String si = (String) request.getAttribute("conf");
                if (si != null) {
                    out.print("<p style='color: red; font-size: larger;'>Cuenta creada con exito!</p>");
                }
            %>
            <form action="LoginServlet" method="post"> 
                <br/>Username:<input type="text" name="username"> 
                <br/>
                <br/>Password:<input type="password" name="password"> 
                <br/>
                <br/><input type="submit" value="Aceptar"> 
            </form>
            <br/>
            <a href="AltaUsr.jsp">No tienes cuenta? Crear una aquí</a>
            <!--</center>-->
            <form action="index.html">
                <input class="inicio" type="submit" value="Volver al inicio!" />
            </form>
        </div>
    </body>
</html>
