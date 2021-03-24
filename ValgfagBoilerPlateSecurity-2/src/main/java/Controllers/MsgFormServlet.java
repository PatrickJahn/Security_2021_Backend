/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import Models.User;
import Persistence.DAO.LoginDao;
import Persistence.LoginDaoImpl;
import Service.LoginService;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
// import com.login.bean.LoginBean;
// import com.login.dao.LoginDao;
 
public class MsgFormServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public MsgFormServlet() {
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    // Sources
    String title = request.getParameter("title");
    String msgText = request.getParameter("msgText");
    Part filePart = request.getPart("file");
    
    // Sanetize 
      
        System.out.println(title);
     System.out.println(msgText);
  System.out.println(filePart);
 
    try
    {
       
    }
    catch (Exception e1)
    {
        e1.printStackTrace();
    }
   
} //End of doPost()
}