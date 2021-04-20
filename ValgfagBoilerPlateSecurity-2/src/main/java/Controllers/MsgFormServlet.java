/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import Models.Msg;
import Service.MsgService;
import java.io.IOException;
import java.util.UUID;
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
    
final String PATH = "C:\\Users\\Benjamin\\Desktop\\Security\\Security_2021_Backend\\ValgfagBoilerPlateSecurity-2\\src\\main\\webapp\\Images\\";
    // Sources
    String title = request.getParameter("title");
    String msgText = request.getParameter("msgText");
    Part filePart = request.getPart("file");


    // Sanetize 
    
    
   if (checkExtension(filePart, request, response) && 
       CheckTextandTitle(title, msgText, request, response)){
       
   
String uniqueID = UUID.randomUUID().toString();
String fullImgPath = uniqueID + getExtension(filePart.getSubmittedFileName());
      


 for(Part part : request.getParts()) {
 part.write(PATH + fullImgPath );

 }
  HttpSession session = request.getSession();
    Msg msg = new Msg(title, msgText, fullImgPath, (String) session.getAttribute("User"));

  MsgService msgService = new MsgService();
  
 
    msgService.addNewMsg(msg);
    

            
   response.sendRedirect("/homeservlet");
   }
 
} //End of doPost()


 String getExtension(String filename){
     
       int index = filename.lastIndexOf(".");
       
       String extension = filename.substring(index);
       return extension;
       
 }
 
 Boolean checkExtension(Part file, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
     String filename = file.getSubmittedFileName();
     long fileSize = file.getSize();
  
      int index = filename.lastIndexOf(".");
      
      if (index < 0){
           req.setAttribute("errMessage", "Please select a image");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
          return false;
      }
      
      if (fileSize > 10000000){
          req.setAttribute("errMessage", "File is too large");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
          return false;
      }
     
       if (index >  30){
             req.setAttribute("errMessage", "File name too long");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
           return false;
       }
           String extension = filename.substring(index);
           System.out.println(extension);
           
           
            
      if (!extension.equals(".png") && !extension.equals(".jpg")){
            req.setAttribute("errMessage", "File must be png or jpg");
          req.getRequestDispatcher("/msgForm.jsp").forward(req, res);
     
          return false;
      }
      
       return true;
       
 }
 
 
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