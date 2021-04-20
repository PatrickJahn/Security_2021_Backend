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
        <% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("User") == null) )
{
%>
<jsp:forward page="/"></jsp:forward>
<%} %>
    </head>
    <body>
        <h1><c:out value="${requestScope.clickedUser.username}"> </c:out></h1>
        
            <h2> Name: <c:out value="${requestScope.clickedUser.firstName}" ></c:out>
                        <c:out value=" ${requestScope.clickedUser.lastName}" ></c:out>
        </h2> 
        <h3>Profile Image:</h3>
        <img src="ProfileImages/${requestScope.clickedUser.imgPath}"/>
                        <h1>${msg.imgPath}</h1>               
        <h2>All posts made by <c:out value="${requestScope.clickedUser.username}"> </c:out> </h2>
        

<c:forEach var="msg" items="${requestScope.messages}">
    
   
    <div class="msgDiv">
    <a class="msgUser" href="<%=request.getContextPath()%>/profileServlet?username=${msg.username}">${msg.username}</a>
    <h2 class="msgTitle">${msg.title}</h2>
    <h5 class="msgText">${msg.msg}</h5>
    <img src="Images/${msg.imgPath}"/>

</div>
      </c:forEach>
    </body>
</html>
