/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Morgan
 */
public class XMLLoader {
    
    private XMLLoader() {}
    
    public static Object ouvrirXML(String filename) throws FileNotFoundException, IOException{
        Object object = null;
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(filename));
        try{
            object = decoder.readObject();
        }
        finally{
            decoder.close();
        }
        return object;            
    }
}
