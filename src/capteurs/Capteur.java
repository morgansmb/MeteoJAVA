/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utils.IVisiteur;

/**
 *
 * @author mosambardi
 */
public abstract class Capteur extends ObservableBase implements Runnable {
    
    private ObjectProperty<Double> objProp = new SimpleObjectProperty<>();
        public ObjectProperty<Double> getObjProp() {return objProp;}
        public void setObjProp(ObjectProperty<Double> objProp) {this.objProp = objProp;}
        
    private DoubleProperty temperature = DoubleProperty.doubleProperty(getObjProp());
        public DoubleProperty temperatureProperty (){ return temperature;}
        public double getTemperature(){return temperature.get();}
        public void setTemperature(double temperature){Platform.runLater(() ->this.temperature.set(temperature));}

    private IntegerProperty maj = new SimpleIntegerProperty();
        public void setMaj(int value) { maj.set(value); }
        public int getMaj() { return maj.get(); }
        public IntegerProperty majProperty() { return maj; }
    
    private StringProperty nom = new SimpleStringProperty();
        public StringProperty nomProperty() { return nom; }
        public void setNom(String value){ nom.set(value); }
        public String getNom() { return nom.get(); }
        

    public abstract void changeTemperature();
    
    public Capteur(double temperature, int maj, String nom){
        setNom(nom);
        setTemperature(temperature);
        setMaj(maj);
    }
    
    public abstract void accepter(IVisiteur v);
}
