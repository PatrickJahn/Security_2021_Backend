<%-- 
    Document   : login
    Created on : Mar 10, 2021, 12:09:20 PM
    Author     : Patrick
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin") == null) )
{
   
%>
<jsp:forward page="/"></jsp:forward>
<%} %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Signup Admin</title>
    </head>
    <body>
          <h1>Signup a new admin user </h1>
        <form enctype="multipart/form-data" name="form" action="<%=request.getContextPath()%>/SignupAdmin" method="post">
 
        <table align="center">
        <tr>
        <td>Username</td>
        <td><input type="text" name="username" /></td>
        </tr>
         <tr>
        <td>Password</td>
        <td><input type="text" name="password" /></td>
        </tr>
        <tr>
        <td>First name</td>
        <td><input type="text" name="firstName" /></td>
        </tr>
         <tr>
        <td>Last name</td>
        <td><input type="text" name="lastName" /></td>
        </tr>
        <tr>
        <td> Profile image</td>
        <td><input type="file" name="file" /></td>
        </tr>
        <tr>
        <tr>
        <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
        <td></td>
        <td><input type="submit" value="Signup"></input><input type="reset" value="Reset"></input></td>
        </tr>
        </table>
        </form>
    </body>
</html>