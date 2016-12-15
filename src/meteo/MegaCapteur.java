/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mosambardi
 */
public class MegaCapteur extends Capteur{
    
    private HashMap<Capteur,Integer> mapCapteur;
    
    public MegaCapteur(double temperature, int maj) {
        super(temperature, maj);
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
    }
    
    public void ajouterCapteur(Capteur capteur, int poids)
    {
        mapCapteur.put(capteur, new Integer(poids));
    }
    
    public void retirerCapteur(Capteur capteur)
    {
        mapCapteur.remove(capteur);
    }  
}
;