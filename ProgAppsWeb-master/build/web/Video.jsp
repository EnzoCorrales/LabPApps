<%-- 
    Document   : Video
    Created on : 16/10/2019, 03:02:38 PM
    Author     : tecnologo
--%>

<%@page import="java.lang.String"%>
<%@page import="WSClient.*"%>
<%@page import="java.util.*"%>
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
        <%
            WSClient.SistemaService service = new WSClient.SistemaService();
            WSClient.Sistema port = service.getSistemaPort();
            String nombre = request.getParameter("value");
            String nick = request.getParameter("usr");
            String usuario = (String) session.getAttribute("username");

            java.lang.String arg0 = nombre;
            java.lang.String arg1 = nick;
            // TODO process result here
            WSClient.DtVideo result = port.getDataVideo(nombre, nick);

        %>
        <%-- end web service invocation --%><hr/>

        <%            if (request.getParameter("Like") != null) {
                java.lang.String arg2 = usuario;
                boolean arg3 = true;
                port.valorarVideo(arg0, arg1, arg2, arg3);
            }

            if (request.getParameter("Dislike") != null) {
                java.lang.String arg2 = usuario;
                boolean arg3 = false;
                port.valorarVideo(arg0, arg1, arg2, arg3);
            }

            DtVideo vid = null;
            if (request.getParameter("nickC") != null) {
                // TODO initialize WS operation arguments here
                java.util.List<WSClient.DtVideo> result1 = port.listaVideos(nick);
                java.lang.String arg2 = request.getParameter("nickC");
                java.lang.String arg3 = request.getParameter("comC");
                java.lang.String arg4 = usuario;
                java.lang.String arg5 = request.getParameter("com");
                port.agregarRespuesta(arg0, arg1, arg2, arg3, arg4, arg5);
                vid = port.getDataVideo(arg0, arg1);
            }
            if (usuario != null) {
                if (usuario.equalsIgnoreCase(vid.getPropietario())) {%>
        <p class="titulo"><a href="ModDataVid.jsp?NombreVideo=<%=nombre%>">Modificar datos</a></p>  
        <%}
            }%>
        <%
            //DtCategoria cat = port.getDataVideo(nick, nombre).getCategoria();
            String dur = port.getDataVideo(nombre, nick).getDuracion();
            String url = port.getDataVideo(nombre, nick).getUrl();
            String desc = port.getDataVideo(nombre, nick).getDescripcion();
            String Auxurl = null;
            String prop = port.getDataVideo(nombre, nick).getPropietario();
            Auxurl = url.substring(17, 28);
            session.setAttribute("vid", vid);
            session.setAttribute("value", prop);
        %>
        <iframe id="iFrame" class="frame" name="iFrame" width="900" height="500" src="https://www.youtube.com/embed/<%=Auxurl%>" frameborder="0" scrolling="no"></iframe> 
        <h4 class="titulo"><%=nombre%></h4> 
        <%if (usuario != null) {%>
        <form name="form" method="post">
            <input type="hidden" name="Like">
            <%
                if (port.uTieneValoracionI(nick, nombre, usuario, true) == true) {%>
            <button class="waves-effect waves-teal btn-flat blue" type="submit" onclick="buttonL()">
                <i class="material-icons">thumb_up</i>
            </button><%
            } else {%>
            <button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonL()">
                <i class="material-icons">thumb_up</i>
            </button><%
                }%>
        </form>
        <%} else {%>
        <a href="Login.jsp" target="_parent">
            <button class="waves-effect waves-teal btn-flat white" type="submit">
                <i class="material-icons">thumb_up</i>
            </button>
        </a>
        <%}%>

        <%if (usuario != null) {%>
        <form name="form1" method="post">
            <input type="hidden" name="Dislike">
            <%if (port.uTieneValoracionI(nick, nombre, usuario, false) == true) {%>
            <button class="waves-effect waves-teal btn-flat red" type="submit" onclick="buttonDL()">
                <i class="material-icons">thumb_down</i>
            </button><%
            } else {%>
            <button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonDL()">
                <i class="material-icons">thumb_down</i>
            </button><%
                }%>
        </form>
        <%} else {%>
        <a href="Login.jsp" target="_parent">
            <button class="waves-effect waves-teal btn-flat white" type="submit">
                <i class="material-icons">thumb_down</i>
            </button>
        </a>
        <%}%>
        <p>Propietario:
            <%if (!prop.equalsIgnoreCase(usuario)) {%>
            <a class="prop" href="PerfilUsr.jsp?usr=<%=prop%>"><%=prop%></a>
            <%} else if (prop.equalsIgnoreCase(usuario)) {%>
            <a class="prop" href="MiPerfil.jsp"><%=prop%></a>
            <%} else if (usuario.equalsIgnoreCase(null)) {%>
            <a class="prop" href="PerfilUsr.jsp?usr=<%=prop%>"><%=prop%></a>
            <%}%>
        </p>
        <p>Descripcion:
            <%=desc%></p>

        <script language="JavaScript">
            function buttonL()
            {
                document.form.Like.value = "yes";
                form.submit();
            }
        </script>
        <script language="JavaScript">
            function buttonDL()
            {
                document.form1.Dislike.value = "yes";
                form1.submit();
            }
        </script>
    </body>
</html>