package Log;


import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin
 */
public class Log {
    public Logger logger;
    FileHandler fileHandler;

    public Log(String fileName) throws IOException, SecurityException {
    final String PATH = "/opt/tomcat/apache-tomcat-9.0.45/webapps/ROOT/Logs/";

        File f = new File(PATH + fileName);
        if(!f.exists()){
            f.createNewFile();
        }
       if(fileHandler == null){ 
       fileHandler = new FileHandler(PATH + fileName, true);
       }
       logger = Logger.getLogger("logger");
       logger.addHandler(fileHandler);
       SimpleFormatter formatter = new SimpleFormatter();
       fileHandler.setFormatter(formatter);
    }
    public void closeFileHandler(){
        fileHandler.close();
    }
    
    public static void logging (String fileName, String msg, boolean warningTrueInfoFalse) {
try {
     Log log = new Log(fileName);       
     log.logger.setLevel(Level.ALL);
     if(warningTrueInfoFalse){
       log.logger.warning(msg);
       log.closeFileHandler();
     }else{
          log.logger.info(msg);
          log.closeFileHandler();
     }
     
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
