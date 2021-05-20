package Controllers;
import Log.Log;
import Models.Msg;
import Service.LoginService;
import Service.MsgService;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
// import com.login.bean.LoginBean;
// import com.login.dao.LoginDao;
 
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private Log log;
public LoginServlet() {
}
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public LoginServlet(Log log) {
        this.log = log;
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String remoteAddress = request.getHeader("X-Real-IP");
       // Sources
    log.logging("LoginAttempts.txt","Request from IP: " + remoteAddress +". " + "Attempted login with " + request.getParameter("username"),false); 

    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    
    // Sanetize 
       if(!request.getParameter("username").matches("[\\w*\\-s]*")){    
            request.setAttribute("errMessage", "Username can only be letters and numbers.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
 
    LoginService loginService = new LoginService();

        
    try
    {
        String userValidate = loginService.verifyCredentials(userName, password);
       

        if(userValidate.equals("Admin_Role"))
        {                   
            log.logging("AdminLoginAttempts.txt","Request from IP: " + remoteAddress +". " + "Admin-user logged in with username: " + userName  , false);
            System.out.println("Admin's Home");
 
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("Admin", userName); //setting session attribute
            request.setAttribute("userName", userName);
 
            response.sendRedirect("/admin");
        }
        else if(userValidate.equals("Editor_Role"))
        {
            System.out.println("Editor's Home");
 
            HttpSession session = request.getSession();
            session.setAttribute("Editor", userName);
            request.setAttribute("userName", userName);
 
            
            request.getRequestDispatcher("/JSP/Editor.jsp").forward(request, response);
        }
        else if(userValidate.equals("User_Role"))
        {
            System.out.println("User's Home");
            log.logging("LoginAttempts.txt","Request from IP: " + remoteAddress +". " + userName + " has succesfully logged in" , false);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("User", userName);
          
          response.sendRedirect("/homeservlet");
         
        }
        else
        {
            log.logging("LoginAttempts.txt","Request from IP: " + remoteAddress +". " + "Unsuccesful login attempted with username: " + userName  , false);
            System.out.println("Error message = "+ userValidate);
            request.setAttribute("errMessage", userValidate);
          
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
    catch (IOException e1)
    {
        e1.printStackTrace();
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
} //End of doPost()



}