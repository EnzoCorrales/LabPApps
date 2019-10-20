<%-- 
    Document   : Video
    Created on : 16/10/2019, 03:02:38 PM
    Author     : tecnologo
--%>

<%@page import="DT.*"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="Entidades.Fecha"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="Controladores.Sistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="ValoracionScript.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String nombre = request.getParameter("value");
            String nick = request.getParameter("usr");
        %>
        
        <h1><%=nombre%></h1>
        <%
            FabricaSistema fa = new FabricaSistema();
            ISistema s = fa.getSistema();
            DtVideo vid = s.getDataVideo(nombre, nick);
            String url = vid.getURL();
            String desc = vid.getDescripcion();
            String Auxurl = null;
            Auxurl = url.substring(17, 28);
        %>
        <iframe id="iFrame" name="iFrame" width="600" height="400" src="https://www.youtube.com/embed/<%=Auxurl%>" ></iframe> 
        <p>Descripcion:
            <%=desc%></p>
        <%
            if(request.getParameter("Like") != null){
                if(session.getAttribute("username") != null)
                    s.ValorarVideo(nick, nombre,(String) session.getAttribute("username"), true);
                else
                    out.println("Inicie sesión");
            }
            if(request.getParameter("Dislike") != null){
                if(session.getAttribute("username") != null)
                    s.ValorarVideo(nick, nombre, (String) session.getAttribute("username"), false);
                else
                    out.println("Inicie sesión");
            }
        %>
        <form name="form" method="post">
            <input type="hidden" name="Like">
            <input type="button" value="Like" onclick="buttonL()">
        </form>
        <form name="form1" method="post">
            <input type="hidden" name="Dislike">
            <input type="button" value="Dislike" onclick="buttonDL()">
        </form>    
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