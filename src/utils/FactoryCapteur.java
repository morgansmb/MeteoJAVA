/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import capteurs.Capteur;
import capteurs.MegaCapteur;
import capteurs.SimpleCapteur;
import capteurs.Strategie;
import capteurs.StrategieBorne;
import capteurs.StrategieLimite;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;

/**
 *
 * @author sabussy
 */
public class FactoryCapteur {
    private Strategie strat;
    private Alert alert;
    private String nom;
    private static final String A = "Algo Aléatoire";
    private static final String B = "Algo Bornes";
    private static final String L = "Algo Limité";
    private static int id=0;
    
    /**
     * creer la strategie et le simple capteur
     * @param nomStrat
     * @param temp
     * @param tabparams contient maj, et en fonction de la strategie les options assocées
     * @param nom nom du capteur
     * @return Le capteur instancié
     */
    public SimpleCapteur creerCapteur(String nomStrat, Double temp, Integer[] tabparams) {
        id++;
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Mise en garde.");
        alert.setHeaderText("Attention à remplir correctement toutes les cases.");
        switch(nomStrat){
            case A:
                nom = A + id;
                if(temp==null || tabparams[0]==null){
                    alert.setContentText("Il faut remplir correctement les deux premières cases.");
                    alert.showAndWait();
                    break;
                }
                else if(temp <-10 || temp >40){
                    alert.setContentText("La valeur de la température doit être comprise entre -10°C et +40°C.");
                    alert.showAndWait();
                    break;
                }
                strat = new StrategieBorne();
                break;
            case B:
                nom = B + id;
                if(temp==null || tabparams[0]==null || tabparams[1]==null || tabparams[2]==null){
                    alert.setContentText("Il faut remplir correctement toutes les cases.");
                    alert.showAndWait();
                    break;
                }
                else if(temp < tabparams[1] || temp > tabparams[2]){
                    alert.setContentText("La température de départ doit être comprise entre les bornes min et max.");
                    alert.showAndWait();
                    break;
                }
                strat = new StrategieBorne(tabparams[1], tabparams[2]);
                break;
            case L:
                nom = L + id;
                if(temp==null || tabparams[0]==null || tabparams[2]==null){
                    alert.setContentText("Il faut remplir correctement les trois premières cases.");
                    alert.showAndWait();
                    break;
                }
                else if(temp <-10 || temp >40){
                    alert.setContentText("La valeur de la température doit être comprise entre -10°C et +40°C.");
                    alert.showAndWait();
                    break;
                }
                strat = new StrategieLimite(tabparams[0], tabparams[1]);
                break;
        }
        SimpleCapteur capt = new SimpleCapteur(temp, tabparams[0], strat, nom);
        
        return capt;
    }
    
    public Capteur creerCapteur(int maj, String nom, HashMap<Capteur, Integer> mapCapteur) {
        MegaCapteur c = new MegaCapteur(maj, nom);
       
        for (Map.Entry<Capteur,Integer> entry : mapCapteur.entrySet()){
            c.ajouterCapteur(entry.getKey(), entry.getValue());
        }
        return c;
    }

    
}
