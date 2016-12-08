/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.scene.image.Image;

/**
 *
 * @author mosambardi
 */
public class ValueToImageBinding extends ObjectBinding<Image>{
    
    private final ObservableDoubleValue temperature;
    
    public ValueToImageBinding(ObservableDoubleValue temperature){
        this.temperature = temperature;
        super.bind(temperature); 
    }
 
     @Override
     protected Image computeValue() {
         return new Image(ImagePathChooser.chooseImage(temperature.get()));
         
     } 
}
