<%-- 
    Document   : node.jsp
    Created on : Oct 23, 2019, 9:01:13 PM
    Author     : gabrixstar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <c:forEach var="comentario" items="${comentario.getRespuestas()}">
                <c:out value="${comentario.getTexto()}"/>
                <c:set var="comentario" value="${respuestas}" scope="request"/>
                <jsp:include page="node.jsp"/>
            </c:forEach>
        </ul>
    </body>
</html>
