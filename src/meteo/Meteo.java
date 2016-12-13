/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mosambardi
 */
public class Meteo extends Application {
    
    private Capteur capteur;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        //Pb : comment gérer le patron stratégique puisque Capteur est abstraite
        capteur = new Capteur(15.0,5,new StrategieBorne());
        FXMLLoader mainWinLoader = new FXMLLoader(getClass().getResource("/gui/IconeWin.fxml"));
        mainWinLoader.setController(new IconeWinController(capteur));
        
        primaryStage.setTitle("Thermostat");
        primaryStage.setScene(new Scene(mainWinLoader.load()));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
