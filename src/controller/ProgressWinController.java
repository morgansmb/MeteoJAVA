/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.Capteur;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 *
 * @author nibilly
 */
public class ProgressWinController extends Fenetre{

    @FXML private ProgressBar tempProgress;
    @FXML private Label labelMin;
    @FXML private Label labelMax;
    
    
    public ProgressWinController(Capteur capteur){
        super(capteur);
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Capteur capteur = getCapteur();
        labelMin.textProperty().bind(capteur.minProperty());
        labelMax.textProperty().bind(capteur.maxProperty());
        tempProgress.progressProperty().bind(capteur.pourcentProperty());
    }

    @Override
    public void update(Observable obj, Object o) {
        Double temp = (Double) o;
        tempProgress.progressProperty().set(temp);
    }
    
}
