package Persistence;

import Dependencies.IMysqlConnection;
import Dependencies.MysqlConnection;
import Models.User;
import Persistence.DAO.LoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImpl implements LoginDao {

    private IMysqlConnection imc;

    public LoginDaoImpl() {
        this.imc = new MysqlConnection(); // loose coupling
    }

    @Override
    public String verifyCredentials(User user) {
       String userName = user.getUsername();
    String password = user.getPassword();
    
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String roleDB = "";
 
    try
    {
        con = imc.connect();
        statement = con.prepareStatement("Select username, password, role from users Where username=?");
       statement.setString(1, userName);
        resultSet = statement.executeQuery();
 
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            roleDB = resultSet.getString("role");
 
            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
            return "Admin_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
            return "Editor_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
            return "User_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
    }


}
