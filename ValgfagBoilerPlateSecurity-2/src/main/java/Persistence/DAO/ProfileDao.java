/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.DAO;

import Errors.ProfileError;
import Models.User;

/**
 *
 * @author Patrick
 */
public interface ProfileDao {
    
    public User getProfile(String username) throws ProfileError;
    
}
