/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Errors.AdminError;
import Log.Log;
import Models.DetailedUser;
import Service.AdminService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
             private Log log;   
              AdminService adminService = new AdminService();

              
              
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{    

        List<DetailedUser> users = adminService.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("deleteiduser");
        HttpSession session = request.getSession(); //Creating a session
    
                  try {
                      adminService.deleteUser(id);
                  } catch (AdminError ex) {
                        request.setAttribute("errMessage",ex.getMessage());
                        request.getRequestDispatcher("/admin").forward(request, response);
                  }
                  
                  
       log.logging("AdminActions.txt", "Admin user: "+ session.getAttribute("Admin") +" has deleted user with id: " + request.getParameter("deleteiduser"),false);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        if(request.getAttribute("errMessage") == null){
            doDelete(request,response);
            }
        
          response.sendRedirect("/admin");
    
    }
    
}
