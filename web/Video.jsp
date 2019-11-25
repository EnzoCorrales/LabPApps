<%-- 
    Document   : Video
    Created on : 16/10/2019, 03:02:38 PM
    Author     : tecnologo
--%>

<%@page import="Entidades.*"%>
<%@page import="DT.*"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>
        <!--<link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="VideoStyle.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String si = (String) request.getAttribute("si");
            String nombre, nick;
            if (si != null) {
                nombre = (String) request.getAttribute("value");
                nick = (String) request.getAttribute("usr");
            } else {
                nombre = request.getParameter("value");
                nick = request.getParameter("usr");
            }
            String usuario = (String) session.getAttribute("username");
            FabricaSistema fa = new FabricaSistema();
            ISistema s = fa.getSistema();
            DtVideo vid = s.getDataVideo(nombre, nick);
            int likes = vid.getLikes();
            int dislikes = vid.getDislikes();

            if (request.getParameter("Like") != null) {
                s.ValorarVideo(nick, nombre, usuario, true);
            }

            if (request.getParameter("Dislike") != null) {
                s.ValorarVideo(nick, nombre, usuario, false);
            }
        %>
        <div>

            <%if (usuario != null) {
                    if (usuario.equalsIgnoreCase(vid.getPropietario())) {%>
            <p class="titulo"><a href="ModDataVid.jsp?NombreVideo=<%=nombre%>">Modificar datos</a></p>  
            <%}
                }%>
            <%
                String cat = vid.getCategoria();
                String dur = vid.getDuracion();
                String url = vid.getURL();
                String desc = vid.getDescripcion();
                String Auxurl = null;
                String prop = vid.getPropietario();
                Auxurl = url.substring(17, 28);
                session.setAttribute("vid", vid);
                session.setAttribute("value", prop);
            %>
            <iframe id="iFrame" class="frame" name="iFrame" width="900" height="500" src="https://www.youtube.com/embed/<%=Auxurl%>" frameborder="0" scrolling="no"></iframe> 
            <h4 class="titulo"><%=nombre%></h4> 
            <%if (usuario != null) {%>
            <form name="form" method="post">
                <input type="hidden" name="Like">
                <%if (s.UTieneValoracionI(nick, nombre, usuario, true) == true) {%>
                <p><button class="waves-effect waves-teal btn-flat blue" type="submit" onclick="buttonL()">
                        <i class="material-icons">thumb_up</i>
                    </button><%=likes%></p><%
                    } else {%>
                <p><button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonL()">
                        <i class="material-icons">thumb_up</i>
                    </button><%=likes%></p><%
                        }%>
            </form>
            <%} else {%>
            <a href="Login.jsp" target="_parent">
                <p><button class="waves-effect waves-teal btn-flat white" type="submit">
                        <i class="material-icons">thumb_up</i>
                    </button><%=likes%></p>
            </a>
            <%}%>

            <%if (usuario != null) {%>
            <form name="form1" method="post">
                <input type="hidden" name="Dislike">
                <%if (s.UTieneValoracionI(nick, nombre, usuario, false) == true) {%>
                <p><button class="waves-effect waves-teal btn-flat red" type="submit" onclick="buttonDL()">
                        <i class="material-icons">thumb_down</i>
                    </button><%=dislikes%></p><%
                    } else {%>
                <p><button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonDL()">
                        <i class="material-icons">thumb_down</i>
                    </button><%=dislikes%></p><%
                        }%>
            </form>
            <%} else {%>
            <a href="Login.jsp" target="_parent">
                <p><button class="waves-effect waves-teal btn-flat white" type="submit">
                        <i class="material-icons">thumb_down</i>
                    </button><%=dislikes%></p>
            </a>
            <%}%>
            <p><h4>Propietario:</h4>
                <%if (!prop.equalsIgnoreCase(usuario)) {%>
                <a class="prop" href="PerfilUsr.jsp?usr=<%=prop%>"><%=prop%></a>
                <%} else if (prop.equalsIgnoreCase(usuario)) {%>
                <a class="prop" href="MiPerfil.jsp"><%=prop%></a>
                <%} else if (usuario.equalsIgnoreCase(null)) {%>
                <a class="prop" href="PerfilUsr.jsp?usr=<%=prop%>"><%=prop%></a>
                <%}%>
            </p>
            <p><h4>Descripcion:</h4>
                <%=desc%></p>
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
            <div class="cateogria">
                <p><h4> Categoria:</h4> <%=cat%> </p>
            </div>
            <h4> Comentarios </h4>
            <p>Comentar<p>
            <form action="Comentar" method="post">
                <input type="text" name="comentario" required>
                <input type="hidden" name="nick" value="<%=nick%>">
                <input type="hidden" name="nomVideo" value="<%=nombre%>">
                <button type="submit" title="Comentar">
                    <i class="material-icons">send</i>
                </button>
            </form>
            <%!public String getHtml(ArrayList<DtComentario> c, String nomVideo, String usuario) {
                    StringBuilder html = new StringBuilder();
                    html.append("<ul>");
                    for (int i = 0; i < c.size(); i++) {
                        DtComentario dt = c.get(i);
                        html.append("<li>").append(dt.getNick()).append("<br>").append(dt.getTexto()).append("<a href=\"Responder.jsp?value=").append(nomVideo).append("&usr=").append(usuario).append("&nickC=").append(dt.getNick()).append("&comC=").append(dt.getTexto()).append("\"").append(" title=\"Responder\" class=\"resp\"><i class=\"material-icons\">reply</i></a>").append("</li>").append("<br>");
                        //html.append("<li>").append(dt.getTexto()).append("</li>");
                        if (dt.hayRespuestas() == true) {
                            html.append(getHtml(dt.getRespuetas(), nomVideo, usuario));
                        }
                    }
                    html.append("</ul>");
                    return html.toString();
                }
            %>
            <%
                Collection<DtComentario> c = s.ListaComentarios(nick, nombre);
                ArrayList<DtComentario> comentarios = new ArrayList<>();
                Iterator<DtComentario> it = c.iterator();
                while (it.hasNext()) {
                    DtComentario dtc = it.next();
                    comentarios.add(dtc);
                }
                String test = getHtml(comentarios, nombre, nick);
            %>
            <c:set var="test" value="<%=test%>"/>
            <c:out value="${test}" escapeXml="false"/>
        </div>
    </body>
</html>

<!--escapeXml="false"-->