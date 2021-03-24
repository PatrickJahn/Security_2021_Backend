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

public Msg(String title, String msg, String imgPath){
this.title = title;
this.msg = msg;
this.imgPath = imgPath;
  
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

}
