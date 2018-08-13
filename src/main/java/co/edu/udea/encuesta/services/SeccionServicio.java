/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.SeccionBL;
import co.edu.udea.encuesta.dto.Seccion;
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
@Path("/secciones")
public class SeccionServicio {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Seccion> getSecciones(){
        return SeccionBL.getInstance().getSecciones();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addSeccion(Seccion seccion){
        return SeccionBL.getInstance().addSeccion(seccion);
    }
    
    @PUT
    @Path("/{idSeccion}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateSeccion(Seccion seccion){
        return SeccionBL.getInstance().updateSeccion(seccion);
    }
    
}
