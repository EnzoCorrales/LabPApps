<%-- 
    Document   : Lista
    Created on : Oct 17, 2019, 11:42:36 AM
    Author     : gabrixstar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="DT.DtVideo"%>
<%@page import="java.util.Collection"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="Controladores.Sistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UyTube-ListaContent</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("value");
            String nick = request.getParameter("usr");
        %>
        <h1><%=nombre%></h1>
            <%
                HttpSession sesion = request.getSession();
                String url;
                log(nick);
                String Auxurl;
                String name;
                FabricaSistema f = new FabricaSistema();
                ISistema s = f.getSistema();
                Collection<DtVideo> videosLR = s.getDataVideosLR(nick, nombre);
                Iterator<DtVideo> it = videosLR.iterator();
                while (it.hasNext()) {
                    DtVideo dtvid = it.next();
                    Auxurl = dtvid.getURL();
                    url = Auxurl.substring(17, 28);
                    name = dtvid.getNomVideo();
                    String usr = dtvid.getPropietario();
                    String cat = dtvid.getCategoria();%>
                    <br><a class="links" href="Video.jsp?value=<%=name%>&usr=<%=usr%>"><%=name%></a><br>
                    <iframe width="200" height="105" src="https://www.youtube.com/embed/<%=url%>"></iframe>
                <%
                    }
                %>

    </body>
</html>
