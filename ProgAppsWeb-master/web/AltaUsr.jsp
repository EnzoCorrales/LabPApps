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
    </head>
    <body>
        <form action="AltaUsrServlet" method="post" enctype="multipart/form-data">
            <div class="container">
                <div class="row">
                    <form class="col s12" id="reg-form">
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="NameIns" type="text" name="NameIns" class="validate" required >
                                <label for="NameIns">Nombre</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="ApeIns" type="text" name="ApeIns" class="validate" required>
                                <label for="ApeIns">Apellido</label>
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
                                <input id="NickIns" type="text" name="NickIns" class="validate" required>
                                <label for="NickIns">Nickname</label>
                            </div>           
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="CorreoIns" type="email" name="CorreoIns" class="validate" required>
                                <label for="CorreoIns">Correo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="PassIns" type="password" name="PassIns" class="validate" minlength="6" required>
                                <label for="PassIns">Contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="CPassIns" type="password" name="CPassIns" class="validate" minlength="6" required>
                                <label for="CPassIns">Confirmar contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="NombreCanal" type="text" name="NombreCanal" class="validate">
                                <label for="NombreCanal">Nombre del Canal</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="DescCanal" type="text" name="DescCanal" class="validate" required>
                                <label for="DescCanal">Descripcion del Canal</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="row">
                                <div class="file-field input-field">
                                    <div class="btn">
                                        <span>Ingresar Imagen</span>
                                        <input id="fileChooser" type="file" name="dataFile" accept="image/*">
                                    </div>
                                    <div class="file-path-wrapper">
                                        <input class="file-path validate" type="text">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <p>
                                    <label>
                                        <input class="with_gap" name="privado" value="privado" type="radio"/>
                                        <span>Privado</span>
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input class="with_gap" name="privado" value="publico" type="radio"/>
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
