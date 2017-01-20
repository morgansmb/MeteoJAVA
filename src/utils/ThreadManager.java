/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import capteurs.Capteur;
import java.util.List;

/**
 *
 * @author Morgan
 */
public class ThreadManager {
    
    private static HashMap<Capteur, Thread> mapThread = new HashMap<>();
        public static HashMap<Capteur, Thread> getMap() { return mapThread; }
        public static void setMap(HashMap<Capteur,Thread> map) { mapThread = map; }
        
    public static void ajouterThread(Capteur capteur)
    {
        mapThread.put(capteur, new Thread(capteur));
        mapThread.get(capteur).start();
    } 
    
    public static void retirerThread(Capteur capteur)
    {
        mapThread.get(capteur).interrupt();
        mapThread.remove(capteur);
    }
    
    public static void startThread()
    {
        for (Map.Entry<Capteur,Thread> entry : mapThread.entrySet()){
            entry.getValue().start();
        }
    }
    
    public static void stopThread()
    {
        for (Map.Entry<Capteur,Thread> entry : mapThread.entrySet()){
            entry.getValue().interrupt();
        }
    }
    
    public static void ajouterListAsMap(List<Capteur> list){
       for (Capteur capteur : list){
           ajouterThread(capteur);
       } 
    }
}
