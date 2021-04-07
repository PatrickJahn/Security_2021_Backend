/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author Patrick
 */
public class Msg {
        

private String title;
private String msg; 
private String imgPath;
private String userName;

public Msg(String title, String msg, String imgPath, String userName){
this.title = title;
this.msg = msg;
this.imgPath = imgPath;
this.userName = userName;
  
}

public String getUsername(){
return this.userName;
}

public String getTitle(){
return this.title;
}

public String getMsg(){
return this.msg;
}

public String getImgPath(){
return this.imgPath;
}

    @Override
    public String toString() {
        return "Msg{" + "title=" + title + ", msg=" + msg + ", imgPath=" + imgPath + ", userName=" + userName + '}';
    }

  

}
