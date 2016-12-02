/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mosambardi
 */
public class ImagePathChooser {
    //est-ce vraiment une classe ?
    private double temp;
    
    private StringProperty path = new SimpleStringProperty();
    
    public StringProperty pathProperty(){
        return path;
    }
    
    public String getPath(){
        return path.get();
    }
    
    private void setPath(String path){
        this.path.set(path);
    }

    
    
    public ImagePathChooser (double temp){
        this.temp = temp;
    }
    
    
    public void chooseImage(){
     if (temp < 0){
         this.path.set("/images/neige.jpg");
     }
     
     else if (temp < 20){
         this.path.set("/images/nuage.png");
     } 
     
     else{
         this.path.set("/images/soleil.jpg");
     }
    }
}
