package Service;

import Models.User;
import javax.servlet.http.HttpServletRequest;

public interface ISignupService {
    public String verifyCredentials(String username, String password);
    public String encryptPassword(String password);
    public String createUser(User user);
   
}
