/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.Capteur;
import capteurs.SimpleCapteur;
import capteurs.StrategieBorne;
import capteurs.StrategieLimite;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import utils.ThreadManager;

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
    private ThreadManager tm;
    
        
    public MainMenuWinController(){
        SimpleCapteur cap1 = new SimpleCapteur(15.0, 5, new StrategieBorne());
        SimpleCapteur cap2 = new SimpleCapteur(15.0, 5, new StrategieBorne(-5, 60));
        SimpleCapteur cap3 = new SimpleCapteur(15.0, 5, new StrategieLimite(20.0, 2));
        custom1= new CustomWinCapteur(cap1);
        custom2= new CustomWinCapteur(cap2);
        custom3= new CustomWinCapteur(cap3);
        tm = ThreadManager.getInstance();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gridPaneMenu.add(custom1, 0, 0);
        gridPaneMenu.add(custom2, 0, 1);
        gridPaneMenu.add(custom3, 0, 2);
        tm.startThread();
    }
}
