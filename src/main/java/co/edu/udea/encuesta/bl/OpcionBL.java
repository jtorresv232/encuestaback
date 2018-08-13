/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.OpcionDAO;
import co.edu.udea.encuesta.dto.Opcion;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class OpcionBL implements Serializable{
    
    private static OpcionBL singletonInstance = new OpcionBL();

    public OpcionBL() {
    }
        
        public static OpcionBL getInstance() {
        synchronized (OpcionBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new OpcionBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<Opcion> getOpciones(){
            return obtenerPuntoDAO().getOpciones();
        
        }
        
        public boolean addOpcion(Opcion opcion){
            return obtenerPuntoDAO().addOpcion(opcion);
        }
        
        public boolean updateOpcion(Opcion opcion){
            return obtenerPuntoDAO().updateOpcion(opcion);
        }
        
        private OpcionDAO obtenerPuntoDAO() {
        OpcionDAO DAO = new OpcionDAO();
        return DAO;
    }
}
