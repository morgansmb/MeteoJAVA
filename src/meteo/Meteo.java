/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import capteurs.MegaCapteur;
import capteurs.Capteur;
import capteurs.StrategieBorne;
import capteurs.SimpleCapteur;
import controller.CustomWinCapteur;
import utils.ThreadManager;
import controller.IconeWinController;
import controller.MainMenuWinController;
import java.awt.BorderLayout;
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
    private Capteur capteur2;
    private MegaCapteur mg;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        capteur = new SimpleCapteur(15.0,3,new StrategieBorne());
        //capteur2 = new SimpleCapteur(25.0,3,new StrategieBorne());
        
        
        /*
        mg = new MegaCapteur(2);
        mg.ajouterCapteur(capteur, 2);
        mg.ajouterCapteur(capteur2, 2); */
        //ThreadManager tm = ThreadManager.getInstance();
        //tm.startThread();
        
        //FXMLLoader mainWinLoader = new FXMLLoader(getClass().getResource("/gui/IconeWin.fxml"));
        //mainWinLoader.setController(new IconeWinController(capteur));
        
        FXMLLoader mainWinLoader = new FXMLLoader(getClass().getResource("/gui/MainMenuWin.fxml"));
        mainWinLoader.setController(new MainMenuWinController());
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(mainWinLoader.load()));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void stop()
    {
        ThreadManager tm = ThreadManager.getInstance();
        tm.stopThread();
    }
}
