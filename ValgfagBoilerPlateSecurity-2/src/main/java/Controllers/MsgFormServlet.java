/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;
import Models.Msg;
import Persistence.DAO.MsgDao;
import Persistence.MsgDaoImpl;
import Service.MsgService;
import java.io.IOException;
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
String path = "/Users/Patrick/desktop/img-test/";
    // Sources
    String title = request.getParameter("title");
    String msgText = request.getParameter("msgText");
    Part filePart = request.getPart("file");


    // Sanetize 
       
      
    

String fileName = filePart.getSubmittedFileName();
 for(Part part : request.getParts()) {
 part.write(path + fileName );
    System.out.println(path + fileName);
 }

    String fullImgPath = path + fileName;
    Msg msg = new Msg(title, msgText, fullImgPath);

  MsgService msgService = new MsgService();
    msgService.addNewMsg(msg);

   request.getRequestDispatcher("/user.jsp").forward(request, response);
   
} //End of doPost()
}