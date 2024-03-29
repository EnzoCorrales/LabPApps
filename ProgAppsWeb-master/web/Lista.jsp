<%-- 
    Document   : Lista
    Created on : Oct 17, 2019, 11:42:36 AM
    Author     : gabrixstar
--%>

<%@page import="WSClient.DtVideo"%>
<%@page import="WSClient.DtCategoria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="ListaStyle.css">
        <link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('select');
                var instances = M.FormSelect.init(elems);
            });
        </script>
        <title>UyTube-ListaContent</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("value");
            String nick = request.getParameter("usr");%>
        <h2><%=nombre%> <a href="ModDataLR.jsp?value=<%=nombre%>&usr=<%=nick%>" title="Modificar lista" class="waves-effect waves-teal btn-flat btn-large"><i class="material-icons">edit</i></a></h2>
        Categorias:
        <%
            WSClient.SistemaService service = new WSClient.SistemaService();
            WSClient.Sistema port = service.getSistemaPort();
            List<DtCategoria> cat = port.listaCategorias();
            if (cat != null) {
                for (DtCategoria lista : cat) {%>
                     <%=lista.getCategoria()%>
                <%}%>
        <%}else {%>
        no tiene
        <%}%>
        <%String logged = (String) session.getAttribute("username");
            if (logged!= null) {
                if (logged.equalsIgnoreCase(nick)) {%>
        <p><a href="AgregarVideo.jsp?value=<%=nombre%>&usr=<%=nick%>" title="Agregar video" class="ngl btn-floating btn-small waves-effect waves-light red"><i class="material-icons">add</i></a></p>
        <%
                }
            }
        %>
        <%
            String Auxurl;
            String name;
            Collection<DtVideo> videosLR = port.getDataVideosLR(nick, nombre);
            Iterator<DtVideo> it = videosLR.iterator();%>
        <%while (it.hasNext()) {
                DtVideo dtvid = it.next();
                Auxurl = dtvid.getUrl();
                String url = Auxurl.substring(17, 28);
                name = dtvid.getNomVideo();
                String prop = dtvid.getPropietario();
                DtCategoria categ = dtvid.getCategoria();%>
        <a href="Video.jsp?value=<%=name%>&usr=<%=prop%>">
            <p><%=name%> <a href="QuitarVideoServlet?lista=<%=nombre%>&usr=<%=logged%>&nombre=<%=name%>" title="Quitar video" class="ngl btn-floating btn-small waves-effect waves-light red"><i class="material-icons">remove</i></a></p>
            <div class="thumbnail">
                <iframe src="//img.youtube.com/vi/<%=url%>/0.jpg" frameborder="0" scrolling="no" ></iframe>
            </div>
        </a><%
            }
        %>
    </body>
</html>
