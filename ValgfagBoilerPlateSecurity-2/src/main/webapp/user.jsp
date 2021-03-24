<%-- 
    Document   : admin
    Created on : Mar 10, 2021, 1:45:23 PM
    Author     : Patrick
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Users Page</title>
</head>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("User") == null) )
{
%>
<jsp:forward page="/"></jsp:forward>
<%} %>
<body>
<center><h2>User's Forum</h2></center>


 
Welcome <%=request.getAttribute("userName") %>
 
<div style="text-align: right"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/msgForm.jsp">Post new msg</a></div>

<c:forEach var="msg" items="${requestScope.messages}">
    <div class="msgDiv">
    <h3 class="msgUser"> User name</h3>
    <h2 class="msgTitle">${msg.title}</h2>
    <h5 class="msgText">${msg.msg}</h5>
    <img src="Images/${msg.imgPath}"/>

</div>
      </c:forEach>

</body>
</html>