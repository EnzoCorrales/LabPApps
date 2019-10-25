<%-- 
    Document   : Video
    Created on : 16/10/2019, 03:02:38 PM
    Author     : tecnologo
--%>

<%@page import="DT.DtComentario"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="DT.DtUsuario"%>
<%@page import="DT.DtValoracion"%>
<%@page import="Entidades.Fecha"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="Controladores.Sistema"%>
<%@page import="DT.DtVideo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name = "viewport" content = "width = device-width, initial-scale = 1">
        <link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="VideoStyle.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("value");
            String nick = request.getParameter("usr");
            String usuario = (String) session.getAttribute("username");
            FabricaSistema fa = new FabricaSistema();
            ISistema s = fa.getSistema();
            DtVideo vid = s.getDataVideo(nombre, nick);
        %>

        <h1 class="titulo"><%=nombre%></h1> <br>
        <%if (usuario != null) {
                if (usuario.equalsIgnoreCase(vid.getPropietario())) {%>
        <p class="titulo"><a href="ModDataVid.jsp?NombreVideo=<%=nombre%>">Modificar datos</a></p>  
        <%}
            }%>
        <%
            String cat = vid.getCategoria();
            String dur = vid.getDuracion();
            String url = vid.getURL();
            String desc = vid.getDescripcion();
            String Auxurl = null;
            String prop = vid.getPropietario();
            Auxurl = url.substring(17, 28);
            session.setAttribute("vid", vid);
            session.setAttribute("value", prop);
        %>
        <iframe id="iFrame" class="frame" name="iFrame" width="600" height="400" src="https://www.youtube.com/embed/<%=Auxurl%>" ></iframe> 
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
            <%
                if (request.getParameter("Like") != null)
                    s.ValorarVideo(nick, nombre, usuario, true);
              
                if (request.getParameter("Dislike") != null) 
                    s.ValorarVideo(nick, nombre, usuario, false);
                %>
        <%if(usuario != null){%>
        <form name="form" method="post">
            <input type="hidden" name="Like">
            <%if (s.UTieneValoracionI(nick, nombre, usuario, true) == true) {%>
            <button class="waves-effect waves-teal btn-flat blue" type="submit" onclick="buttonL()">
                <i class="material-icons">thumb_up</i>
            </button><%
                } else {%>
            <button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonL()">
                <i class="material-icons">thumb_up</i>
            </button><%
                    }%>
        </form>
        <%}
        else{%>
            <a href="Login.jsp" target="_parent">
            <button class="waves-effect waves-teal btn-flat white" type="submit">
                <i class="material-icons">thumb_up</i>
            </button>
              </a>
        <%}%>
        
        <%if(usuario != null){%>
        <form name="form1" method="post">
            <input type="hidden" name="Dislike">
            <%if (s.UTieneValoracionI(nick, nombre, usuario, false) == true) {%>
            <button class="waves-effect waves-teal btn-flat blue" type="submit" onclick="buttonDL()">
                <i class="material-icons">thumb_down</i>
            </button><%
                } else {%>
            <button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonDL()">
                <i class="material-icons">thumb_down</i>
            </button><%
                    }%>
        </form>
        <%}
        else{%>
            <a href="Login.jsp" target="_parent">
            <button class="waves-effect waves-teal btn-flat white" type="submit">
                <i class="material-icons">thumb_down</i>
            </button>
              </a>
        <%}%>
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
        <p> Duracion: <%=dur%> </p></br></br>
        <p> Categoria: <%=cat%> </p></br></br>
        <p> Comentarios:</p>
        <%
            Collection<DtComentario> Comentarios = vid.getComentarios();
            Iterator<DtComentario> it = Comentarios.iterator();
            while (it.hasNext()) {
                DtComentario comentario = it.next();
                request.setAttribute("comentario", comentario);
        %>
        <ul>
            <c:forEach var="comentario" items="${comentario.getRespuestas()}">
                <c:out value="${comentario.getTexto()}"/>
                <c:set var="comentario" value="${respuestas}" scope="request"/>
                <jsp:include page="node.jsp"/>
            </c:forEach>
        </ul>
        <%
            }
        %>
    </body>
</html>
