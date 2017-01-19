/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import utils.IVisiteur;

/**
 *
 * @author mosambardi
 */
public class MegaCapteur extends Capteur{
    
    private HashMap<Capteur,Integer> mapCapteur;
    
    public MegaCapteur(int maj, String nom) {
        super(0, maj, nom);
        mapCapteur = new HashMap<>();
    }
    
    //constructeur vide pour serialization
    public MegaCapteur() {}
    
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
        mapCapteur.put(capteur, poids);
    }
    
    public void retirerCapteur(Capteur capteur)
    {
        mapCapteur.remove(capteur);
    }
    
    public List<Capteur> getCapteurs()
    {
        List<Capteur> listCap = new LinkedList<>();
        for (Map.Entry<Capteur,Integer> entry : mapCapteur.entrySet()){
            listCap.add(entry.getKey());
        }
        return listCap;
    }

    @Override
    public void run() {
        while (true)
        {
            this.changeTemperature();
            try {
                TimeUnit.MILLISECONDS.sleep(getMaj());
            } catch (InterruptedException ex) {
                //Logger.getLogger(SimpleCapteur.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }

    @Override
    public void accepter(IVisiteur v) {
        v.visiterMegaCapteur(this);
    }

}