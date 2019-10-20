<%-- 
    Document   : AgregarVideo
    Created on : 20/10/2019, 04:25:08 PM
    Author     : tecnologo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="DT.DtVideo"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <title>JSP Page</title>
    </head>
    <body>
        <form action="AgregarVideoServlet" method="post">
            <div class="container-fluid">
                <div class="row">
                    <!--<div class="col-md-4">-->
                    <%
                        String lista = request.getParameter("value");
                        FabricaSistema f = new FabricaSistema();
                        ISistema s = f.getSistema();
                        Collection<DtVideo> videos = s.ListaTVideos();
                        Iterator<DtVideo> it = videos.iterator();
                        String url;
                        String Auxurl;
                        request.setAttribute("lista", lista);
                        while (it.hasNext()) {
                            DtVideo dtvid = it.next();
                            String nombrevid = dtvid.getNomVideo();
                            url = dtvid.getURL();
                            Auxurl = url.substring(17, 28);%>
                            
                    <div>
                        <input class="nombrenormal" type="radio" name="video" value="<%=nombrevid%>"><%=nombrevid%><br>
                        <iframe class="nombrenormal" width="200" height="105" src="https://www.youtube.com/embed/<%=Auxurl%>"></iframe>
                    </div>
                    <%
                        }
                    %>

                </div>
            </div>
            <input type="submit" value="confirmar">
        </form>
    </body>
</html>
