/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;
import capteurs.Capteur;
import capteurs.SimpleCapteur;

/**
 * FXML Controller class
 *
 * @author mosambardi
 */
public class ThermostatWinController extends Fenetre{

    @FXML private Spinner<Double> tempSpin;
    Double min,max;
    
    public ThermostatWinController(Capteur capteur){
        super(capteur);
        SimpleCapteur capt = (SimpleCapteur)getCapteur();
        min = Double.valueOf(capt.getMin());
        max = Double.valueOf(capt.getMax());
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tempSpin.setValueFactory(new DoubleSpinnerValueFactory(min,max));
        tempSpin.getValueFactory().valueProperty().bind(getCapteur().getObjTempProp());
    }

    @Override
    public void update(Observable obj, Object o) {
        Double temp = (Double) o;
        tempSpin.setValueFactory(new DoubleSpinnerValueFactory(min, max, temp));
    }
    
}
