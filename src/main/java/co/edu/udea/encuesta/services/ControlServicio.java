/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.ControlBL;
import co.edu.udea.encuesta.dto.ControlSecreto;
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
@Path("/controles")
public class ControlServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ControlSecreto> getControles(){
        return ControlBL.getInstance().getControles();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addControl(ControlSecreto control){
        return ControlBL.getInstance().addControl(control);
    }
    
    @PUT
    @Path("/{idControl}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateControl(ControlSecreto control){
        return ControlBL.getInstance().updateControl(control);
    }
    
}
