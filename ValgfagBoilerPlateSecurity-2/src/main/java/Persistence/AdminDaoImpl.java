/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Dependencies.IMysqlConnection;
import Dependencies.MysqlConnection;
import Models.DetailedUser;
import Models.Msg;
import Models.User;
import Persistence.DAO.AdminDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class AdminDaoImpl implements AdminDao {
  private IMysqlConnection imc;

    public AdminDaoImpl() {
        this.imc = new MysqlConnection(); // loose coupling
    }

    @Override
    public List<DetailedUser> getAllUsers() {
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<DetailedUser> users = new ArrayList();
 
    try
    {
        con = imc.connect();
        
        // Source
        statement = con.prepareStatement("select * from users");
       resultSet = statement.executeQuery();
       
       // DDOST sikring her please
       
       while(resultSet.next()){
           DetailedUser user = new DetailedUser();
           user.setId(resultSet.getInt("id"));
           user.setFirstName(resultSet.getString("firstName"));
           user.setLastName(resultSet.getString("lastName"));
           user.setRole(resultSet.getString("role"));
           user.setUsername(resultSet.getString("username"));
           users.add(user);
      
       }
 
       return users;
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return users;
        
    
    }

    @Override
    public String deleteUser(int id) {
      try {
          Connection con = null;
          PreparedStatement statement = null;
          ResultSet resultSet = null;
          con = imc.connect();
          String response = "User was deleted";
          
          //1st
          statement = con.prepareStatement("delete from users where Id=? ");
          statement.setInt(1, id);
          statement.executeUpdate();
          //2nd
          statement = con.prepareStatement("select postId from usersPosts where userId=? ");
          statement.setInt(1, id);
          resultSet = statement.executeQuery();
          //list -> 1 element ud ad gangen?
          while(resultSet.next()){
              statement = con.prepareStatement("delete from posts where id=? ");
              statement.setInt(1, resultSet.getInt("postId"));
              statement.executeUpdate();
          }
          statement = con.prepareStatement("delete from usersPosts where userId=? ");
          statement.setInt(1, id);
          statement.executeUpdate();
          
          
          return response;
      } catch (Exception e) {
          e.printStackTrace();
      }
    return "Error";
    }

    @Override
    public String deletePost(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createAdmin(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
