package Service;

import Models.User;
import Persistence.DAO.LoginDao;
import Persistence.DAO.SignupDao;
import Persistence.LoginDaoImpl;
import Persistence.SignupImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

public class SignupService implements ISignupService {

    private SignupDao signupImpl;

    public SignupService() {
        signupImpl = new SignupImpl();
    }

    @Override
    public String verifyCredentials(String username, String password) {
       
        // Sanetize 
       if(!username.matches("[\\w*\\-s]*") || username.length() < 1){    
          
            return "Username can only contain letters and numbers";
        }
       if(password.length() < 8){
          return "Password must be over 8 characters."; 
       }
       
       
      if (signupImpl.isUsernameTaken(username).equals("User already exists")){
          return "User already exists";
      }
       
       User user = new User();
       user.setUsername(username);
       
       String hashedPass = encryptPassword(password);
       user.setPassword(hashedPass);
       
       return createUser(user);
    }

    @Override
    public String encryptPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt) ;
    }

    @Override
    public String createUser(User user) {
              return signupImpl.createUser(user);
 
    }

    
    
}
