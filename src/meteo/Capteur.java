/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author mosambardi
 */
public abstract class Capteur {
    private DoubleProperty temperature = new SimpleDoubleProperty();
    
    public Double getTemperature(){
        return temperature.get();
    }
    
    public void setTemperature(Double temperature){
        this.temperature.set(temperature);
    }
    
    public DoubleProperty temperatureProperty (){
        return temperature;
    }
    
    public Capteur(Double temperature){
        setTemperature(temperature);
    }
    
    public abstract double changementTemperature();
    
}
