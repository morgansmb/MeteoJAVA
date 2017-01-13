/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import capteurs.Capteur;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
    
    public MasterDetailWinController(){
        capList = CapteurManager.getList();
        visiteur = new VisiteurTreeItem();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirTreeView();
        treevCap = new TreeView<>(rootNode);
    }

    private void remplirTreeView(){
        for (Capteur capteur : capList) {
          capteur.accepter(visiteur);
        }
        rootNode = visiteur.getRootNode();
    }
    
}
