package Controllers;
import Models.User;
import Persistence.DAO.LoginDao;
import Persistence.LoginDaoImpl;
import Service.LoginService;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
// import com.login.bean.LoginBean;
// import com.login.dao.LoginDao;
 
public class LoginServlet_1 extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public LoginServlet_1() {
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    // Sources
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
            System.out.println("Admin's Home");
 
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("Admin", userName); //setting session attribute
            request.setAttribute("userName", userName);
 
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
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
 
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("User", userName);
            request.setAttribute("userName", userName);
 
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        }
        else
        {
            System.out.println("Error message = "+ userValidate);
            request.setAttribute("errMessage", userValidate);
 
            request.getRequestDispatcher("/login.jsp").forward(request, response);
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