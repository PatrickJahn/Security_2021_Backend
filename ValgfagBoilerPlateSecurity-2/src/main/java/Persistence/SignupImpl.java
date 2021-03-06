package Persistence;

import Dependencies.IMysqlConnection;
import Dependencies.MysqlConnection;
import Models.User;
import Persistence.DAO.LoginDao;
import Persistence.DAO.SignupDao;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SignupImpl implements SignupDao {

    private IMysqlConnection imc;

    public SignupImpl() {
        this.imc = new MysqlConnection(); // loose coupling
    }

    @Override
    public String createUser(User user) {
    
    String userName = user.getUsername();
    String password = user.getPassword();
    
    String firstName = user.getFirstName();
    String lastName = user.getLastName();
    String imgPath = user.getImgPath();
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
 
    String roleDB = "User";
 
    try
    {
        con = imc.connect();
        
        // Source
        statement = con.prepareStatement("INSERT INTO users (username, password, firstName, lastName, imgPath, role) values (?, ?, ?, ?, ?, ?)");
       statement.setString(1, userName);
       statement.setString(2, password);
       statement.setString(3, firstName);
       statement.setString(4, lastName);
       statement.setString(5, imgPath);
       statement.setString(6, roleDB);
       
       statement.executeUpdate();
 
                
           
           
 
           
    }
    catch(SQLException e)
    {
        e.printStackTrace();
        return "Something went wrong";
    }
    return "New user was added";
    }

    
    @Override
    public String isUsernameTaken(String username) {
         
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
 
    String roleDB = "User";
 
    try
    {
        con = imc.connect();
        
        // Source
        statement = con.prepareStatement("Select userName from users where exists (SELECT userName FROM users WHERE username = ?) " );
       statement.setString(1, username);
       
       
        resultSet = statement.executeQuery();
             
        if (resultSet.next()) {
                    return "User already exists";
                  } else {
                    return "no user";
                }
    
    }
    catch(SQLException e)
    {
        e.printStackTrace();
        return "Something went wrong";
    }
  
    }

    @Override
    public String createAdminUser(User user) {
      
    String userName = user.getUsername();
    String password = user.getPassword();
    
    String firstName = user.getFirstName();
    String lastName = user.getLastName();
    String imgPath = user.getImgPath();
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
 
    String roleDB = "Admin";
 
    try
    {
        con = imc.connect();
        
        // Source
        statement = con.prepareStatement("INSERT INTO users (username, password, firstName, lastName, imgPath, role) values (?, ?, ?, ?, ?, ?)");
       statement.setString(1, userName);
       statement.setString(2, password);
       statement.setString(3, firstName);
       statement.setString(4, lastName);
       statement.setString(5, imgPath);
       statement.setString(6, roleDB);
       
       statement.executeUpdate();
 
                
           
           
 
           
    }
    catch(SQLException e)
    {
        e.printStackTrace();
        return "Something went wrong";
    }
    return "New Admin-user was added";
    }
}
        
            
    

   


