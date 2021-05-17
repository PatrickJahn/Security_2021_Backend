/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Errors.SignupError;
import Models.User;
import Service.LoginService;
import Service.SignupService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Patrick
 */
@WebServlet(name = "signupServlet")
@MultipartConfig (fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
 maxFileSize = 1024 * 1024 * 10, // 10MB
 maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class SignupServlet extends HttpServlet {

   
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    
    final String PATH = "/opt/tomcat/apache-tomcat-9.0.45/webapps/ROOT/ProfileImages/";


    // Sources
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    Part filePart = request.getPart("file");

       if (checkExtension(filePart, request, response)){
       
   
String uniqueID = UUID.randomUUID().toString();
String fullImgPath = uniqueID + getExtension(filePart.getSubmittedFileName());
      


 for(Part part : request.getParts()) {
 part.write(PATH + fullImgPath );

 }
    
  
    SignupService signupService = new SignupService();
 
    try
    {
        
            signupService.createUser(userName, password, firstName, lastName, fullImgPath);
       
       
        request.getRequestDispatcher("/login").forward(request, response);
       
    }
    catch (SignupError e)
    {
       request.setAttribute("errMessage",e.getMessage());
       request.getRequestDispatcher("/Signup.jsp").forward(request, response);
        
    }

       
       } //End of doPost()

} 

 String getExtension(String filename){
     
       int index = filename.lastIndexOf(".");
       
       String extension = filename.substring(index);
       return extension;
       
 }



Boolean checkExtension(Part file, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
     String filename = file.getSubmittedFileName();
     long fileSize = file.getSize();
  
      int index = filename.lastIndexOf(".");
      
      if (index < 0){
           req.setAttribute("errMessage", "Please select a image");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
          return false;
      }
      
      if (fileSize > 10000000){
          req.setAttribute("errMessage", "File is too large");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
          return false;
      }
     
       if (index >  30){
             req.setAttribute("errMessage", "File name too long");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
           return false;
       }
           String extension = filename.substring(index);
           System.out.println(extension);
           
           
            
      if (!extension.equals(".png") && !extension.equals(".jpg")){
            req.setAttribute("errMessage", "File must be png or jpg");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
     
          return false;
      }
      
       return true;
       
 }
 }