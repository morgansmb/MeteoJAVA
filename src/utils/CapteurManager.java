/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import capteurs.Capteur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morgan
 */
public class CapteurManager {
    private static List<Capteur> listAllCap = new ArrayList<>();
        public static void setListCap(List<Capteur> list) { listAllCap = list; }
        public static List<Capteur> getList() { return listAllCap; }
        
    
    public static void ajouterCapteur(Capteur cap){
        listAllCap.add(cap);
    }
    
    public static void supprimerCapteur(Capteur cap){
        listAllCap.remove(cap);
    }
}
