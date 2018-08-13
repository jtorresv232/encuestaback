/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.encuesta.services;

import co.edu.udea.encuesta.bl.RolPuntoBL;
import co.edu.udea.encuesta.dto.RolPunto;
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
@Path("/rolXpunto")
public class RolPuntoServicio implements Serializable{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<RolPunto> getRolesPuntos(){
        return RolPuntoBL.getInstance().getRolesPuntos();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addRolPregunta(RolPunto rol){
        return RolPuntoBL.getInstance().addRolPunto(rol);
    }
    
    @PUT
    @Path("/{idRolPunto}") 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateRolPunto(RolPunto rol){
        return RolPuntoBL.getInstance().updateRolPunto(rol);
    }
}
