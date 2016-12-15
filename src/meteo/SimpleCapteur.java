/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

/**
 *
 * @author mosambardi
 */
public class SimpleCapteur extends Capteur{
    
    private Strategie stratAlgo;
    
    public SimpleCapteur(double temperature, int maj, Strategie strat) {
        super(temperature, maj);
        setAlgo(strat);
    }
    
    @Override
    public void changeTemperature(){
        setTemperature(this.stratAlgo.changementTemperature());
    }
    
    public final void setAlgo(Strategie strat){
        this.stratAlgo = strat;
    }
    
}
