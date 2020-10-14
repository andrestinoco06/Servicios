/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.repo.IAutorService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Gambito
 */


@Stateless
@Path("/autores")
public class AutorController {
    
    
    @EJB
    private IAutorService service;
    
    
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listar() {
         List<Autor> autor = service.listar();
        return Response.status(Response.Status.OK).entity(autor).build();
    }
    
   
}
