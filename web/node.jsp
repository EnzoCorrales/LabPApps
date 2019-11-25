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
            <li>Fruit
                <ul>
                    <li>Bananas</li>
                    <li>Apples
                        <ul>
                            <li>Green</li>
                            <li>Red</li>
                        </ul>
                    </li>
                    <li>Pears</li>
                </ul>
            </li>
            <li>Vegetables</li>
            <li>Meat</li>
        </ul>
    </body>
</html>
