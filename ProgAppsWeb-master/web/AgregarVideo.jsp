<%-- 
    Document   : AgregarVideo
    Created on : 20/10/2019, 04:25:08 PM
    Author     : tecnologo
--%>

<%@page import="WSClient.DtVideo"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <title>JSP Page</title>
    </head>
    <body>
        <%
            String lista = request.getParameter("value");
            String usr = request.getParameter("usr");
        %>
        <div class="container-fluid">
            <div class="row">
                <!--<div class="col-md-4">-->
                <%
                    WSClient.SistemaService service = new WSClient.SistemaService();
                    WSClient.Sistema port = service.getSistemaPort();

                    Collection<DtVideo> videos = port.listaTVideos();
                    Iterator<DtVideo> it = videos.iterator();
                    String url;
                    String Auxurl;
                    while (it.hasNext()) {
                        DtVideo dtvid = it.next();
                        String nombrevid = dtvid.getNomVideo();
                        url = dtvid.getUrl();
                        Auxurl = url.substring(17, 28);
                        String prop = dtvid.getPropietario();%>
                <div>
                    <a class="nombrenormal" href="AgregarVideoServlet?nombre=<%=nombrevid%>&prop=<%=prop%>&usr=<%=usr%>&lista=<%=lista%>"><%=nombrevid%><br>
                        <iframe class="nombrenormal" width="200" height="105" src="https://www.youtube.com/embed/<%=Auxurl%>"></iframe>
                </div>
                <%
                    }
                %>

            </div>
        </div>
    </body>
</html>
