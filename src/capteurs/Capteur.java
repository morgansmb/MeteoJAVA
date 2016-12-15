/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import utils.ThreadManager;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author mosambardi
 */
public abstract class Capteur extends ObservableBase implements Runnable {
    
    private ObjectProperty<Double> objProp = new SimpleObjectProperty<>();
        public ObjectProperty<Double> getObjProp() {
            return objProp;
        }
        public void setObjProp(ObjectProperty<Double> objProp) {
                this.objProp = objProp;
        }
        
    private DoubleProperty temperature = DoubleProperty.doubleProperty(getObjProp());
        public DoubleProperty temperatureProperty (){
                return temperature;
        }
        public double getTemperature(){
            return temperature.get();
        }
    
        public final void setTemperature(double temperature){
            this.temperature.set(temperature);
        }
    
    private int maj; //Intervalle de mise à jour du capteur en secondes.
        public int getMaj(){
            return maj;
        }
        public final void setMaj(int num){
            this.maj=num;
        }
        
    public abstract void changeTemperature();
    
    public Capteur(double temperature, int maj){
        setTemperature(temperature);
        setMaj(maj);
        ThreadManager tm = ThreadManager.getInstance();
        tm.ajouterThread(this);
    }
}
