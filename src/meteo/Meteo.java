/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import capteurs.Capteur;
import capteurs.MegaCapteur;
import capteurs.SimpleCapteur;
import capteurs.StrategieLimite;
import utils.ThreadManager;
import controller.MasterDetailWinController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.CapteurManager;

/**
 *
 * @author mosambardi
 */
public class Meteo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       //capteur = new SimpleCapteur(15.0,3,new StrategieBorne());
        //capteur2 = new SimpleCapteur(25.0,3,new StrategieBorne());
        
        
        /*
        mg = new MegaCapteur(2);
        mg.ajouterCapteur(capteur, 2);
        mg.ajouterCapteur(capteur2, 2); */
        //ThreadManager tm = ThreadManager.getInstance();
        //tm.startThread();
        
        //FXMLLoader mainWinLoader = new FXMLLoader(getClass().getResource("/gui/IconeWin.fxml"));
        //mainWinLoader.setController(new IconeWinController(capteur));
        /*
        Test du Master Detail
        */
        
        Capteur c = new SimpleCapteur(2,2,new StrategieLimite(20,2),"capteur1");
        Capteur bla = new SimpleCapteur(2,2,new StrategieLimite(20,2),"capteur2");
        MegaCapteur v = new MegaCapteur(2,"mega1");
        v.ajouterCapteur(c, 1);
        CapteurManager.ajouterCapteur(c);
        CapteurManager.ajouterCapteur(v);
        
        
        FXMLLoader mainWinLoader = new FXMLLoader(getClass().getResource("/gui/MasterDetailWin.fxml"));
        mainWinLoader.setController(new MasterDetailWinController());
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(mainWinLoader.load()));
        primaryStage.show();
        /*
        FXMLLoader mainWinLoader = new FXMLLoader(getClass().getResource("/gui/MainMenuWin.fxml"));
        mainWinLoader.setController(new MainMenuWinController());
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(mainWinLoader.load()));
        primaryStage.show();
        */
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
        ThreadManager.stopThread();
    }
}
