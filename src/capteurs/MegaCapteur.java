/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mosambardi
 */
public class MegaCapteur extends Capteur{
    
    private HashMap<Capteur,Integer> mapCapteur;
    
    public MegaCapteur(int maj) {
        super(0, maj);
        mapCapteur = new HashMap<>();
    }

    @Override
    public void changeTemperature(){
        int size = mapCapteur.size();
        float total = 0;
        double moyenne = 0;
        for (Map.Entry<Capteur,Integer> entry : mapCapteur.entrySet()){
            total += entry.getKey().getTemperature() * entry.getValue().floatValue();
        }
        moyenne = total / size;
        super.setTemperature(moyenne);
        System.out.println(moyenne);
    }
    
    public void ajouterCapteur(Capteur capteur, int poids)
    {
        System.out.println(capteur.getTemperature());
        mapCapteur.put(capteur, poids);
        System.out.println("fefefo");
    }
    
    public void retirerCapteur(Capteur capteur)
    {
        mapCapteur.remove(capteur);
    }  

    @Override
    public void run() {
        while (true)
        {
            this.changeTemperature();
            try {
                TimeUnit.MILLISECONDS.sleep(getMaj());
            } catch (InterruptedException ex) {
                Logger.getLogger(SimpleCapteur.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }
}
;