/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.PreguntasBL;
import co.edu.udea.encuesta.dto.BancoPreguntasEncuesta;
import java.io.Serializable;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jonathan
 */
@Path("/preguntas")
public class PreguntaServicio implements Serializable{
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<BancoPreguntasEncuesta> getPreguntas(){
        return PreguntasBL.getInstance().getPreguntas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addPregunta(BancoPreguntasEncuesta pregunta){
        return PreguntasBL.getInstance().addPregunta(pregunta);
    }
    
    @PUT
    @Path("/{idPunto}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updatePregunta(BancoPreguntasEncuesta pregunta) throws Exception {
        return PreguntasBL.getInstance().updatePregunta(pregunta);
    }
}
