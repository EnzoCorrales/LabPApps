<%-- 
    Document   : Busqueda
    Created on : Oct 13, 2019, 5:58:30 PM
    Author     : kangaru
--%>

<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="Controladores.Sistema"%>
<%@page import="Entidades.Fecha"%>
<%@page import="java.util.*"%>
<%@page import="DT.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<DtTipo> videos = (ArrayList<DtTipo>) request.getAttribute("Resultados");
            Iterator<DtTipo> it = videos.iterator();
            FabricaSistema f = new FabricaSistema();
            ISistema s = f.getSistema();
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
        %>
                <a class="links" href="PerfilUsr.jsp?value=<%=nom%>&usr=<%=nick%>"><%=nom%></a>
        <%
                }
            }
        %>
        <div class="Iframes">
            <!--<iframe id="iFrame" name="iFrame" width="98%" height="700" src="https://www.youtube.com/embed/<br>" ></iframe>-->
        </div>
    </body>
</html>
