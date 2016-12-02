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
public class ConcreteCapteurA extends Capteur{
    
    public ConcreteCapteurA(double temp) {
        super(temp);
    }
    
    @Override
    public Double getTemperature(){
        return super.getTemperature();
    }
    
    @Override
    public double changementTemperature(){
        return 0;
    }
}
