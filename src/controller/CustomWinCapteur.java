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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;
import capteurs.SimpleCapteur;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.util.converter.IntegerStringConverter;
import utils.FactoryScene;
import javafx.stage.Stage;
import utils.CapteurManager;
import utils.FactoryCapteur;
import utils.ThreadManager;

/**
 *
 * @author nibilly
 */
public class CustomWinCapteur extends HBox implements Initializable {
    
    @FXML private ComboBox comboBoxAlgo;
    @FXML private ComboBox comboBoxWin;
    @FXML private Label labelOpt1;
    @FXML private Label labelOpt2;
    @FXML private TextField textFieldTemp;
    @FXML private TextField textFieldMaj;
    @FXML private TextField textFieldOpt1;
    @FXML private TextField textFieldOpt2;
    @FXML private TextField textFieldNom;
    
    private SimpleCapteur capteur;
    private Integer tabparams[];
    private FactoryScene factoryScene;
    private FactoryCapteur factoryCapteur;
    private Stage stage;
    
    private static final String ALEATOIRE = "Algo Aléatoire";
    private static final String BORNES = "Algo Bornes";
    private static final String LIMITE = "Algo Limité";
    private static final String SPINNER = "Spinner";
    private static final String ICONE = "Icone";
    private static final String PROGRESS = "Mercure";
    
    private List<String> listCb;
    private List<String> listCbWin;
    private List<TextField> listTf;
    
    public CustomWinCapteur(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CustomWinCapteur.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        factoryScene = new FactoryScene();
        factoryCapteur = new FactoryCapteur();
        try{
            loader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCb = new ArrayList<>();
        listCbWin = new ArrayList<>();
        listTf = new ArrayList<>();
        
        listCb.add(ALEATOIRE);
        listCb.add(BORNES);
        listCb.add(LIMITE);
        
        listCbWin.add(SPINNER);
        listCbWin.add(ICONE);
        listCbWin.add(PROGRESS);
        
        listTf.add(textFieldOpt1);
        listTf.add(textFieldOpt2);
        
        listTf.forEach((i) -> {
            i.setDisable(true);
        });
        
        comboBoxWin.getItems().addAll(listCbWin);
        comboBoxWin.valueProperty().setValue(listCbWin.get(1));
        
        comboBoxAlgo.getItems().addAll(listCb);
        comboBoxAlgo.valueProperty().setValue(listCb.get(0));
        
        stage = new Stage();
    }
    
    public void clicComboBoxAlgo(){
        switch((String)comboBoxAlgo.valueProperty().getValue()){
            case ALEATOIRE : 
                    listTf.forEach((i) -> {
                    i.setDisable(true);
                    });
                    break;
            case BORNES : 
                    listTf.forEach((i) -> {
                    i.setDisable(false);
                     });
                    labelOpt1.setText("Min");
                    labelOpt2.setText("Max");
                    break;
            case LIMITE : 
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
        tabparams = new Integer[3];
        tabparams[0] = maj;
        tabparams[1] = new IntegerStringConverter().fromString(textFieldOpt1.getText());
        tabparams[2] = new IntegerStringConverter().fromString(textFieldOpt2.getText());
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Mise en garde.");
        alert.setHeaderText("Attention à remplir correctement toutes les cases.");
        try{
            capteur = factoryCapteur.creerCapteur(textFieldNom.getText(),(String)comboBoxAlgo.valueProperty().getValue(), temp, tabparams);
            CapteurManager.ajouterCapteur(capteur);
            ThreadManager.ajouterThread(capteur);
        } catch(Exception e){
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }
        try
        {
            stage.setTitle(textFieldNom.getText());
            stage.setScene(factoryScene.creerFenetre(capteur,(String)comboBoxWin.valueProperty().getValue()));
            stage.showAndWait();
        }
        catch (IOException e){
            System.err.println("Erreur création fenêtre IO.");
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            System.err.println("Erreur création fenêtre.");
            System.err.println(e.getMessage());
        }
    }
}
