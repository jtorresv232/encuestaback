/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.PreguntaPorEncuestaDAO;
import co.edu.udea.encuesta.dto.PreguntaPorEncuesta;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class PreguntaPorEncuestaBL implements Serializable{
    
    private static PreguntaPorEncuestaBL singletonInstance = new PreguntaPorEncuestaBL();

    public PreguntaPorEncuestaBL() {
    }
        
        public static PreguntaPorEncuestaBL getInstance() {
        synchronized (PreguntaPorEncuestaBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new PreguntaPorEncuestaBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<PreguntaPorEncuesta> getPreguntas(){
            return obtenerPuntoDAO().getPreguntas();
        
        }
        
        public boolean addPregunta(PreguntaPorEncuesta pregunta){
            return obtenerPuntoDAO().addPregunta(pregunta);
        }
        
        public boolean updatePregunta(PreguntaPorEncuesta pregunta){
            return obtenerPuntoDAO().updatePregunta(pregunta);
        }
        
        private PreguntaPorEncuestaDAO obtenerPuntoDAO() {
        PreguntaPorEncuestaDAO DAO = new PreguntaPorEncuestaDAO();
        return DAO;
    }
    
}
