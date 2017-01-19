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
    
    private ObjectProperty<Double> objTempProp = new SimpleObjectProperty<>();
        public ObjectProperty<Double> getObjTempProp() {return objTempProp;}
        public final void setObjTempProp(ObjectProperty<Double> objTempProp) {this.objTempProp = objTempProp;}
        
    private ObjectProperty<Double> objPourcProp = new SimpleObjectProperty<>();
        public ObjectProperty<Double> getObjPourcProp() {return objPourcProp;}
        public final void setObjPourcProp(ObjectProperty<Double> value) {this.objPourcProp = value;}
        
    private DoubleProperty temperature = DoubleProperty.doubleProperty(getObjTempProp());
        public DoubleProperty temperatureProperty (){ return temperature;}
        public double getTemperature(){return temperature.get();}
        public final void setTemperature(double temperature){this.temperature.set(temperature);}

    private IntegerProperty maj = new SimpleIntegerProperty();
        public final void setMaj(int value) { maj.set(value); }
        public int getMaj() { return maj.get(); }
        public IntegerProperty majProperty() { return maj; }
    
    private StringProperty nom = new SimpleStringProperty();
        public StringProperty nomProperty() { return nom; }
        public final void setNom(String value){ nom.set(value); }
        public String getNom() { return nom.get(); }
    
    private DoubleProperty pourcent = DoubleProperty.doubleProperty(this.getObjPourcProp());
        public DoubleProperty pourcentProperty (){return pourcent;}
        public double getPourcent(){return pourcent.get();}
        public final void setPourcent(double value){this.pourcent.set(value);}
        
    private final StringProperty min = new SimpleStringProperty();
        public StringProperty minProperty(){return min;}
        public String getMin(){return min.get();}
        public final void setMin(String value){this.min.set(value);}
    private final StringProperty max = new SimpleStringProperty();
        public StringProperty maxProperty(){return max;}
        public String getMax(){return max.get();}
        public final void setMax(String value){this.max.set(value);}

    public abstract void changeTemperature();
    
    public Capteur(double temperature, int maj, String nom){
        setNom(nom);
        setTemperature(temperature);
        setMaj(maj);
    }
    
    @Override
    public String toString(){
        return this.getNom();
    }
    
    public abstract void accepter(IVisiteur v);
}
