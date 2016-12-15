/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mosambardi
 */
public class MainMenuWinController implements Initializable {
    
    
    @FXML private ComboBox comboBoxHaut;
    @FXML private ComboBox comboBoxMilieu;
    @FXML private ComboBox comboBoxBas;
    @FXML private TextField tfHaut0;
    @FXML private TextField tfHaut1;
    @FXML private TextField tfHaut2;
    @FXML private TextField tfHaut3;
    @FXML private TextField tfMilieu0;
    @FXML private TextField tfMilieu1;
    @FXML private TextField tfMilieu2;
    @FXML private TextField tfMilieu3;
    @FXML private TextField tfBas0;
    @FXML private TextField tfBas1;
    @FXML private TextField tfBas2;
    @FXML private TextField tfBas3;
    @FXML private Label labelHautOpt1;
    @FXML private Label labelHautOpt2;
    @FXML private Label labelMilieuOpt1;
    @FXML private Label labelMilieuOpt2;
    @FXML private Label labelBasOpt1;
    @FXML private Label labelBasOpt2;
    private List<String> listCb;
    private List<TextField> listTfHaut;
    private List<TextField> listTfMilieu;
    private List<TextField> listTfBas;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCb = new ArrayList<>();
        listTfHaut = new ArrayList<>();
        listTfMilieu = new ArrayList<>();
        listTfBas = new ArrayList<>();
        
        listCb.add("Algo Aléatoire");
        listCb.add("Algo Bornes");
        listCb.add("Algo Limité");
        
        
        listTfHaut.add(tfHaut2);
        listTfHaut.add(tfHaut3);
        listTfMilieu.add(tfMilieu2);
        listTfMilieu.add(tfMilieu3);
        listTfBas.add(tfBas2);
        listTfBas.add(tfBas3);
        
        for(TextField i : listTfHaut){
            i.setDisable(true);
        }
        
        for(TextField i : listTfMilieu){
            i.setDisable(true);
        }
        
        for(TextField i : listTfBas){
            i.setDisable(true);
        }
        
        
        comboBoxHaut.getItems().addAll(listCb);
        comboBoxHaut.valueProperty().setValue(listCb.get(0));
        
        
        
        comboBoxMilieu.getItems().addAll(listCb);
        comboBoxMilieu.valueProperty().setValue(listCb.get(0));
        
        comboBoxBas.getItems().addAll(listCb);
        comboBoxBas.valueProperty().setValue(listCb.get(0));
        
    }

    public void clicComboBoxHaut(){
        switch((String)comboBoxHaut.valueProperty().getValue()){
            case "Algo Aléatoire" : 
                    for(TextField i : listTfHaut){
                        i.setDisable(true);
                    }
                    break;
            case "Algo Bornes" : 
                    for(TextField i : listTfHaut){
                        i.setDisable(false);
                    }
                    labelHautOpt1.setText("Min");
                    labelHautOpt2.setText("Max");
                    break;
            case "Algo Limité" : 
                    tfHaut2.setDisable(false);
                    tfHaut3.setDisable(true);
                    labelHautOpt1.setText("Variation");
                    break;
            default : 
                System.err.println("pb");
                break;
        }
    }
    public void clicComboBoxMilieu(){
        switch((String)comboBoxMilieu.valueProperty().getValue()){
            case "Algo Aléatoire" : 
                    for(TextField i : listTfMilieu){
                        i.setDisable(true);
                    }
                    break;
            case "Algo Bornes" : 
                    for(TextField i : listTfMilieu){
                        i.setDisable(false);
                    }
                    labelMilieuOpt1.setText("Min");
                    labelMilieuOpt2.setText("Max");
                    break;
            case "Algo Limité" : 
                    tfMilieu2.setDisable(false);
                    tfMilieu3.setDisable(true);
                    labelMilieuOpt1.setText("Variation");
                    break;
            default : 
                System.err.println("pb");
                break;
        }
    }
    public void clicComboBoxBas(){
        switch((String)comboBoxBas.valueProperty().getValue()){
            case "Algo Aléatoire" : 
                    for(TextField i : listTfBas){
                        i.setDisable(true);
                    }
                    break;
            case "Algo Bornes" : 
                    for(TextField i : listTfBas){
                        i.setDisable(false);
                    }
                    labelBasOpt1.setText("Min");
                    labelBasOpt2.setText("Max");
                    break;
            case "Algo Limité" : 
                    tfBas2.setDisable(false);
                    tfBas3.setDisable(true);
                    labelBasOpt1.setText("Variation");
                    break;
            default : 
                System.err.println("pb");
                break;
        }
    }
    
}
