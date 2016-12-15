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
public class StrategieBorne implements Strategie{
    public static final int MIN = -10;
    public static final int MAX = 40;
    private Integer min;
    private Integer max;
        
    public StrategieBorne(){
        
    }
    
    public StrategieBorne(int mini, int maxi){
        this.min=mini;
        this.max=maxi;
    }
    
    
    @Override
    public double changementTemperature() {
        Random rand = new Random();
        if(min != null)
            return rand.nextDouble()*max+min;
        return rand.nextDouble()*MAX+MIN;
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
