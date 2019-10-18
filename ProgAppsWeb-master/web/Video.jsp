<%-- 
    Document   : Video
    Created on : 16/10/2019, 03:02:38 PM
    Author     : tecnologo
--%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="ValoracionScript.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <% String nombre = request.getParameter("value");
           String nick = request.getParameter("usr");
        %>
        
        <h1><%=nombre%></h1>
        <%
            FabricaSistema fa = new FabricaSistema();
            ISistema s = fa.getSistema();
            DtVideo vid = s.getDataVideo(nombre, nick);
            String url = vid.getURL();;
            String desc = "test";
            String Auxurl = null;
            
             /*while (it2.hasNext()) {
                if (it2.next().getValoracion()) {
                    likes++;
                } else {
                    dislikes++;
                }
            }*/
            Auxurl = url.substring(17, 28);
            session.setAttribute("vid", vid);
        %>
        <iframe id="iFrame" name="iFrame" width="600" height="400" src="https://www.youtube.com/embed/<%=Auxurl%>" ></iframe> 
        <p>Descripcion:
            <%=desc%></p>
        <form action="MeGustaServlet" method="post">
            <input type="submit" value="Like"/>
        </form>
        <form action="NoMeGustaServlet" method="post">
            <input type="submit" value="Dislike"/>
        </form>
    </body>
</html>