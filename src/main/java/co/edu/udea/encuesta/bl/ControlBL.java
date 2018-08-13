/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.ControlSecretoDAO;
import co.edu.udea.encuesta.dto.ControlSecreto;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class ControlBL implements Serializable{
    private static ControlBL singletonInstance = new ControlBL();

    public ControlBL() {
    }
    
    
    public static ControlBL getInstance(){
        synchronized (ControlBL.class)  {
            if(singletonInstance == null){
                singletonInstance = new ControlBL();
            }
        }
        return singletonInstance;
    }
    
    public boolean addControl(ControlSecreto control){
        return obtenerControlDAO().addControl(control);
    }
    
    public boolean updateControl(ControlSecreto control){
        return obtenerControlDAO().update(control);
    }
    
    public Collection<ControlSecreto> getControles(){
        return obtenerControlDAO().getControles();
    }
    
    private ControlSecretoDAO obtenerControlDAO(){
        ControlSecretoDAO DAO = new ControlSecretoDAO();
        return DAO;
    }
    
}
