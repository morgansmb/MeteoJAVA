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
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author syherail
 */
public class MegaCapWinController implements Initializable {
    private ScrollPane scrollp;
    private List<Capteur> capList;
    @FXML private TreeView treevCap;
    
    public MegaCapWinController(CapteurManager cm)
    {
        capList = cm.getList();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GridPane gp = new GridPane();
        gp.addColumn(0);
        gp.addColumn(1);
        gp.addColumn(2);
        scrollp.setContent(gp);
    }    
    
    private void OnAddClick()
    {
        
    }
    
    private void remplirTreeView(List<Capteur> listCap)
    {
        TreeItem<String> rootNode = new TreeItem<>("Liste des capteurs :");
        rootNode.setExpanded(true);
        for (Capteur capteur : listCap) {
            if (capteur instanceof SimpleCapteur)
            {
                TreeItem<String> capLeaf = new TreeItem<>(capteur.getNom());
                rootNode.getChildren().add(capLeaf);
            }
            else
            {
                TreeItem<String> megaCapNode = new TreeItem<>(capteur.getNom());
                MegaCapteur mc = (MegaCapteur)capteur;
                List<Capteur> megaCapList = mc.getCapteurs();
                creationBrancheMC(megaCapNode, mc);
            }
            
        }
    }
    
    public void creationBrancheMC(TreeItem<String> megaCapNode, MegaCapteur mc)
    {
        List<Capteur> megaCapList = mc.getCapteurs();
        for (Capteur cap : megaCapList)
        {
            if (cap instanceof SimpleCapteur)
            {
                TreeItem<String> mCapLeaf = new TreeItem<>(cap.getNom());
                megaCapNode.getChildren().add(mCapLeaf);
            }
            else
            {
                TreeItem<String> mcNode = new TreeItem<>(cap.getNom());
                creationBrancheMC(mcNode, mc);
            }
        }
        
    }
    
}
