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
    <link rel="stylesheet" href="CSS/forumStyle.css">
    <link rel="stylesheet" href="CSS/Navbar.css">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="forumStyle.css">
    

<title>Users Page</title>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("User") == null) )
{
%>
<jsp:forward page="/"></jsp:forward>
<%} %>
</head>

<body>
    
    
    <!-- Navbar -->
    
    <ul>
        <li><a href="<%=request.getContextPath()%>/profileServlet?username=<%=session.getAttribute("User")%>">My profile</a></li>
          <li class="active"><a href="<%=request.getContextPath()%>/homeservlet">Forum</a></li>
        <li><a href="<%=request.getContextPath()%>/msgForm.jsp">New post</a></li>
        <li class="logout"><a href="<%=request.getContextPath()%>/logout">Log out</a></li>
   <li class="logouttxt" ><a>User (<%=session.getAttribute("User") %>) </a></li>
</ul>
    
    
    
<center><h2>User's Forum</h2></center>


 <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>




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