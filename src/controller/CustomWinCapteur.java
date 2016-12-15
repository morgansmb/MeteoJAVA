/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;
import capteurs.Capteur;
import capteurs.SimpleCapteur;
import capteurs.StrategieBorne;
import capteurs.StrategieLimite;

/**
 *
 * @author nibilly
 */
public class CustomWinCapteur implements Initializable {
    
    @FXML private ComboBox comboBoxAlgo;
    @FXML private ComboBox comboBoxWin;
    @FXML private Label labelCapteur;
    @FXML private Label labelOpt1;
    @FXML private Label labelOpt2;
    @FXML private TextField textFieldTemp;
    @FXML private TextField textFieldMaj;
    @FXML private TextField textFieldOpt1;
    @FXML private TextField textFieldOpt2;
    
    private List<String> listCb;
    private List<String> listCbWin;
    private List<TextField> listTf;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCb = new ArrayList<>();
        listCbWin = new ArrayList<>();
        listTf = new ArrayList<>();
        
        listCb.add("Algo Aléatoire");
        listCb.add("Algo Bornes");
        listCb.add("Algo Limité");
        
        listCbWin.add("Spinner");
        listCbWin.add("Icone");
        
        listTf.add(textFieldOpt1);
        listTf.add(textFieldOpt2);
        
        for(TextField i : listTf){
            i.setDisable(true);
        }
        
        comboBoxWin.getItems().addAll(listCbWin);
        comboBoxWin.valueProperty().setValue(listCbWin.get(1));
        
        comboBoxAlgo.getItems().addAll(listCb);
        comboBoxAlgo.valueProperty().setValue(listCb.get(0));
    }
    
    public void clicComboBoxAlgo(){
        switch((String)comboBoxAlgo.valueProperty().getValue()){
            case "Algo Aléatoire" : 
                    for(TextField i : listTf){
                        i.setDisable(true);
                    }
                    break;
            case "Algo Bornes" : 
                    for(TextField i : listTf){
                        i.setDisable(false);
                    }
                    labelOpt1.setText("Min");
                    labelOpt2.setText("Max");
                    break;
            case "Algo Limité" : 
                    textFieldOpt1.setDisable(false);
                    textFieldOpt2.setDisable(true);
                    labelOpt1.setText("Variation");
                    break;
            default : 
                System.err.println("pb");
                break;
        }
    }
    
    public void clicAfficher(){
        double temp = new DoubleStringConverter().fromString(textFieldTemp.getText());
        int maj = new Integer(textFieldMaj.getText());
        int opt1 = new Integer(textFieldOpt1.getText());
        int opt2;
        Capteur capteur = null;
        FXMLLoader load;
        
        switch((String)comboBoxAlgo.valueProperty().getValue()){
            case "Algo Aléatoire" : 
                capteur = new SimpleCapteur(temp, maj, new StrategieBorne());
                break;
            case "Algo Bornes" : 
                opt2 = new Integer(textFieldOpt2.getText());
                capteur = new SimpleCapteur(temp, maj, new StrategieBorne(opt1,opt2));
                break;
            case "Algo Limité" : 
                capteur = new SimpleCapteur(temp, maj, new StrategieLimite(temp, opt1));
                break;
            default : 
                System.err.println("pb choix algo");
                break;
        }
        
        switch((String)comboBoxWin.valueProperty().getValue()){
            case "Spinner" :
                load = new FXMLLoader(getClass().getResource("gui/ThermostatWin.fxml"));
                load.setController(new ThermostatWinController(capteur));
                break;
            case "Icone" :
                load = new FXMLLoader(getClass().getResource("gui/IconeWin.fxml"));
                load.setController(new IconeWinController(capteur));
                break;
            default :
                System.err.println("pb choix fenetre");
                break;
        }
        
    }
}
