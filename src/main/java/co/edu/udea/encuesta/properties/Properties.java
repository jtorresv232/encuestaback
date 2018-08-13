/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.properties;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 *
 * @author Jonathan
 */
public class Properties implements Serializable {
    private static Properties singletonProperties = new Properties();
    private ResourceBundle encuestasProperties = ResourceBundle.getBundle("encuestas");

    public Properties() {
    }
    
    public static Properties getInstance(){
        synchronized(Properties.class){
        if (singletonProperties == null){
            singletonProperties = new Properties();
        }}
    return singletonProperties;
    }

    public ResourceBundle getEncuestasProperties() {
        return encuestasProperties;
    }
    
    
    
}
