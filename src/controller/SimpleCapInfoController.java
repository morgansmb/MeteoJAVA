/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.SimpleCapteur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author syherail
 */
public class SimpleCapInfoController extends GridPane implements Initializable {

    private SimpleCapteur simpleCap;
    @FXML private Label nameLabel;
    @FXML private Label tempLabel;
    @FXML private TextField majTextField;
    @FXML private GridPane mainGrid;
    
    
    public SimpleCapInfoController(SimpleCapteur sc){
        simpleCap = sc;
        try {
            FXMLLoader simpleloader = new FXMLLoader(getClass().getResource("/gui/SimpleCapInfo.fxml"));
            simpleloader.setRoot(this);
            simpleloader.setController(this);
            simpleloader.load();
        } catch (IOException ex) {
            //Logger.getLogger(ChangeAlgoCapteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.add(new ChangeAlgoCapteurController(simpleCap), 1, 3);
        this.add(new AffichageCapteurController(simpleCap), 1, 4);
        nameLabel.textProperty().bind(simpleCap.nomProperty());
        tempLabel.textProperty().bind(simpleCap.temperatureProperty().asString());
        majTextField.textProperty().bindBidirectional(simpleCap.majProperty(), new NumberStringConverter());   
    }     
}
