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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Admin Page</title>
</head>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin") == null) )
{
   
%>
<jsp:forward page="/"></jsp:forward>
<%} %>
<body>
<center><h2>Admin's Home</h2></center>
 
Welcome <%=request.getAttribute("username") %>
<p>Se Alle Brugere</p>

<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Username</th>
      <th scope="col">Firstname</th>
      <th scope="col">Lastname</th>
      <th scope="col">Role</th>
    </tr>
  </thead>
  </tbody>
<c:forEach var="user" items="${requestScope.users}">
    <tr>
      
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
      <td>${user.role}</td>
     
    </tr>
</c:forEach>  
  </tbody>
</table>


  <h1>New message goes here </h1>
 

<p> Slet en Bruger</p>
<form class="form-inline" action="<%=request.getContextPath()%>/admin" method="post">
  <div class="form-group mx-sm-3 mb-2">
      <input id="deleteiduser" name="deleteiduser" type="text" class="form-control"  placeholder="0">
  </div>
  <Button type="submit" value="deleteiduser" class="btn btn-primary mb-2">Slet Bruger</Button>
</form>
<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>  
<p> Slet en post</p>
<p>Lav en ny admin</p>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/SignupAdmin.jsp">Signup a new admin</a></div>
<div style="text-align: right"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>
</body>
</html>