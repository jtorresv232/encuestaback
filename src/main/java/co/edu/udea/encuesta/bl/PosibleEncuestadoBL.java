/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.PosibleEncuestadoDAO;
import co.edu.udea.encuesta.dto.PosibleEncuestado;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class PosibleEncuestadoBL {
    
    private static PosibleEncuestadoBL singletonInstance = new PosibleEncuestadoBL();

    public PosibleEncuestadoBL() {
    }
        
        public static PosibleEncuestadoBL getInstance() {
        synchronized (PosibleEncuestadoBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new PosibleEncuestadoBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<PosibleEncuestado> getPosiblesEncuestados(){
            return obtenerPosibleEncuestadoDAO().getPosiblesEncuestados();
        
        }
        
        public boolean addPosibleEncuestado(PosibleEncuestado posible){
            return obtenerPosibleEncuestadoDAO().addPosible(posible);
        }
        
        public boolean updatePosibleEncuestado(PosibleEncuestado posible){
            return obtenerPosibleEncuestadoDAO().updatePosible(posible);
        }
        
        private PosibleEncuestadoDAO obtenerPosibleEncuestadoDAO() {
        PosibleEncuestadoDAO DAO = new PosibleEncuestadoDAO();
        return DAO;
    }
    
}
