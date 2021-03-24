/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Service;
import Models.Msg;
import Persistence.MsgDaoImpl;
import Persistence.DAO.MsgDao;
/**
 *
 * @author Patrick
 */
public class MsgService implements IMsgService {

    private MsgDao ldi;

    public MsgService() {
        ldi = new MsgDaoImpl();
    }


 public String addNewMsg(Msg msg) {
    return ldi.addNewMessage(msg);

}

}
