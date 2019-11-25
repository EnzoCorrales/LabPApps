<%-- 
    Document   : Responder
    Created on : Oct 26, 2019, 10:45:15 AM
    Author     : kangaru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name = "viewport" content = "width = device-width, initial-scale = 1">
        <link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="VideoStyle.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h3>Comentario</h3>
            <%
                String nombre = request.getParameter("value");
                String nick = request.getParameter("usr");
                String nickC = request.getParameter("nickC");
                String comC = request.getParameter("comC");
                out.print(nombre);
                out.print(nick);
                out.print(nickC);
                out.print(comC);
            %>
            <form action="Responder" method="post">
                <input type="text" name="comentario" class="validate" required>
                <input type="hidden" name="nomVideo" value="<%=nombre%>">
                <input type="hidden" name="usr" value="<%=nick%>">
                <input type="hidden" name="nickC" value="<%=nickC%>">
                <input type="hidden" name="comC" value="<%=comC%>">
                <button class="waves-effect waves-teal btn-flat blue" type="submit">Responder
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
    </body>
</html>
