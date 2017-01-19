/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import static capteurs.Strategie.MAX;
import static capteurs.Strategie.MIN;
import java.util.Random;
import javafx.beans.InvalidationListener;

/**
 *
 * @author samue
 */
public class StrategieBorne extends Strategie{
    private Integer min;
    private Integer max;
        
    public StrategieBorne(){
        this.min = MIN;
        this.max = MAX;
    }
    
    public StrategieBorne(int mini, int maxi){
        this.min=mini;
        this.max=maxi;
    }
    
    
    @Override
    public double changementTemperature() {
        Random rand = new Random();
        return rand.nextDouble()*(max-min)+min;
    }

    @Override
    public Integer getMin() {
        return min;
    }

    @Override
    public Integer getMax() {
        return max;
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
