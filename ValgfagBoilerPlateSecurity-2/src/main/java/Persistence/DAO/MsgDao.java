/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistence.DAO;
import Models.Msg; 
import java.util.List;

/**
 *
 * @author Patrick
 */
public interface MsgDao {

    public String addNewMessage(Msg msg);
    public List<Msg> getAllMsgs();
    public List<Msg> getAllMsgsByUser(int id);

}
