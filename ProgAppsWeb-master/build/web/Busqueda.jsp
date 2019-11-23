<%-- 
    Document   : Busqueda
    Created on : Oct 13, 2019, 5:58:30 PM
    Author     : kangaru
--%>

<%@page import="WSClient.DtTipo"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="BusquedaStyle.css"> 
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<DtTipo> videos = (ArrayList<DtTipo>) request.getAttribute("Resultados");
            Iterator<DtTipo> it = videos.iterator();
            String user = (String) session.getAttribute("username");
            while (it.hasNext()) {
                DtTipo dt = it.next();
                String nom = dt.getNombre();
                String nick = dt.getPropietario();
                if(dt.getTipo().equalsIgnoreCase("Video")){
        %>
                <a class="links" href="Video.jsp?value=<%=nom%>&usr=<%=nick%>"><%=nom%></a>
        <%
                }
                if(dt.getTipo().equalsIgnoreCase("Lista")){
        %>
                <a class="links" href="Lista.jsp?value=<%=nom%>&usr=<%=nick%>"><%=nom%></a>
        <%
                }
                if(dt.getTipo().equalsIgnoreCase("Canal")){
                    if(nick.equalsIgnoreCase(user)){
        %>
                        <a class="links" href="MiPerfil.jsp?value=<%=nom%>&usr=<%=nick%>"><%=nom%></a>
        <%
                    }
                    else{
        %>
                        <a class="links" href="PerfilUsr.jsp?value=<%=nom%>&usr=<%=nick%>"><%=nom%></a>
        <%
                    }
                }
            }
        %>
    </body>
</html>
