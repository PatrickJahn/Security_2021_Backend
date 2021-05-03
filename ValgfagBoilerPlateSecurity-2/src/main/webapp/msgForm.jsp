<%-- 
    Document   : login
    Created on : Mar 10, 2021, 12:09:20 PM
    Author     : Patrick
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("User") == null) )
{
%>
<jsp:forward page="/"></jsp:forward>
<%} %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="CSS/background.css">
        <link rel="stylesheet" href="CSS/Navbar.css">


    <title>New post</title>
    <style>
textarea {
  resize: none;
 
}
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
        color: white;
          text-shadow: 2px 2px #000000;


}

    


</style>
    </head>
    <body>
            
    <ul>
        <li><a href="<%=request.getContextPath()%>/profileServlet?username=<%=session.getAttribute("User")%>">My profile</a></li>
          <li><a href="<%=request.getContextPath()%>/homeservlet">Forum</a></li>
        <li class="active"><a href="<%=request.getContextPath()%>/msgForm.jsp">New post</a></li>
        <li class="logout"><a href="<%=request.getContextPath()%>/logout">Log out</a></li>
   <li class="logouttxt" ><a>User (<%=session.getAttribute("User") %>) </a></li>
</ul>
        <div class="center">
        <h1>New message goes here </h1>
        <form enctype="multipart/form-data" name="form" action="<%=request.getContextPath()%>/msgForm" method="post">
 
        <table align="center">
        <tr>
        <td>Title</td>
        <td><input type="text"  name="title" required /></td>
        </tr>
        <tr>
        <td>Message text</td>
        <td><textarea type="text" name="msgText" maxlength="100" required placeholder="Msg text max 100 characters"rows="8" cols="50" ></textarea></td>
        </tr>
        <tr>
        <td>Attach image</td>
        <td><input type="file" name="file" /></td>
        </tr>
        <tr>
        <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
        <td></td>
        <td><input type="submit" value="Postmsg"></td>
        </tr>
        </table>
        </form>
        
        </div>
    </body>
</html>