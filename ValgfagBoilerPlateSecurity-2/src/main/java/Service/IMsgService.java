package Service;

import Models.Msg;
import java.util.List;

public interface IMsgService {


    public String addNewMsg(Msg msg);
     public List<Msg> getAllMessages();
       public List<Msg> getAllMessagesByUser(int id);
    
    
}
