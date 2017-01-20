/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import capteurs.Capteur;
import controller.MainMenuWinController;
import utils.ThreadManager;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.CapteurManager;
import utils.XMLLoader;
import utils.XMLSaver;

/**
 *
 * @author mosambardi
 */
public class Meteo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        List<Capteur> list = (List<Capteur>) XMLLoader.ouvrirXML("save.xml");
        CapteurManager.setListCap(list);
        ThreadManager.ajouterListAsMap(list);
        FXMLLoader mainWinLoader = new FXMLLoader(getClass().getResource("/gui/MainMenuWin.fxml"));
        mainWinLoader.setController(new MainMenuWinController());
        
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(mainWinLoader.load()));
        primaryStage.setMinHeight(450);
        primaryStage.setMinWidth(550);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void stop() throws IOException
    {
        ThreadManager.stopThread();
        XMLSaver.sauvegarderXML(CapteurManager.getList(),"save.xml");
    }
}
