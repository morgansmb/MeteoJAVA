/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import static java.lang.Math.abs;
import java.util.Random;

/**
 *
 * @author mosambardi
 */
public class CapteurBorne extends Capteur{
    private double min;
    private double max;
    
    
    public CapteurBorne(double temp, int maj, int min, int max) {
        super(temp, maj);
        this.min = min;
        this.max = max;
    }
    
     @Override
    public void changementTemperature(){
        Random rand = new Random();
        Double res;
        res = rand.nextDouble()*(max+abs(min))-min;
        setTemperature(res);
        notifyObservers();
    }
}

