<%-- 
    Document   : Video
    Created on : 16/10/2019, 03:02:38 PM
    Author     : tecnologo
--%>

<%@page import="DT.DtComentario"%>
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
        <title>JSP Page</title>
    </head>
    <%!
        void respuestas(Collection<DtComentario> respuestas) {
            Iterator<DtComentario> itAux = respuestas.iterator();
            while (itAux.hasNext()) {
                DtComentario dtcom = itAux.next();

                if (dtcom.hayRespuestas() == true) {
                    respuestas(dtcom.getRespuetas());
                }
                dtcom.getTexto();
            }
        }
    %>
    <body>
        <% String nombre = request.getParameter("value");%>
        <h1><%=nombre%></h1>
        <%
            Sistema s = Sistema.getInstance();
            Collection<DtVideo> TVideos = s.ListaTVideos();
            Collection<DtValoracion> Valoraciones = null;
            Iterator<DtVideo> it = TVideos.iterator();
            String url = "test";
            String desc = "test";
            String usr = "usuario";
            int likes = 0;
            int dislikes = 0;
            String Auxurl = "test";
            Collection<DtComentario> comentarios = null;
            while (it.hasNext()) {
                DtVideo dtvid = it.next();
                if (dtvid.getNomVideo().equalsIgnoreCase(nombre)) {
                    url = dtvid.getURL();
                    desc = dtvid.getDescripcion();
                    Valoraciones = dtvid.getValoraciones();
                    usr = dtvid.getPropietario();
                    comentarios = s.ListaComentarios(usr, nombre);
                }
            }
            Iterator<DtValoracion> it2 = Valoraciones.iterator();
            while (it2.hasNext()) {
                if (it2.next().getValoracion()) {
                    likes++;
                } else {
                    dislikes++;
                }
            }
            Auxurl = url.substring(17, 28);
        %>
        <iframe id="iFrame" name="iFrame" width="600" height="400" src="https://www.youtube.com/embed/<%=Auxurl%>" ></iframe> 
        <p><%=usr%></p>
        <p>Descripcion:
            <%=desc%></p>
        <p>Likes:<%=likes%>
            Dislikes<%=dislikes%></p>
            <%
                Iterator<DtComentario> it3 = comentarios.iterator();
                while (it3.hasNext()) {
                    DtComentario dtcom = it3.next();
                    String comentador = dtcom.getNick();
                    String comment = dtcom.getTexto();
                    Collection<DtComentario> resp = dtcom.getRespuetas();
            %>
        <p><%=comentador%>:<%=comment%></p>

        <p><%//respuestas(resp);%></p>
        <%}%>
    </body>
</html>