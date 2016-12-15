/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public void run() {
        while (true)
        {
            this.changeTemperature();
            try {
                TimeUnit.SECONDS.sleep(getMaj());
            } catch (InterruptedException ex) {
                Logger.getLogger(SimpleCapteur.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }
    
}
