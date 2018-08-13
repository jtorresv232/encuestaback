/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.DerivadaDAO;
import co.edu.udea.encuesta.dto.Derivada;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class DerivadaBL implements Serializable{
    private static DerivadaBL singletonInstance = new DerivadaBL();

    public DerivadaBL() {
    }
        
        public static DerivadaBL getInstance() {
        synchronized (DerivadaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new DerivadaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<Derivada> getDerivadas(){
            return obtenerDerivadaDAO().getDerivadas();
        
        }
        
        public boolean addDerivadas(Derivada derivada){
            return obtenerDerivadaDAO().addDerivada(derivada);
        }
        
        public boolean updateDerivadas(Derivada derivada){
            return obtenerDerivadaDAO().updateDerivada(derivada);
        }
        
        private DerivadaDAO obtenerDerivadaDAO() {
        DerivadaDAO DAO = new DerivadaDAO();
        return DAO;
    }
}
