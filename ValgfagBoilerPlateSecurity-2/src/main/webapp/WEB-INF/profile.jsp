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
            <link rel="stylesheet" href="CSS/forumStyle.css">
              <link rel="stylesheet" href="CSS/profileStyle.css">
            <link rel="stylesheet" href="CSS/Navbar.css">
                    <link rel="stylesheet" href="CSS/background.css">
                    

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
        <li class="active"><a href="<%=request.getContextPath()%>/profileServlet?username=<%=session.getAttribute("User")%>">My profile</a></li>
          <li ><a href="<%=request.getContextPath()%>/homeservlet">Forum</a></li>
        <li><a href="<%=request.getContextPath()%>/msgForm.jsp">New post</a></li>
        <li class="logout"><a href="<%=request.getContextPath()%>/logout">Log out</a></li>
   <li class="logouttxt" ><a>User (<%=session.getAttribute("User") %>) </a></li>
</ul>


            <img class="pb" src="ProfileImages/${requestScope.clickedUser.imgPath}"/>
            <div style="color: white"class="info">
        <h1 class="username"><c:out value="${requestScope.clickedUser.username}"> </c:out></h1>
        
            <h2 class="name"> Name: <c:out value="${requestScope.clickedUser.firstName}" ></c:out>
                        <c:out value=" ${requestScope.clickedUser.lastName}" ></c:out>
             </h2> 
             </div>

             <div class="madeby">                
                 <h2  style="color:white" class="postTitle">All posts made by <c:out value="${requestScope.clickedUser.username}"> </c:out> </h2>
        
            </div> 
<c:forEach var="msg" items="${requestScope.messages}">
    
    <div style="color:white"class="msgDiv">
        
     
    <h2 class="msgTitle">${msg.title}</h2>
               <a class="msgUser" href="<%=request.getContextPath()%>/profileServlet?username=${msg.username}">by ${msg.username}</a>

    <h5 class="msgText">${msg.msg}</h5>
    <img class="msgImg" src="Images/${msg.imgPath}"/>

</div>
    
      </c:forEach>
    </body>
</html>
