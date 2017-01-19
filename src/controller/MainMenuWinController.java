/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.SimpleCapteur;
import capteurs.StrategieBorne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.FactoryScene;

/**
 * FXML Controller class
 *
 * @author mosambardi
 */
public class MainMenuWinController implements Initializable {
    @FXML private GridPane gridPaneMenu;
    private CustomWinCapteur custom1;
    private CustomWinCapteur custom2;
    private CustomWinCapteur custom3;
    private FactoryScene factoScene;
    
        
    public MainMenuWinController(){
        custom1= new CustomWinCapteur();
        custom2= new CustomWinCapteur();
        custom3= new CustomWinCapteur();
        factoScene = new FactoryScene();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gridPaneMenu.add(custom1, 0, 0);
        gridPaneMenu.add(custom2, 0, 1);
        gridPaneMenu.add(custom3, 0, 2);
    }
    
    public void clicAfficherReseau(){
        Stage stage = new Stage();
        try
        {
            stage.setTitle("Réseau de capteurs");
            stage.setScene(factoScene.creerFenetre(null,"Reseau"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        catch (IOException e){
            System.err.println("Erreur création fenêtre IO.");
            System.err.println(e.getMessage());
        }
        catch (Exception e2){
            System.err.println(e2.getMessage());
        }
    }
}
