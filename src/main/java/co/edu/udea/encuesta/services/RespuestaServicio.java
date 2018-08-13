/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.RespuestaBL;
import co.edu.udea.encuesta.dto.Respuesta;
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
@Path("/respuestas")
public class RespuestaServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Respuesta> getRespuestas(){
        return RespuestaBL.getInstance().getRespuestas();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addRespuesta(Respuesta respuesta){
        return RespuestaBL.getInstance().addRespuesta(respuesta);
    }
    
    @PUT
    @Path("/{idRespuesta}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateRespuesta(Respuesta respuesta){
        return RespuestaBL.getInstance().updateRespuesta(respuesta);
    }
}
