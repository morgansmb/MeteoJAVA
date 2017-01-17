/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

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
    
        
    public MainMenuWinController(){
        custom1= new CustomWinCapteur();
        custom2= new CustomWinCapteur();
        custom3= new CustomWinCapteur();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gridPaneMenu.add(custom1, 0, 0);
        gridPaneMenu.add(custom2, 0, 1);
        gridPaneMenu.add(custom3, 0, 2);
    }
}
