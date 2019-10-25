<%-- 
    Document   : AltaUsr
    Created on : Oct 13, 2019, 5:29:00 PM
    Author     : gabrixstar
--%>

<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
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
        <meta name = "viewport" content = "width = device-width, initial-scale = 1">
        <link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="AltaUsrS.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('select');
                var instances = M.FormSelect.init(elems);
            });
        </script>
    </head>
    <body>
        <form action="AltaUsrServlet" method="post">
            <div class="container">
                <div class="row">
                    <form class="col s12" id="reg-form">
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="first_name" type="text" name="NameIns" class="validate" required >
                                <label for="first_name">Nombre</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" name="ApeIns" class="validate" required>
                                <label for="last_name">Apellido</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="Fdia" type="number" min="1" max="31" name="Fdia" class="validate" required >
                                <label for="Fdia">Dia</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="Fmes" type="number" min="1" max="12" name="Fmes" class="validate" required>
                                <label for="Fmes">Mes</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="Fanio" type="number" min="1919" max="2019" name="Fanio" class="validate" required>
                                <label for="Fanio">Año</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="nick" type="text" name="NickIns" class="validate" required>
                                <label for="nick">Nickname</label>
                            </div>           
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="email" type="email" name="CorreoIns" class="validate" required>
                                <label for="email">Correo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" type="password" name="PassIns" class="validate" minlength="6" required>
                                <label for="password">Contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="cpassword" type="password" name="CPassIns" class="validate" minlength="6" required>
                                <label for="cpassword">Confirmar contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="nomc" type="text" name="NombreCanal" class="validate">
                                <label for="nomc">Nombre del Canal</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="descC" type="text" name="DescCanal" class="validate" required>
                                <label for="descC">Descripcion del Canal</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <p>
                                    <label>
                                        <input class="with_gap" name="privado" type="radio"/>
                                        <span>Privado</span>
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="with_gap" name="publico" type="radio"/>
                                        <span>Publico</span>
                                    </label>
                                </p>
                            </div>
                            <div class="input-field col s6">
                                <button class="btn btn-large btn-register waves-effect waves-light blue" type="submit" name="action">Confirmar
                                    <i class="material-icons right">done</i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <a href="Login.jsp" title="Login" class="ngl btn-floating btn-large waves-effect waves-light red"><i class="material-icons">input</i></a>
            </div>
        </form>
    </body>
</html>
