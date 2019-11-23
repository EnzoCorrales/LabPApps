<%-- 
    Document   : Login
    Created on : Oct 13, 2019, 2:21:56 PM
    Author     : kangaru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
        <link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="LogInStyle.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('select');
                var instances = M.FormSelect.init(elems);
            });
        </script>
        <title>Log In</title>
    </head>
    <body>
        <img src="Imagenes/UyTube.png" class="titulos" width="400" height="400">
        <%
            session.invalidate();
            String si = (String) request.getAttribute("conf");
            if (si != null) {
                out.print("<p style='color: red; font-size: larger;'>Cuenta creada con exito!</p>");
            }
        %>
        <form action="LoginServlet" method="post">
            <div class="container">
                <div class="row">
                    <form class="col s12" id="reg-form">
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">person_outline</i>
                                <input class="validate" name="username" id="email" type="text" required>
                                <label for="email" data-error="wrong" data-success="right">Nickname</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">lock_outline</i>
                                <input id="password" name="password" type="password" required>
                                <label for="password">Contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <button class="btn btn-large btn-register waves-effect waves-light pink" type="submit" name="action" class="btn-color">
                                    Login
                                </button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 m6 l6">
                                <p class="margin medium-small" ><a href="AltaUsr.jsp" class="btn-color">Crear cuenta</a></p>
                            </div>
                        </div>
                    </form>
                </div>
                <a href="HomePage.jsp" title="Inicio" class="ngl btn-floating btn-large waves-effect waves-light red"><i class="material-icons">input</i></a>
            </div>
        </form>
    </body>
</html>
