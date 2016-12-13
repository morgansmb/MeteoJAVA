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
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author mosambardi
 */
public class ThermostatWinController extends Fenetre{

    @FXML private Spinner<Double> tempSpin;
    
    
    
    
    public ThermostatWinController(Capteur capteur){
        super(capteur);
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempSpin.setValueFactory(new DoubleSpinnerValueFactory(-10,40,0,1));
        tempSpin.getValueFactory().valueProperty().bindBidirectional(capteur.getObjProp());
        capteur.changeTemperature();
    }

    @Override
    public void update(Observable obj, Object o) {
        Double temp = (Double) o;
        tempSpin.setValueFactory(new DoubleSpinnerValueFactory(-10, 40, temp, 1));
    }
    
}
