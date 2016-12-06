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
    private final DoubleProperty temperature = new SimpleDoubleProperty();
    private int maj; //Intervalle de mise à jour du capteur en secondes.
    
    public double getTemperature(){
        return temperature.get();
    }
    
    public final void setTemperature(double temperature){
        this.temperature.set(temperature);
    }
    
    public DoubleProperty temperatureProperty (){
        return temperature;
    }
    
    public int getMaj(){
        return maj;
    }
    
    public final void setMaj(int num){
        this.maj=num;
    }
    
    public Capteur(double temperature, int maj){
        setTemperature(temperature);
        setMaj(maj);
    }
    
    public abstract void changementTemperature();
    
}
