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
    <title>New post</title>
    <style>
textarea {
  resize: none;
 
}
</style>
    </head>
    <body>
        
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
        
      
    </body>
</html>