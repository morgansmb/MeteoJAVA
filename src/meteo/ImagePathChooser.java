/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

/**
 *
 * @author mosambardi
 */
public class ImagePathChooser {
       
    public static String chooseImage(double temp){
     if (temp < 0){
         return("/images/neige.jpg");
     }
     
     else if (temp < 20){
         return("/images/nuage.png");
     } 
     
     else{
         return("/images/soleil.jpg");
     }
    }
}
