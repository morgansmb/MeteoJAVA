/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import java.util.Random;
import javafx.beans.InvalidationListener;

/**
 *
 * @author samue
 */
public class StrategieLimite implements Strategie{
    
    private double init;
    private int variation;
    
    public StrategieLimite(double tinit,int v){
        this.init=tinit;
        this.variation=v;
    }
    
    @Override
    public double changementTemperature() {
        Random rand = new Random();
        return init+rand.nextDouble()*variation*2-variation;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
