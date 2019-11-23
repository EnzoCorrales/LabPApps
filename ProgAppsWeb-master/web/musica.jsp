<%-- 
    Document   : musica
    Created on : 16 oct. 2019, 12:16:32
    Author     : tecnologo
--%>

<%@page import="WSClient.DtCategoria"%>
<%@page import="WSClient.DtLR"%>
<%@page import="WSClient.DtVideo"%>
<%@page import="java.sql.*"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Musica</title>
        <link rel="stylesheet" type="text/css" href="Musica.css">
    </head>
    <body>
        <%String valor = request.getParameter("value");
            String prop = request.getParameter("list");
        %>
        <h1><%=valor%></h1>

        <%
            WSClient.SistemaService service = new WSClient.SistemaService();
            WSClient.Sistema port = service.getSistemaPort();
            
            Collection<DtVideo> dtvids = port.listaVideosxCategoria(valor);
            Collection<DtLR> dtlr = port.listaLRxCategoria(valor);
            if (dtvids != null) {
                Iterator<DtVideo> it = dtvids.iterator();
                String url = null;
                String Auxurl = "https://www.youtube.com/embed/iR1sAex__VA";
                String name = "null";
                while (it.hasNext()) {
                    DtVideo dtvid = it.next();

                    Auxurl = dtvid.getUrl();
                    url = Auxurl.substring(17, 28);
                    name = dtvid.getNomVideo();
                    DtCategoria cat = dtvid.getCategoria();

        %>

        <div>
            <%=name%>

        </div>
        <ul>
            <li><iframe width="200" height="105" src="https://www.youtube.com/embed/<%=url%>"></iframe></li>
                    <%
                            }
                        }
                        if (dtlr != null) {
                            for (DtLR dtlista : dtlr) {%>
            <li><a href="Lista.jsp?value=<%=dtlista.getNombre()%>&usr=<%=dtlista.getPropietario()%>"><%=dtlista.getNombre()%></a></li> 
        </ul>
        <%}
            }
        %>
    </body>
</html>
