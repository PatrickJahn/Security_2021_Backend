package Service;

import Errors.SignupError;
import Models.User;
import javax.servlet.http.HttpServletRequest;

public interface ISignupService {
    public String verifyCredentials(String username, String password) throws SignupError;
    public String encryptPassword(String password);
    public String createUser(String username, String password, String firstName, String lastName) throws SignupError;
    public String verifyNames(String firstName, String lastName) throws SignupError;
   
}
