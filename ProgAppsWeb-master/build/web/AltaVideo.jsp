<%@page import="Interfaz.ISistema"%>
<%@page import="Fabrica.FabricaSistema"%>
<%@page import="DT.DtCategoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="Controladores.Sistema"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Subir video - UyTube</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" type="text/css" href="AltaUsrS.css">
    </head>
    <body>
        <script type="text/javascript" src="script.js"></script>
        <form action="AltaVideoServlet" method="post">
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
            <p class="center-content">
                <input type="submit" class="subirVidbtn" value="Subir Video">
            </p>
        </form>
    </body>
</html>