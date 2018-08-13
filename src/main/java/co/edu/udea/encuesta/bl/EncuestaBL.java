/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.EncuestaDAO;
import co.edu.udea.encuesta.dto.Encuestas;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class EncuestaBL implements Serializable{
    private static EncuestaBL singletonInstance = new EncuestaBL();

    public EncuestaBL() {
    }
        
        public static EncuestaBL getInstance() {
        synchronized (EncuestaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new EncuestaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<Encuestas> getEncuestas(){
            return obtenerEncuestaDAO().getEncuestas();
        
        }
        
        public boolean addEncuestas(Encuestas encuesta){
            return obtenerEncuestaDAO().addEncuest(encuesta);
        }
        
        public boolean updateEncuestas(Encuestas encuesta){
            return obtenerEncuestaDAO().updateEncuesta(encuesta);
        }
        
        private EncuestaDAO obtenerEncuestaDAO() {
        EncuestaDAO DAO = new EncuestaDAO();
        return DAO;
    }
}
