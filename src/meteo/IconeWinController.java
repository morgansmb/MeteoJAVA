/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author mosambardi
 */
public class IconeWinController extends Fenetre {

    
    @FXML private ImageView ivIcone;
    
    public IconeWinController(Capteur capteur){
        super(capteur);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ivIcone.imageProperty().bind(new ValueToImageBinding(capteur.temperatureProperty()));
        System.out.println(capteur.getTemperature());
        capteur.changeTemperature();
        System.out.println(capteur.getTemperature());       
    }

    @Override
    public void update(Observable obj, Object o) {
       Double temp = (Double) o;
       ivIcone.setImage(new Image(ImagePathChooser.chooseImage(temp)));
    }
 
    
}
