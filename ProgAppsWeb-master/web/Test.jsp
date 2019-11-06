<%-- 
    Document   : Test
    Created on : 05/11/2019, 04:36:19 PM
    Author     : luke
--%>

<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <%-- start web service invocation --%><hr/>
    <%
	WebClient.SistemaService service = new WebClient.SistemaService();
	WebClient.Sistema port = service.getSistemaPort();
        
	java.util.List<WebClient.DtCanal> result = port.listaCanales();
	for(WebClient.DtCanal canal : result) {
            try {
                out.print(canal.getNombre() + "<br>");    
            }
            catch(IOException ex) { }
        }
    %>
    <%-- end web service invocation --%><hr/>

     
    </body>
</html>
