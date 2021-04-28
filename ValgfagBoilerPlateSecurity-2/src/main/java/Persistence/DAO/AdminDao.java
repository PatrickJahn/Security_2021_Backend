/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.DAO;

import Models.DetailedUser;
import Models.User;

import java.util.List;

/**
 *
 * @author Benjamin
 */
public interface AdminDao{
    
    public List<DetailedUser> getAllUsers();
    public String deleteUser(int id);
    public String deletePost(int id);
    public void createAdmin(User user);
    
}
