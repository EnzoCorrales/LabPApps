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
<!DOCTYPE html>
<html>
    <head>
        <meta name = "viewport" content = "width = device-width, initial-scale = 1">
        <link type="text/css" rel="stylesheet" href="/UyTube2/css/materialize.css"  media="screen,projection"/>
        <link rel="stylesheet" type="text/css" href="VideoStyle.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="/UyTube2/js/materialize.js"></script>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("value");
            String nick = request.getParameter("usr");
            String usuario = (String) session.getAttribute("username");
            FabricaSistema fa = new FabricaSistema();
            ISistema s = fa.getSistema();
            DtVideo vid = s.getDataVideo(nombre, nick);
            
        %>
        <%
            if (request.getParameter("Like") != null) {
                s.ValorarVideo(nick, nombre, usuario, true);
            }

            if (request.getParameter("Dislike") != null) {
                s.ValorarVideo(nick, nombre, usuario, false);
            }
            
            if(request.getParameter("nickC") != null){
                s.AgregarRespuesta(nick, nombre, request.getParameter("nickC"), request.getParameter("comC"), usuario,request.getParameter("com"));
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
                <button class="waves-effect waves-teal btn-flat blue" type="submit" onclick="buttonL()">
                    <i class="material-icons">thumb_up</i>
                </button><%
                } else {%>
                <button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonL()">
                    <i class="material-icons">thumb_up</i>
                </button><%
                    }%>
            </form>
            <%} else {%>
            <a href="Login.jsp" target="_parent">
                <button class="waves-effect waves-teal btn-flat white" type="submit">
                    <i class="material-icons">thumb_up</i>
                </button>
            </a>
            <%}%>

            <%if (usuario != null) {%>
            <form name="form1" method="post">
                <input type="hidden" name="Dislike">
                <%if (s.UTieneValoracionI(nick, nombre, usuario, false) == true) {%>
                <button class="waves-effect waves-teal btn-flat red" type="submit" onclick="buttonDL()">
                    <i class="material-icons">thumb_down</i>
                </button><%
                } else {%>
                <button class="waves-effect waves-teal btn-flat white" type="submit" onclick="buttonDL()">
                    <i class="material-icons">thumb_down</i>
                </button><%
                    }%>
            </form>
            <%} else {%>
            <a href="Login.jsp" target="_parent">
                <button class="waves-effect waves-teal btn-flat white" type="submit">
                    <i class="material-icons">thumb_down</i>
                </button>
            </a>
            <%}%>
            <p>Propietario:
                <%if (!prop.equalsIgnoreCase(usuario)) {%>
                <a class="prop" href="PerfilUsr.jsp?usr=<%=prop%>"><%=prop%></a>
                <%} else if (prop.equalsIgnoreCase(usuario)) {%>
                <a class="prop" href="MiPerfil.jsp"><%=prop%></a>
                <%} else if (usuario.equalsIgnoreCase(null)) {%>
                <a class="prop" href="PerfilUsr.jsp?usr=<%=prop%>"><%=prop%></a>
                <%}%>
            </p>
            <p>Descripcion:
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
                <p> Categoria: <%=cat%> </p>
            </div>
            <%if (request.getParameter("comm") != null) {
                    s.AgregarComentarioNuevo(nick, usuario, nombre, request.getParameter("Comentario"));
                }%>
            <h6>Comentarios</h6>
            <%if (usuario != null) {%>
            <form name="comentar" method="post">
                <input type="hidden" name="comm">
                <input type="text" name="Comentario" class="validate" required>
                <button class="waves-effect waves-teal btn-flat blue" type="submit" onClick="buttonCom2()">Comentar
                    <i class="material-icons right">send</i>
                </button>
            </form>
            <%} else {%>
            <input type="text" name="Comentario" class="validate">
            <a href="Login.jsp" target="_parent">
                <button class="waves-effect waves-teal btn-flat blue" type="submit">Comentar
                    <i class="material-icons right">send</i>
                </button>
            </a>
            <%}%>
            <%
                ArrayList<DtComentario> lista = new ArrayList<>();
                ArrayList<DtComentario> lista2 = new ArrayList<>();
                Collection<DtComentario> dt = s.ListaComentarios(nick, nombre);
                Iterator<DtComentario> it = dt.iterator();
                while (it.hasNext()) {
                    DtComentario dtc = it.next();
                    lista.add(dtc);
                    lista2.add(dtc);
                }
                for (int i = 0; i < lista.size(); i++) {
                    DtComentario com = lista.get(i);

            %>
            <div class="comments-container">
                <ul id="comments-list" class="comments-list">
                    <li>
                        <%if (com.getPadre() == 0) {%>
                        <div class="comment-main-level">
                            <!-- Avatar -->
                            <%DtUsuario dtu = s.getDataUsuario(com.getNick());%>
                            <div class="comment-avatar"><img src="<%=dtu.getImagen()%>" alt=""></div>
                            <!-- Contenedor del Comentario -->
                            <div class="comment-box">
                                <div class="comment-head">
                                    <h6 class="comment-name"><a href=""><%=dtu.getNick()%></a></h6>
                                </div>
                                <div class="comment-content">
                                    <%=com.getTexto()%>
                                    <h6>Respuesta</h6>
                                    <%if (usuario != null) {%>
                                    <form name="responder" method="post">
                                        <input type="text" name="Comentario" class="validate" required>
                                        <input type="hidden" name="nickC" value="<%=com.getNick()%>">
                                        <input type="hidden" name="comC" value="<%=com.getTexto()%>">
                                        <button class="waves-effect waves-teal btn-flat blue" type="submit" onClick="buttonCom()">Responder
                                            <i class="material-icons right">send</i>
                                        </button>
                                    </form>
                                    <%} else {%>
                                    <input type="text" name="Comentario" class="validate">
                                    <a href="Login.jsp" target="_parent">
                                        <button class="waves-effect waves-teal btn-flat blue" type="submit">Responder
                                            <i class="material-icons right">send</i>
                                        </button>
                                    </a><%}%>
                                </div>
                            </div>
                        </div> 
                        <%} else {
                            for (int a = 0; a < lista2.size(); a++) {
                                DtComentario resp = lista2.get(a);
                                if (com.getPadre() == resp.getId()) {%>
                        <!-- Respuestas de los comentarios -->
                        <ul class="comments-list reply-list">
                            <li>
                                <!-- Avatar -->
                                <%DtUsuario dtu = s.getDataUsuario(com.getNick());%>
                                <div class="comment-avatar"><img src="<%=dtu.getImagen()%>" alt=""></div>
                                <!-- Contenedor del Comentario -->
                                <div class="comment-box">
                                    <div class="comment-head">
                                        <h6 class="comment-name"><a href=""><%=com.getNick()%></a></h6>
                                        <%if (usuario != null) {%>
                                        <a href="Responder.jsp?&value=<%=nombre%>&usr=<%=nick%>&nickC=<%=com.getNick()%>&comC=<%=com.getTexto()%>">
                                            <button class="waves-effect waves-teal btn-flat" type="submit">
                                                <i class="material-icons">reply</i>
                                            </button>
                                        <a/>
                                        <%} else {%>
                                        <input type="text" name="Comentario" class="validate">
                                        <a href="Login.jsp" target="_parent">
                                            <button class="waves-effect waves-teal btn-flat blue" type="submit">Responder
                                                <i class="material-icons right">send</i>
                                            </button>
                                        </a><%}%>
                                    </div>
                                    <div class="comment-content">
                                        <%="@" + resp.getNick() + " " + com.getTexto()%>
                                        
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>

                    <%}
                                }
                            }
                        }%>
                </ul>
            </div>
            <script language="JavaScript">
                function buttonCom()
                {
                    responder.submit();
                }
            </script>
            <script language="JavaScript">
                function buttonCom2()
                {
                    document.comentar.comm.value = "yes";
                    comentar.submit();
                }
            </script>
            <script language="JavaScript">
                function buttonCom1()
                {
                    responderR.submit();
                }
            </script>
        </div>
    </body>
</html>