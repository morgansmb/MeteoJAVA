/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.Capteur;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.FactoryScene;

/**
 * FXML Controller class
 *
 * @author samue
 */
public class AffichageCapteurController extends VBox implements Initializable {

    @FXML private ComboBox comboBoxWin;
    private static final String SPINNER = "Spinner";
    private static final String ICONE = "Icone";
    private static final String PROGRESS = "Mercure";
    private List<String> listCbWin;
    private FactoryScene factoryScene;
    private Stage stage;
    private Integer tabparams[];
    private Capteur capteur;
    
    public AffichageCapteurController(Capteur capteur){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/AffichageCapteur.fxml"));
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        factoryScene = new FactoryScene();
        this.capteur = capteur;
        stage = new Stage();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCbWin = new ArrayList<>();
        listCbWin.add(SPINNER);
        listCbWin.add(ICONE);
        listCbWin.add(PROGRESS);
        
        comboBoxWin.getItems().addAll(listCbWin);
        comboBoxWin.valueProperty().setValue(listCbWin.get(1));
        
        stage.initModality(Modality.APPLICATION_MODAL);
    }    
    
    public void clicAfficher(){
        try
        {
            stage.setTitle(capteur.getNom());
            stage.setScene(factoryScene.creerFenetre(capteur,(String)comboBoxWin.valueProperty().getValue()));
            stage.showAndWait();
            return;
        }
        catch (IOException e){
            System.err.println("Erreur création fenêtre IO.");
            System.err.println(e.getMessage());
            return;
        }
        catch (Exception e){
            System.err.println("Erreur création fenêtre.");
            System.err.println(e.getMessage());
            return;
        }
    }
}
