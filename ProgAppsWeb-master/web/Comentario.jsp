<%-- 
    Document   : Comentario.jsp
    Created on : Oct 17, 2019, 11:23:59 PM
    Author     : gabrixstar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <ul>
            <c:forEach var="box" items="${boxList}">
                <li>
                    ${box.name} <!-- or whatever else you want to display -->
                    <jsp:include page="box.jsp" />
                </li>
            </c:forEach>
        </ul>

    </body>
</html>
