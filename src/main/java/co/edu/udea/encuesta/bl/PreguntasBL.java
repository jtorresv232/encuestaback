/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.bl;

import co.edu.udea.encuesta.dao.impl.PreguntasDAO;
import co.edu.udea.encuesta.dto.BancoPreguntasEncuesta;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonathan
 */
public class PreguntasBL implements Serializable{
    private static PreguntasBL singletonInstance = new PreguntasBL();

    public PreguntasBL() {
    }
        
        public static PreguntasBL getInstance() {
        synchronized (PreguntasBL.class) {
            if (singletonInstance == null) { 
                singletonInstance = new PreguntasBL();
            }
        }
        return singletonInstance;
    }
        
        public Collection<BancoPreguntasEncuesta> getPreguntas(){
            return obtenerPreguntasDAO().getPreguntas();
        
        }
        
        public boolean addPregunta(BancoPreguntasEncuesta pregunta){
            System.out.println("llame metodo en el bl");
            return obtenerPreguntasDAO().addPregunta(pregunta);
        }
        
        public boolean updatePregunta(BancoPreguntasEncuesta pregunta){
            return obtenerPreguntasDAO().updatePregunta(pregunta);
        }
        
        private PreguntasDAO obtenerPreguntasDAO() {
        PreguntasDAO DAO = new PreguntasDAO();
        return DAO;
    }

}
