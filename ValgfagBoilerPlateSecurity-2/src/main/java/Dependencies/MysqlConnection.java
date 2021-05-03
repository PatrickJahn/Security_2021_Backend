package Dependencies;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection implements IMysqlConnection {
     Connection con = null;
    @Override
    public Connection connect() {
       
        String url = "jdbc:mysql://localhost:3306/Security";
        String userName = "dev";
        String pass = "ax2";
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
