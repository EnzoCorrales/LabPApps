<%-- 
    Document   : Lista
    Created on : Oct 17, 2019, 11:42:36 AM
    Author     : gabrixstar
--%>

<%@page import="WSClient.DtVideo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UyTube-ListaContent</title>
    </head>
    <body>
        <%
            String valor = request.getParameter("value");
            String nick = request.getParameter("usr");
            
        
        %>
        <h1><%=valor%></h1>

            <%
                String url;
                String Auxurl;
                String name;
                
                WSClient.SistemaService service = new WSClient.SistemaService();
                WSClient.Sistema port = service.getSistemaPort();
            
                
                Collection<DtVideo> videosLR = port.getDataVideosLR(nick, valor);
                Iterator<DtVideo> it = videosLR.iterator();
                while (it.hasNext()) {
                    DtVideo dtvid = it.next();
                    Auxurl = dtvid.getUrl();
                    url = Auxurl.substring(17, 28);
                    name = dtvid.getNomVideo();%>
                    <p><%=name%></p><iframe width="200" height="105" src="https://www.youtube.com/embed/<%=url%>"></iframe>
                <%      
                    }
                %>

    </body>
</html>
