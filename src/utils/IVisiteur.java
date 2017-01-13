/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import capteurs.MegaCapteur;
import capteurs.SimpleCapteur;

/**
 *
 * @author Morgan
 */
public abstract interface IVisiteur {
    
   public abstract void visiterSimpleCapteur(SimpleCapteur sc);
   
   public abstract void visiterMegaCapteur(MegaCapteur mc);
}
