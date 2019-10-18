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
                //if(dt.gettipo==lista){}elseif(gettipo==canal){}else{}
                DtVideo dtvid = s.getDataVideo(dt.getNombre(), dt.getPropietario());
                String nom = dtvid.getNomVideo();
                String nick = dtvid.getPropietario();
                session.setAttribute("nom", nom);
                session.setAttribute("nick", nick);
                %>
                <a class="links" href="Video.jsp?value=<%=nom%>&usr=<%=nick%>"><%=nom%></a>
                <%
            }
        %>
        <div class="Iframes">
            <!--<iframe id="iFrame" name="iFrame" width="98%" height="700" src="https://www.youtube.com/embed/<br>" ></iframe>-->
        </div>
    </body>
</html>
