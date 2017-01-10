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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;
import capteurs.SimpleCapteur;
import capteurs.Strategie;
import capteurs.StrategieBorne;
import capteurs.StrategieLimite;
import java.beans.EventHandler;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.converter.IntegerStringConverter;
import utils.FactoryScene;
import utils.ThreadManager;

/**
 *
 * @author nibilly
 */
public class CustomWinCapteur extends HBox implements Initializable {
    
    @FXML private ComboBox comboBoxAlgo;
    @FXML private ComboBox comboBoxWin;
    @FXML private Label labelCapteur;
    @FXML private Label labelOpt1;
    @FXML private Label labelOpt2;
    @FXML private TextField textFieldTemp;
    @FXML private TextField textFieldMaj;
    @FXML private TextField textFieldOpt1;
    @FXML private TextField textFieldOpt2;
    @FXML private Button buttonWin;
    private SimpleCapteur capteur;
    private ThreadManager tm;
    private FactoryScene factoryFenetre;
    
    private List<String> listCb;
    private List<String> listCbWin;
    private List<TextField> listTf;
    
    public CustomWinCapteur(){
        tm = ThreadManager.getInstance();
        tm.startThread();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CustomWinCapteur.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        factoryFenetre = new FactoryScene();
        try{
            loader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
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
        
        listTf.forEach((i) -> {
            i.setDisable(true);
        });
        
        comboBoxWin.getItems().addAll(listCbWin);
        comboBoxWin.valueProperty().setValue(listCbWin.get(1));
        
        comboBoxAlgo.getItems().addAll(listCb);
        comboBoxAlgo.valueProperty().setValue(listCb.get(0));
    }
    
    public void clicComboBoxAlgo(){
        switch((String)comboBoxAlgo.valueProperty().getValue()){
            case "Algo Aléatoire" : 
                    listTf.forEach((i) -> {
                    i.setDisable(true);
                    });
                    break;
            case "Algo Bornes" : 
                    listTf.forEach((i) -> {
                    i.setDisable(false);
                     });
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
    
    public void clicAfficher() throws IOException{
        Double temp = new DoubleStringConverter().fromString(textFieldTemp.getText());
        Integer maj = new IntegerStringConverter().fromString(textFieldMaj.getText());
        Integer opt1;
        Integer opt2;
        Strategie strat = null;
        Stage stage = new Stage();
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Mise en garde.");
        alert.setHeaderText("Attention à remplir correctement toutes les cases.");
        
        switch((String)comboBoxAlgo.valueProperty().getValue()){
            case "Algo Aléatoire" :
                if(temp==null || maj==null){
                    alert.setContentText("Il faut remplir correctement les deux premières cases.");
                    alert.showAndWait();
                    return;
                }
                else if(temp <-10 || temp >40){
                    alert.setContentText("La valeur de la température doit être comprise entre -10°C et +40°C.");
                    alert.showAndWait();
                    return;
                }
                strat = new StrategieBorne();
                break;
            case "Algo Bornes" : 
                opt1 = new IntegerStringConverter().fromString(textFieldOpt1.getText());
                opt2 = new IntegerStringConverter().fromString(textFieldOpt2.getText());
                if(temp==null || maj==null || opt1==null || opt2==null){
                    alert.setContentText("Il faut remplir correctement toutes les cases.");
                    alert.showAndWait();
                    return;
                }
                else if(temp < opt1 || temp > opt2){
                    alert.setContentText("La température de départ doit être comprise entre les bornes min et max.");
                    alert.showAndWait();
                    return;
                }
                strat = new StrategieBorne(opt1, opt2);
                break;
            case "Algo Limité" : 
                opt1 = new IntegerStringConverter().fromString(textFieldOpt1.getText());
                if(temp==null || maj==null || opt1==null){
                    alert.setContentText("Il faut remplir correctement les trois premières cases.");
                    alert.showAndWait();
                    return;
                }
                else if(temp <-10 || temp >40){
                    alert.setContentText("La valeur de la température doit être comprise entre -10°C et +40°C.");
                    alert.showAndWait();
                    return;
                }
                strat = new StrategieLimite(temp, opt1);
                break;
            default : 
                System.err.println("pb choix algo");
                break;
        }
        if(strat != null){
            capteur = new SimpleCapteur(temp, maj, strat);
            tm.ajouterThread(capteur);
            try
            {
                stage.setScene(factoryFenetre.creerFenetre(capteur, (String)comboBoxWin.valueProperty().getValue()));
                stage.showAndWait();
            }
            catch (Exception e){
                System.err.println("Erreur création fenêtre.");
                System.err.println(e.getMessage());
            }
            tm.retirerThread(capteur);
            }
        else
            System.err.println("pb d'instance de la stratégie.");
        
        
    }
        
}
