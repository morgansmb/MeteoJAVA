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
public class CapteurAleatoire extends Capteur{
    
    public CapteurAleatoire(double temp, int maj) {
        super(temp, maj);
    }
    
    @Override
    public double getTemperature(){
        return super.getTemperature();
    }
    
    @Override
    public void changementTemperature(){
        Random rand = new Random();
        Double res;
        res = rand.nextDouble()*50-10;
        setTemperature(res);
    }
}
