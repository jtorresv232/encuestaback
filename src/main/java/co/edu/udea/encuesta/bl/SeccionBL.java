/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.SeccionDAO;
import co.edu.udea.encuesta.dto.Seccion;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class SeccionBL implements Serializable{
    private static SeccionBL singletonInstance = new SeccionBL();

    public SeccionBL() {
    }
        
        public static SeccionBL getInstance() {
        synchronized (SeccionBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new SeccionBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<Seccion> getSecciones(){
            return obtenerSeccionDAO().getSecciones();
        
        }
        
        public boolean addSeccion(Seccion seccion){
            return obtenerSeccionDAO().addSeccion(seccion);
        }
        
        public boolean updateSeccion(Seccion seccion){
            return obtenerSeccionDAO().updateSeccion(seccion);
        }
        
        private SeccionDAO obtenerSeccionDAO() {
        SeccionDAO DAO = new SeccionDAO();
        return DAO;
    }
}
