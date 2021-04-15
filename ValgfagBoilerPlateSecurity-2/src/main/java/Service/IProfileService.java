/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Errors.ProfileError;
import Models.User;

/**
 *
 * @author Patrick
 */
public interface IProfileService {
    public User getProfile(String username) throws ProfileError;
    public void sanetise(String username) throws ProfileError;
}
