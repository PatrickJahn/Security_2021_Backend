<%-- 
    Document   : admin
    Created on : Mar 10, 2021, 1:45:23 PM
    Author     : Patrick
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

<div class="msgDiv">
    <h3 class="msgUser"> Username has posted</h3>
    <h2 class="msgTitle">Title</h2>
    <h5 class="msgText">Example msg ajnsdjndasjkndjnasndljanjlsdnasndjklnasjndanjsdnjlasldnasdjnlj :)</h5>
        <!-- muligvis <img>-->
</div>
</body>
</html>