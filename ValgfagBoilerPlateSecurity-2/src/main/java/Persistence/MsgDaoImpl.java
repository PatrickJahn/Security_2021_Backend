/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistence;
import Dependencies.IMysqlConnection;
import Dependencies.MysqlConnection;
import Models.Msg;
import Persistence.DAO.MsgDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Patrick
 */
public class MsgDaoImpl implements MsgDao  {

  private IMysqlConnection imc;

    public MsgDaoImpl() {
        this.imc = new MysqlConnection(); // loose coupling
    }

  public String addNewMessage(Msg msgObject){
     String title = msgObject.getTitle();
    String msg = msgObject.getMsg();
       String imgPath = msgObject.getImgPath();
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
 
 
    try
    {
        con = imc.connect();
        
        // Source
        
        statement = con.prepareStatement("Insert into posts (title, msg, imgPath) values (?,?,?)", statement.RETURN_GENERATED_KEYS);
        statement.setString(1, title);
        statement.setString(2, msg);
        statement.setString(3, imgPath);
        statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
      
        int postid = -1;
        
            if (resultSet.first()) {
               postid = (resultSet.getInt(1));
            }
        
        statement = con.prepareStatement("Insert into usersPosts (userId, postId) values ((Select id from users where userName = ?),?)");
        statement.setString(1, msgObject.getUsername() );
        statement.setInt(2, postid);
        statement.executeUpdate();
        return "Success";
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
    }


  @Override
    public List<Msg> getAllMsgs(){
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<Msg> messages = new ArrayList();
 
    try
    {
        con = imc.connect();
        
        // Source
        statement = con.prepareStatement("SELECT\n" +
"  posts.id,\n" +
"  posts.title,\n" +
"  posts.msg,\n" +
"  posts.imgPath,\n" +
"  users.userName\n" +
"FROM posts\n" +
"JOIN usersPosts\n" +
"  ON posts.id = usersPosts.postId\n" +
"JOIN users\n" +
"  ON users.id = usersPosts.userId;");
        
       resultSet = statement.executeQuery();
       
       // DDOST sikring her please
       
       while(resultSet.next()){

           Msg message = new Msg(resultSet.getString("title"),resultSet.getString("msg"),resultSet.getString("imgPath"), resultSet.getString("userName"));
            messages.add(message);
       
       }
 
       return messages;
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return messages;
    }

}
