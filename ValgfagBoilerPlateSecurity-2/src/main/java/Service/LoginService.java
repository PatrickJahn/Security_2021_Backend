package Service;

import Models.User;
import Persistence.DAO.LoginDao;
import Persistence.LoginDaoImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginService implements ILoginService {

    private LoginDao ldi;

    public LoginService() {
        ldi = new LoginDaoImpl();
    }

    @Override
    public String verifyCredentials(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return ldi.verifyCredentials(user);
    }

    @Override
    public boolean logout(HttpServletRequest request) {
         HttpSession session = request.getSession(false); //Fetch session object
 
        if(session!=null) //If session is not null
        {
            session.invalidate(); //removes all session attributes bound to the session  
            System.out.println("Logged out");
            
            return true;
        }
           return false;
        
    }

    @Override
    public boolean isLoggedin() {
        return false;
    }
}
