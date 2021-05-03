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
    <link rel="stylesheet" href="CSS/background.css">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    </head>
    
    <body>
        
            <h1 class="display-10 d-flex justify-content-center text-white">Welcome to the greatest forum! Please login and find out what's inside.</h1>
      
        <form name="form" action="<%=request.getContextPath()%>/login" method="post">
 <div id="login">
     <br>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center text-primary">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="" method="post">
                            <h3 class="text-center text-white">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-white">Username:</label><br>
                                <input type="text" name="username" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-white">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="/Signup.jsp" class="text-white">Register here</a>
                            </div>
                        </form>
                    </div>
                            <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>

                </div>
            </div>
        </div>
    </div>
    
    </body>
</html>