/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import capteurs.Capteur;
import capteurs.MegaCapteur;
import capteurs.SimpleCapteur;
import java.util.List;
import javafx.scene.control.TreeItem;

/**
 *
 * @author Morgan
 */
public class VisiteurTreeItem implements IVisiteur{
 
    private TreeItem<Capteur> rootNode;
        public TreeItem<Capteur> getRootNode(){ return rootNode; }
    private TreeItem<Capteur> parentToAdd;
    
    public VisiteurTreeItem(){
        rootNode  = new TreeItem<>();
        parentToAdd = rootNode;
    }
    
    @Override
    public void visiterSimpleCapteur(SimpleCapteur sc) {
        TreeItem<Capteur> capLeaf = new TreeItem<>(sc);
        System.out.println(capLeaf.getValue().getNom());
        parentToAdd.getChildren().add(capLeaf);
    }

    @Override
    public void visiterMegaCapteur(MegaCapteur mc) {
        TreeItem<Capteur> oldParent = parentToAdd;
        parentToAdd = new TreeItem<>(mc);
        parentToAdd.setExpanded(true);
        List<Capteur> listCap = mc.getCapteurs();
        for (Capteur cap : listCap)
        {
            cap.accepter(this);
        }
        oldParent.getChildren().add(parentToAdd);
        parentToAdd = oldParent;
    }   
}