/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Errors.AdminError;
import Models.DetailedUser;
import Models.User;
import Persistence.AdminDaoImpl;
import Persistence.DAO.AdminDao;
import Persistence.DAO.MsgDao;
import Persistence.MsgDaoImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class AdminService implements IAdminService {

     private AdminDao ldi;

    public AdminService() {
        ldi = new AdminDaoImpl();
    }


    
    
    @Override
    public List<DetailedUser> getAllUsers() {
  
        return ldi.getAllUsers();
    }

    @Override
    public String deleteUser(String id) throws AdminError{
         try {
             sanitazationDeleteUser(id);
         } catch (Exception ex) {
             throw new AdminError("Not a correctly formatted number");
             
             
         }
        
        return ldi.deleteUser(Integer.valueOf(id));
   
    }
    private Boolean sanitazationDeleteUser(String id) throws AdminError{
            
        Integer.valueOf(id);
        
        return true;
    }
    
    
    
    
    
    @Override
    public String deletePost(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createAdmin(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
