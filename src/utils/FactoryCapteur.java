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

/**
 *
 * @author sabussy
 */
public class FactoryCapteur {
    private Strategie strat;
    private static final String A = "Algo Aléatoire";
    private static final String B = "Algo Bornes";
    private static final String L = "Algo Limité";
    
    /**
     * creer la strategie et le simple capteur
     * @param nomStrat nom de la stratégie utilisée.
     * @param temp température qu'aura le capteur au départ.
     * @param tabparams contient maj, et en fonction de la strategie les options associées
     * @param nom nom du capteur
     * @return Le capteur instancié
     * @throws java.lang.Exception
     */
    public SimpleCapteur creerCapteur(String nom,String nomStrat, Double temp, Integer[] tabparams) throws Exception {
        if(nom.isEmpty())
            throw new Exception("Le nom du capteur ne doit pas être vide.");
        
        switch(nomStrat){
            case A:
                if(temp==null || tabparams[0]==null)
                    throw new Exception("Il faut remplir correctement les deux premières cases.");
                else if(temp <-10 || temp >40){
                    throw new Exception("La valeur de la température doit être comprise entre -10°C et +40°C.");
                }
                strat = new StrategieBorne();
                break;
            case B:
                if(temp==null || tabparams[0]==null || tabparams[1]==null || tabparams[2]==null){
                    throw new Exception("Il faut remplir correctement toutes les cases.");
                }
                else if(temp < tabparams[1] || temp > tabparams[2]){
                    throw new Exception("La température de départ doit être comprise entre les bornes min et max.");
                }
                strat = new StrategieBorne(tabparams[1], tabparams[2]);
                break;
            case L:
                if(temp==null || tabparams[0]==null || tabparams[1]==null){
                    throw new Exception("Il faut remplir correctement les trois premières cases.");
                }
                else if(temp <-10 || temp >40){
                    throw new Exception("La valeur de la température doit être comprise entre -10°C et +40°C.");
                }
                strat = new StrategieLimite(tabparams[0], tabparams[1]);
                break;
        }
        return new SimpleCapteur(temp, tabparams[0], strat, nom); 
    }
    
    public Capteur creerCapteur(int maj, String nom, HashMap<Capteur, Integer> mapCapteur) {
        MegaCapteur c = new MegaCapteur(maj, nom);
       
        for (Map.Entry<Capteur,Integer> entry : mapCapteur.entrySet()){
            c.ajouterCapteur(entry.getKey(), entry.getValue());
        }
        return c;
    }
}
