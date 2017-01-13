/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author syherail
 */
public class SimpleCapInfoController implements Initializable {

    @FXML private Label nameLabel;
    @FXML private Label tempLabel;
    @FXML private TextField majTextField;
    @FXML private GridPane gridSimpleCapInfo;
    private ChangeAlgoCapteurController custom;
    
    
    public SimpleCapInfoController(){
        custom= new ChangeAlgoCapteurController();
    }
    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gridSimpleCapInfo.add(custom, 1, 3);
    }    
    
    
    
}
