/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import capteurs.Capteur;
import controller.Fenetre;
import controller.IconeWinController;
import controller.ThermostatWinController;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sabussy
 */
public class FactoryScene {

    private static final String SPINNER = "Spinner";
    private static final String ICONE = "Icone";
    private static final String SPINNERTITLE = "Thermostat";
    private static final String ICONETITLE = "Icone";
    private FXMLLoader load;
    
    public Scene creerFenetre(Capteur capteur, String nomFenetre) throws IOException {
        switch(nomFenetre){
            case SPINNER :
                load = new FXMLLoader(getClass().getResource("/gui/ThermostatWin.fxml"));
                load.setController(new ThermostatWinController(capteur));
                break;
            case ICONE :
                load = new FXMLLoader(getClass().getResource("/gui/IconeWin.fxml"));
                load.setController(new IconeWinController(capteur));
                break;
            default :
                System.err.println("pb choix fenetre");
                break;
        }
        return new Scene(load.load());
    }
    
}
