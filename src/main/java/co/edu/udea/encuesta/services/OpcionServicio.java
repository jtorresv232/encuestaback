/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.OpcionBL;
import co.edu.udea.encuesta.dto.Opcion;
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
@Path("/opciones")
public class OpcionServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public Collection<Opcion> getOpciones(){
        return OpcionBL.getInstance().getOpciones();
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addOpcion(Opcion opcion){
        return OpcionBL.getInstance().addOpcion(opcion);
    }
    
    @PUT
    @Path("/{idOpcion}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateOpcion(Opcion opcion){
        return OpcionBL.getInstance().updateOpcion(opcion);
    }
    
}