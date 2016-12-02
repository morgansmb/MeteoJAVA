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
public class ConcreteCapteurC extends Capteur{
    
    public ConcreteCapteurC(double temp) {
        super(temp);
    }
    
     @Override
    public double changementTemperature(){
        return 0;
    }
}
