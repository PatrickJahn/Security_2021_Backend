/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Errors.ProfileError;
import Errors.SignupError;
import Models.User;
import Persistence.DAO.ProfileDao;
import Persistence.ProfileDaoImpl;

/**
 *
 * @author Patrick
 */
public class ProfileService implements IProfileService {

    
       private ProfileDao ldi;

    public ProfileService() {
        ldi = new ProfileDaoImpl();
    }
    @Override
    public User getProfile(String username) throws ProfileError {
          return ldi.getProfile(username);
    }

    @Override
    public void sanetise(String username) throws ProfileError {
         if(!username.matches("[\\w*\\-s]*") || username.length() < 1){    
          
           throw new ProfileError("Error retriving user");
     
        }

    }
    
    
    
}
