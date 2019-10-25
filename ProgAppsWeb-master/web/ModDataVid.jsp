<%-- 
    Document   : ModDataVid
    Created on : Oct 23, 2019, 3:46:42 PM
    Author     : gabrixstar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="DT.DtCategoria"%>
<%@page import="java.util.Collection"%>
<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" type="text/css" href="AltaUsrS.css">
        <title>Modifcar Datos Video</title>
    </head>
    <body>
        <form action="ModDataVidServlet" method="post">
            <p>Nombre Video:</p>
            <input name="NameVideoIns" type="text" class="field"> <br/>
            <p>Duracion:</p>
            <input name="DuracionIns" type="text" class="field"> <br/>
            <p>URL:</p>
            <input name="URLIns" type="text" class="field"> <br/>
            <p>Descripcion:</p>
            <textarea name="DescVideo" class="field"></textarea> <br/>
            <p>Fecha Publicacion:</p>
            <input type="number" class="FechaIns" name="Fdia" min="1" max="31">
            <input type="number" class="FechaIns" name="Fmes" min="1" max="12">
            <input type="number" class="FechaIns" name="Fanio" min="1919" max="2019">
            <p class="Campo">Categoria:
                <select name="categorias">
                    <%
                        String NomVideo = request.getParameter("NombreVideo");
                        if (NomVideo == null) {
                            NomVideo = (String) request.getAttribute("NombreVideo");
                        }
                        //request.getRequestDispatcher("ModDataVidServlet").forward(request, response);
                        FabricaSistema f = new FabricaSistema();
                        ISistema s = f.getSistema();
                        Collection<DtCategoria> dtCategorias = s.ListaCategorias();
                        Iterator<DtCategoria> it = dtCategorias.iterator();
                        String c = "test";
                        while (it.hasNext()) {
                            DtCategoria dtc = it.next();
                            if (dtc != null) {
                                c = dtc.getCategoria();
                            }%>
                    <option value="<%=c%>"><%=c%></option>
                    <%}%>
                </select>
            </p>
            <input type="hidden" id="NombreVideo" name="NombreVideo" value="<%=NomVideo%>">
            <p>Privacidad:</p>
            <input type="radio" name="privado" value="publico" checked> Publico <input type="radio" name="privado" value="privado"> Privado <br />
            <p class="center-content">
                <input type="submit" class="subirVidbtn" value="Modificar">
            </p>
        </form>
    </body>
</html>
