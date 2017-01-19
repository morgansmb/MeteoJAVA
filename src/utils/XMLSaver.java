/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Morgan
 */
public class XMLSaver {
    
    private XMLSaver() {}
    
    public static void sauvegarderXML(Object o, String filename) throws FileNotFoundException, IOException{
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(filename));
        try{
            encoder.writeObject(o);
            encoder.flush();
        }
        finally{
            encoder.close();
        }
    }
    
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
