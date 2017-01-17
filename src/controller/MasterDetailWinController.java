/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.Capteur;
import capteurs.MegaCapteur;
import capteurs.SimpleCapteur;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import utils.CapteurManager;
import utils.VisiteurTreeItem;

/**
 * FXML Controller class
 *
 * @author Morgan
 */
public class MasterDetailWinController implements Initializable {
    
    private List<Capteur> capList;
    private VisiteurTreeItem visiteur;
    private TreeItem<Capteur> rootNode;
    @FXML private TreeView<Capteur> treevCap;
    @FXML private GridPane mainGrid;
    @FXML private GridPane repGrid;
    
    public MasterDetailWinController(){
        capList = CapteurManager.getList();
        visiteur = new VisiteurTreeItem();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirTreeView();
        treevCap.setRoot(rootNode);
        treevCap.getSelectionModel().selectedItemProperty().addListener( new ChangeListener() {

        @Override
        public void changed(ObservableValue observable, Object oldValue,
                Object newValue) {
            
            TreeItem<Capteur> selectedItem = (TreeItem<Capteur>) newValue;
            if (selectedItem.getValue() instanceof SimpleCapteur)
            {
                Platform.runLater(() -> mainGrid.getChildren().remove(1) );
                SimpleCapteur sc = (SimpleCapteur) selectedItem.getValue();
                mainGrid.add(new SimpleCapInfoController(sc),1,0);
            }
            
            /*
            if (selectedItem.getValue() instanceof MegaCapteur)
            {
                MegaCapteur mc = (MegaCapteur) selectedItem.getValue();
                mainGrid.add(new MegaCapInfoController(mc),1,0);
                mainGrid.re
            }*/
        }
      });
    }

    private void remplirTreeView(){
        for (Capteur capteur : capList) {
          capteur.accepter(visiteur);
        }
        rootNode = visiteur.getRootNode();
        rootNode.setExpanded(true);
    } 
}