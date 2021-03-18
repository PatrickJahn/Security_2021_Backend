/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
import Service.LoginService;
import Service.SignupService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Patrick
 */
public class SignupServlet extends HttpServlet {

   
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    // Sources
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    
  
    SignupService signupService = new SignupService();
 
    try
    {
        
      
       String msg = signupService.verifyCredentials(userName, password);
       
       
       request.setAttribute("errMessage",msg);
       request.getRequestDispatcher("/Signup.jsp").forward(request, response);
        
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
} //End of doPost()
}