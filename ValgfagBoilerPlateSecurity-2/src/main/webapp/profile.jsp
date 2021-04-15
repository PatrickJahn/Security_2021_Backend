<%-- 
    Document   : profile
    Created on : Apr 15, 2021, 3:36:17 PM
    Author     : Patrick
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h1><c:out value="${requestScope.clickedUser.username}"> </c:out></h1>
        
            <h2> Name: <c:out value="${requestScope.clickedUser.firstName}" ></c:out>
                        <c:out value=" ${requestScope.clickedUser.lastName}" ></c:out>
        </h2> 
    </body>
</html>
