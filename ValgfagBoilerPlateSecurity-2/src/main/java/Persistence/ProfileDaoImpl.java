/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;
import Dependencies.IMysqlConnection;
import Dependencies.MysqlConnection;
import Errors.ProfileError;
import Models.User;
import Persistence.DAO.ProfileDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Patrick
 */
public class ProfileDaoImpl implements ProfileDao{

    
    private IMysqlConnection imc;

    public ProfileDaoImpl() {
        this.imc = new MysqlConnection(); // loose coupling
    }
    
    @Override
    public User getProfile(String username) throws ProfileError {
       
        
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
      User user = new User();
      
     try  {
        con = imc.connect();
        
        // Source
        statement = con.prepareStatement("Select username, firstName, lastName, role from users Where username=?");
       statement.setString(1, username);
       
        resultSet = statement.executeQuery();
        
        if (!resultSet.next()){
            throw new ProfileError("Something went wrong");
        }
      
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        
      
        
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
       
        
        
        return user;
    } catch(ProfileError e){
          throw new ProfileError(e.getMessage());
    }catch(Exception e){
      throw new Error(e.getMessage()); // LAV OM
    }
    
    }
    
}
