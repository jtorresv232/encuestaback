/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.RolPuntoDAO;
import co.edu.udea.encuesta.dto.RolPunto;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class RolPuntoBL implements Serializable{
    private static RolPuntoBL singletonInstance = new RolPuntoBL();

    public RolPuntoBL() {
    }
        
        public static RolPuntoBL getInstance() {
        synchronized (RolPuntoBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new RolPuntoBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<RolPunto> getRolesPuntos(){
            return obtenerRolPuntoDAO().getRolesPuntos();
        
        }
        
        public boolean addRolPunto(RolPunto rol){
            return obtenerRolPuntoDAO().addRolPunto(rol);
        }
        
        public boolean updateRolPunto(RolPunto rol){
            return obtenerRolPuntoDAO().updateRolPunto(rol);
        }
        
        private RolPuntoDAO obtenerRolPuntoDAO() {
        RolPuntoDAO DAO = new RolPuntoDAO();
        return DAO;
    }
}
