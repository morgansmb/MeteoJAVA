/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import javafx.beans.Observable;

/**
 *
 * @author samue
 */
public interface Strategie extends Observable{
    
    public double changementTemperature();
}
