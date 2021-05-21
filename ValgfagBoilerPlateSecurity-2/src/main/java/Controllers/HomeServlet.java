/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Msg;
import Service.MsgService;
import java.io.IOException;
import java.io.PrintWriter;
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
public class HomeServlet extends HttpServlet {

          MsgService msgService = new MsgService();
          
          
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
          List<Msg> messages = msgService.getAllMessages();
          Collections.reverse(messages);
          request.setAttribute("messages", messages);
         
         request.getRequestDispatcher("/user.jsp").forward(request, response);

    }

   
}
