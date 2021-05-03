<%-- 
    Document   : login
    Created on : Mar 10, 2021, 12:09:20 PM
    Author     : Patrick
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Signup</title>
        <link rel="stylesheet" href="CSS/background.css">
    </head>
    <style>
        .center {
            top: 50%; /* IMPORTANT */
        left: 50%; /* IMPORTANT */
        display: block;
        position: absolute;
        background: url(images/background.png) no-repeat center center;
        width: 750px;
        height: 417px;

        margin-top: -208.5px; /* HALF OF THE HEIGHT */
        margin-left: -375px; /* HALF OF THE WIDTH */
                  text-shadow: 2px 2px #000000;



}


    </style>
    <body>
        <div class="center">
        <h1 style="color: white">Signup </h1>
        <form enctype="multipart/form-data" name="form" action="<%=request.getContextPath()%>/Signup" method="post">
 
        <table class:"center">
        <tr>
        <td style="color: white">Username</td>
        <td><input type="text" color:"white" name="username" /></td>
        </tr>
         <tr>
        <td style="color: white">Password</td>
        <td><input type="text" name="password" /></td>
        </tr>
        <tr>
        <td style="color: white">First name</td>
        <td><input type="text" name="firstName" /></td>
        </tr>
         <tr>
        <td style="color: white">Last name</td>
        <td style="color: white"><input type="text" name="lastName" /></td>
        </tr>
        <tr>
        <td style="color: white"> Profile image</td>
        <td><input type="file" style="color: white" name="file" /></td>
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
</div>
        </body>
</html>