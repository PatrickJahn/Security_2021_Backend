/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import Models.Msg;
import Service.MsgService;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
// import com.login.bean.LoginBean;
// import com.login.dao.LoginDao;
@WebServlet(name = "MsgFormServlet")
@MultipartConfig (fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
 maxFileSize = 1024 * 1024 * 10, // 10MB
 maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class MsgFormServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public MsgFormServlet() {
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    
final String PATH = "/opt/tomcat/apache-tomcat-9.0.45/webapps/ROOT/Images/";
    // Sources
    String title = request.getParameter("title");
    String msgText = request.getParameter("msgText");
    Part filePart = request.getPart("file");

    
    
    // Sanetize 
       
String uniqueID = UUID.randomUUID().toString();
String fullImgPath = uniqueID + getExtension(filePart.getSubmittedFileName());
String test = checkExtension(filePart, request, response);


   if (test.equals("true")){
       
   

for(Part part : request.getParts()) {

 part.write(PATH + fullImgPath );

 }



               }else{
   fullImgPath = "";
   }
 
   if(CheckTextandTitle(title, msgText, request, response) && !test.equals("false")){
        HttpSession session = request.getSession();
    Msg msg = new Msg(title, msgText, fullImgPath, (String) session.getAttribute("User"));

  MsgService msgService = new MsgService();
  
 
    msgService.addNewMsg(msg);
    response.sendRedirect("/homeservlet");
   }
   
   
} //End of doPost()





 String getExtension(String filename){
     
       int index = filename.lastIndexOf(".");
       
       if(index < 0){ return "";}
       
       String extension = filename.substring(index);
       return extension;
       
 }
 
 String checkExtension(Part file, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
     
     if(file.getName() == null){
     return "noImg";
     }
     
     String filename = file.getSubmittedFileName();
     long fileSize = file.getSize();
    
  
      int index = filename.lastIndexOf(".");
      if (index < 0 ){
      return "noImg";
      }     
      
      if (fileSize > 10000000){
          req.setAttribute("errMessage", "File is too large");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
          return "false";
      }
     
       if (index >  30){
             req.setAttribute("errMessage", "File name too long");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
           return "false";
       }
           String extension = filename.substring(index).toLowerCase();
           
           
           
            
      if (!extension.equals(".png") && !extension.equals(".jpg")){
            req.setAttribute("errMessage", "File must be png or jpg");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
     
          return "false";
      }
      
       return "true";
       
 }
 
 
 void createMsgNoImg(){}
 void createMsgWithImg(){}
 
 Boolean CheckTextandTitle(String title,String msgText, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
     
     if (title.length() > 30){
          req.setAttribute("errMessage", "Title is too long");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
         return false;
     }
     
          
     if (msgText.length() > 300){
          req.setAttribute("errMessage", "Message text is too long");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
         return false;
     }
     return true;
 }
 
 
 
}