<%-- 
    Document   : ModDataLR
    Created on : Oct 25, 2019, 11:36:43 PM
    Author     : gabrixstar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name = "viewport" content = "width = device-width, initial-scale = 1">
        <link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="AltaUsrS.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String lista = request.getParameter("value");
        %>
        <form action="ModLDRP" method="post">
            <div class="container">
                <div class="row">
                    <form class="col s12" id="reg-form">
                        <div class="row">
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
                                <input type="hidden" name="lista" id="lista" value="<%=lista%>">
                                <div class="input-field col s6">
                                    <button class="btn btn-large btn-register waves-effect waves-light blue" type="submit" name="action">Confirmar
                                        <i class="material-icons right">done</i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <a href="Login.jsp" title="Login" class="ngl btn-floating btn-large waves-effect waves-light red"><i class="material-icons">input</i></a>
            </div>
        </form>
    </body>
</html>
