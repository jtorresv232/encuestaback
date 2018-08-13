/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.RelacionSecretaDAO;
import co.edu.udea.encuesta.dto.RelacionSecreta;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class RelacionSecretaBL implements Serializable{
    
    private static RelacionSecretaBL singletonInstance = new RelacionSecretaBL();

    public RelacionSecretaBL() {
    }
        
        public static RelacionSecretaBL getInstance() {
        synchronized (RelacionSecretaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new RelacionSecretaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<RelacionSecreta> getRelaciones(){
            return obtenerRelacionSecretaDAO().getRelaciones();
        
        }
        
        public boolean addRelacion(RelacionSecreta relacion){
            return obtenerRelacionSecretaDAO().addRelacion(relacion);
        }
        
        public boolean updateRelacion(RelacionSecreta relacion){
            return obtenerRelacionSecretaDAO().updateRelacion(relacion);
        }
        
        private RelacionSecretaDAO obtenerRelacionSecretaDAO() {
        RelacionSecretaDAO DAO = new RelacionSecretaDAO();
        return DAO;
    }
    
}
