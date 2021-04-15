package Service;

import Errors.SignupError;
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
    public String verifyCredentials(String username, String password) throws SignupError {
       
        // Sanetize 
       if(!username.matches("[\\w*\\-s]*") || username.length() < 1){    
          
           throw new SignupError("Username can only contain letters and numbers");
     
        }
       if(password.length() < 8){
           throw new SignupError("Password must be over 8 characters.");

       }
       
       
      if (signupImpl.isUsernameTaken(username).equals("User already exists")){
            throw new SignupError("Something went wrong");
      }
       
       return "true";
    }

    @Override
    public String encryptPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt) ;
    }

    @Override
    public String createUser(String username, String password, String firstName, String lastName) throws SignupError{
        
        verifyNames(firstName, lastName);
        verifyCredentials(username, password);
        
      User user = new User();
          user.setFirstName(firstName);
          user.setLastName(lastName);
          user.setUsername(username);
      
          
          String hashedPass = encryptPassword(password);
          user.setPassword(hashedPass);
        
        return signupImpl.createUser(user);
 
    }

    
    @Override
    public String verifyNames(String firstName, String lastName) throws SignupError{
        
       if(!firstName.matches("^[a-zA-Z]*$") || firstName.length() < 1){    
           throw new SignupError("First name can only contain letters");
        }
       
        if(!lastName.matches("^[a-zA-Z]*$") || lastName.length() < 1){    
           throw new SignupError("Last name can only contain letters");
        }
        
        return "true";

    }

    
    
}
