/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.SimpleCapteur;
import capteurs.StrategieBorne;
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
    
    private CustomWinCapteur custom1;
    private CustomWinCapteur custom2;
    private CustomWinCapteur custom3;
        
    public MainMenuWinController(){
        custom1= new CustomWinCapteur(new SimpleCapteur(15.0, 5, new StrategieBorne()));
        custom2= new CustomWinCapteur(new SimpleCapteur(15.0, 5, new StrategieBorne()));
        custom3= new CustomWinCapteur(new SimpleCapteur(15.0, 5, new StrategieBorne()));
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
     public void clicComboBoxAlgo(){
         custom1.clicComboBoxAlgo();
     }
     
     public void clicAfficher(){
         custom1.clicAfficher();
     }
    
}
