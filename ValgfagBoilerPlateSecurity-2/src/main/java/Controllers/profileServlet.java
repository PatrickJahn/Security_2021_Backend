/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Errors.ProfileError;
import Models.Msg;
import Models.User;
import Service.MsgService;
import Service.ProfileService;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patrick
 */
public class profileServlet extends HttpServlet {

     ProfileService profileService = new ProfileService();
     MsgService msgService = new MsgService();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
           String username = request.getParameter("username");
            
           try {
          
               profileService.sanetise(username);
                    
               User user = profileService.getProfile(username);
               
               request.setAttribute("clickedUser", user);
              
           List<Msg> messages = msgService.getAllMessagesByUser(user.getId());
           Collections.reverse(messages);
           request.setAttribute("messages", messages);
           
        
               
           request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response); 
           
           } catch (ProfileError err) {
               
            request.setAttribute("errMessage", err.getMessage());
            request.getRequestDispatcher("/homeservlet").forward(request, response); 
           
           }
    }

   
}
