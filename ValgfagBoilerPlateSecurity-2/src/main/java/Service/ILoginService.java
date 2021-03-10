package Service;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {
    public String verifyCredentials(String username, String password);
    public boolean logout(HttpServletRequest request);
    public boolean isLoggedin();
}
