/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import capteurs.Capteur;

/**
 *
 * @author Morgan
 */
public class ThreadManager {
    
    private static HashMap<Capteur, Thread> mapThread;
    private static ThreadManager instanceUnique;
    
    public ThreadManager()
    {
        mapThread = new HashMap<>();
    }
    
    public static ThreadManager getInstance()
    {
        if (instanceUnique == null){
            instanceUnique = new ThreadManager();
        }
        return instanceUnique;
    }
    
    public void ajouterThread(Capteur capteur)
    {
        mapThread.put(capteur, new Thread(capteur));
    }
    
    public void startThread()
    {
        for (Map.Entry<Capteur,Thread> entry : mapThread.entrySet()){
            entry.getValue().start();
        }
    }
    
    public void stopThread()
    {
        for (Map.Entry<Capteur,Thread> entry : mapThread.entrySet()){
            entry.getValue().interrupt();
        }
    }
}
