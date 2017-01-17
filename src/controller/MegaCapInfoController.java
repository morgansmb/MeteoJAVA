/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.MegaCapteur;
import com.sun.org.apache.bcel.internal.generic.L2D;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author syherail
 */
public class MegaCapInfoController implements Initializable {
    @FXML private Label tempLabel;
    @FXML private Label nameLabel;
    @FXML private TextField majTf;
    private MegaCapteur megaCapteur;
    
    public MegaCapInfoController(MegaCapteur mc){
        megaCapteur = mc;
        try {
            FXMLLoader simpleloader = new FXMLLoader(getClass().getResource("/gui/MegaCapInfo.fxml"));
            simpleloader.setRoot(this);
            simpleloader.setController(this);
            simpleloader.load();
        } catch (IOException ex) {
            //Logger.getLogger(ChangeAlgoCapteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameLabel.textProperty().bind(megaCapteur.nomProperty());
        tempLabel.textProperty().bind(megaCapteur.temperatureProperty().asString());
        majTf.textProperty().bindBidirectional(megaCapteur.majProperty(), new NumberStringConverter());
    }    
    
}
