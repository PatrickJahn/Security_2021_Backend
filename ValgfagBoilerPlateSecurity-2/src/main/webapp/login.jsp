<%-- 
    Document   : login
    Created on : Mar 10, 2021, 12:09:20 PM
    Author     : Patrick
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    </head>
    
    <body>
        
        <h1 class="display-10 d-flex justify-content-center">Welcome to the greatest forum! Please login in and find out what's inside.</h1>
        <form name="form" action="<%=request.getContextPath()%>/login" method="post">
 
        <table align="center">
        <tr>
        <td>Username</td>
        <td><input type="text" name="username" /></td>
        </tr>
        <tr>
        <td>Password</td>
        <td><input type="password" name="password" /></td>
        </tr>
        <tr>
        <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
        <td></td>
        <td><input type="submit" value="Login"></input><input type="reset" value="Reset"></input></td>
        </tr>
        </table>
        </form>
        <a href="<%=request.getContextPath()%>/Signup.jsp">Signup here</a>
    </body>
</html>