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
    <link rel="stylesheet" href="forumStyle.css">
    

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


 <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
Welcome <%=session.getAttribute("User") %>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/msgForm.jsp">Post new msg</a></div>


  <!-- Forum List -->
            <div class="inner-main-body p-2 p-sm-3 collapse forum-content show">
               
                </div>
<c:forEach var="msg" items="${requestScope.messages}">
    
   
    <div class="msgDiv">
        
        <img class="msgUserImg" src="ProfileImage/something">
    <h2 class="msgTitle">${msg.title}</h2>
               <a class="msgUser" href="<%=request.getContextPath()%>/profileServlet?username=${msg.username}">by ${msg.username}</a>

    <h5 class="msgText">${msg.msg}</h5>
    <img class="msgImg" src="Images/${msg.imgPath}"/>

</div>
    
    
      </c:forEach>

</body>
</html>