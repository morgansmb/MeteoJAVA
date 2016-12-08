/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import java.util.Random;

/**
 *
 * @author mosambardi
 */
public class CapteurLimite extends Capteur{
    
    private double variation; //Variation max/min de la température.
    
    
    public CapteurLimite(double temp, int maj, double v) {
        super(temp, maj);
        this.variation=v;
    }
    
     @Override
    public void changementTemperature(){
        Random rand = new Random();
        Double res;
        res = getTemperature()+rand.nextDouble()*variation*2-variation;
        setTemperature(res);
        notifyObservers();
    }
}
