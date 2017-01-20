/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteurs;

import java.io.Serializable;
import javafx.beans.Observable;

/**
 *
 * @author samue
 */
public abstract class Strategie implements Observable,Serializable{
    public static final int MIN = -10;
    public static final int MAX = 40;
    
    public abstract double changementTemperature();
    public Integer getMin(){
        return MIN;
    }
    public Integer getMax(){
        return MAX;
    }
}
