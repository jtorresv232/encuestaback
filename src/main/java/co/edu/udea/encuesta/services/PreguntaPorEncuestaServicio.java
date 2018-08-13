/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.PreguntaPorEncuestaBL;
import co.edu.udea.encuesta.dto.PreguntaPorEncuesta;
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
@Path("/preguntaXEncuesta")
public class PreguntaPorEncuestaServicio {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PreguntaPorEncuesta> getPreguntas(){
        return PreguntaPorEncuestaBL.getInstance().getPreguntas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addPregunta(PreguntaPorEncuesta pregunta){
        return PreguntaPorEncuestaBL.getInstance().addPregunta(pregunta);
    }
    
    @PUT
    @Path("/{idPreguntaXEncuesta}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updatePregunta(PreguntaPorEncuesta pregunta){
        return PreguntaPorEncuestaBL.getInstance().updatePregunta(pregunta);
    }
    
    
    
}