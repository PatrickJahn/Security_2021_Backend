package Persistence.DAO;

import Models.User;

public interface LoginDao {
    public String verifyCredentials(User user);
}
