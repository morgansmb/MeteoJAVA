/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.scene.image.Image;

/**
 *
 * @author mosambardi
 */
public class ValueToImageBinding extends ObjectBinding<Image>{
    
    private final ObservableDoubleValue temperature;
    private final ImagePathChooser imgChoose;
    
    public ValueToImageBinding(ObservableDoubleValue temperature){
        this.temperature = temperature;
        imgChoose = new ImagePathChooser(temperature.get());
        super.bind(temperature);
        
        
    }
 
     @Override
     protected Image computeValue() {
         imgChoose.chooseImage();
         return new Image(imgChoose.getPath());
         
     }
     //peut étre implémenter l'interface chooseImage plutot que de créer un image chooser ?
     
    
}
