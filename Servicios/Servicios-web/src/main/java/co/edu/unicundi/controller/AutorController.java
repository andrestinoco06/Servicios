/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.dto.AutorDto;
import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.service.IAutorService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @Path("/listar/{filtro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@Valid @PathParam("filtro") boolean filtro)  {
        List<AutorDto> listarAutor = service.listar(filtro);
        return Response.status(Response.Status.OK).entity(listarAutor).build();       
    }        
    
    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        Autor autor = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(autor).build();       
    }      
    
    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Autor autor) {
        System.out.println("        fecha :   " + autor.getFecha());
        
        service.guardar(autor);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();       
    }     
   
    @Path("/bloquear/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response bloquear(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        service.cambiarEstado(false, id);
        return Response.status(Response.Status.OK).build();       
    }      
    
    @Path("/desbloquear/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response desbloquear(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        service.cambiarEstado(true, id);
        return Response.status(Response.Status.OK).build();       
    }      
    
    @Path("/listarGenerico")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarGenerico()  {
        List<AutorDto> listarAutor = service.listarGenerico();
        return Response.status(Response.Status.OK).entity(listarAutor).build();
    }
}
