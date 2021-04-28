/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Errors.AdminError;
import Models.DetailedUser;
import Models.User;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public interface IAdminService {
    public List<DetailedUser> getAllUsers();
    public String deleteUser(String id)  throws AdminError;
    public String deletePost(String id)  throws AdminError;
    public void createAdmin(User user);
    
}
