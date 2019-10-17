<%-- 
    Document   : Video
    Created on : 16/10/2019, 03:02:38 PM
    Author     : tecnologo
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String nombre = request.getParameter("value");%>
        <h1><%=nombre%></h1>
        <%
            Sistema s = Sistema.getInstance();
            Collection<DtVideo> TVideos = s.ListaTVideos();
            Collection<DtValoracion> Valoraciones = null;
            Collection<DtUsuario> usuarios = s.ListaUsuarios();
            Iterator<DtVideo> it = TVideos.iterator();
            String url = "test";
            String desc = "test";
            Fecha f;
            int likes = 0;
            int dislikes = 0;
            String Auxurl= "test";
            while (it.hasNext()) {
                DtVideo dtvid = it.next();
                if (dtvid.getNomVideo().equalsIgnoreCase(nombre)) {
                    url = dtvid.getURL();
                    desc = dtvid.getDescripcion();
                    Valoraciones = dtvid.getValoraciones();
                }
            }
            Iterator<DtValoracion> it2 = Valoraciones.iterator();
            while (it2.hasNext()) {
                if (it2.next().getValoracion()) {
                    likes++;
                } else {
                    dislikes++;
                }
            }
            Auxurl = url.substring(17,28);
        %>
        <iframe id="iFrame" name="iFrame" width="600" height="400" src="https://www.youtube.com/embed/<%=Auxurl%>" ></iframe> 
        <p>Descripcion:
           <%=desc%></p>
        <p>Likes:<%=likes%>
           Dislikes<%=dislikes%></p>

    </body>
</html>