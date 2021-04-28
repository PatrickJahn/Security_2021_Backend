package Persistence.DAO;

import Models.User;

public interface SignupDao {
      public String isUsernameTaken(String username);
      public String createUser(User user);
      public String createAdminUser(User user);
}
