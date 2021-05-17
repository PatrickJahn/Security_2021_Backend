package Dependencies;

import java.sql.Connection;
import java.sql.DriverManager;
public class MysqlConnection implements IMysqlConnection {
     Connection con = null;
    @Override
    public Connection connect() {
        String url = System.getenv("Con_String");
        String userName = System.getenv("Con_user");
        String pass = System.getenv("Con_pw");
        
        try {
            
                Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, pass);
            
        } catch(Exception e){
             System.out.println(e);
            
        }
        return con;
    }

    @Override
    public boolean disconnect() {
        return false;
    }
}
