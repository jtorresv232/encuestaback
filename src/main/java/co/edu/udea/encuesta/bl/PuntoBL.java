/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.PuntoDAO;
import co.edu.udea.encuesta.dto.PuntoAplicacion;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class PuntoBL implements Serializable{
    
        private static PuntoBL singletonInstance = new PuntoBL();

    public PuntoBL() {
    }
        
        public static PuntoBL getInstance() {
        synchronized (PuntoBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new PuntoBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<PuntoAplicacion> obtenerPuntos(){
            return obtenerPuntoDAO().getPuntos();
        
        }
        
        public boolean agregarPunto(PuntoAplicacion punto){
            return obtenerPuntoDAO().addPunto(punto);
        }
        
        public boolean actualizarPunto(PuntoAplicacion punto){
            return obtenerPuntoDAO().actualizar(punto);
        }
        
        private PuntoDAO obtenerPuntoDAO() {
        PuntoDAO DAO = new PuntoDAO();
        return DAO;
    }

}
