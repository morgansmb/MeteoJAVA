/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import java.util.concurrent.TimeUnit;
import utils.IVisiteur;

/**
 *
 * @author mosambardi
 */
public class SimpleCapteur extends Capteur{
    
    private Strategie stratAlgo;
    
    public SimpleCapteur(double temperature, int maj, Strategie strat, String nom) {
        super(temperature, maj, nom);
        setAlgo(strat);
        setMin(strat.getMin().toString());
        setMax(strat.getMax().toString());
    }
    
    //constructeur vide pour serialization
    public SimpleCapteur() {}
    
    @Override
    public void changeTemperature(){
        setTemperature(this.stratAlgo.changementTemperature());
        Integer min = stratAlgo.getMin();
        setMin(min.toString());
        Integer max = stratAlgo.getMax();
        setMax(max.toString());
        setPourcent((super.getTemperature()-min)/(max-min));
    }
    
    public final void setAlgo(Strategie strat){
        this.stratAlgo = strat;
    }

    
    @Override
    public void run() {
        while (true)
        {
            changeTemperature();
            try {
                TimeUnit.SECONDS.sleep(getMaj());
            } 
            catch (InterruptedException ex) {
                //Logger.getLogger(SimpleCapteur.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }

    @Override
    public void accepter(IVisiteur v) {
        v.visiterSimpleCapteur(this);
    }
}
