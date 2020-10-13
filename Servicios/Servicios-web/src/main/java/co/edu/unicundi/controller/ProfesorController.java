/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.exception.ParamUsedException;
import co.edu.unicundi.service.IProfesorService;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
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
 * @author johan
 */
@Stateless
@Path("/profesor")
public class ProfesorController {
    
    @EJB
    public IProfesorService serviceProfesor;
    
    /*
        Crea un profesor
    */
    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Profesor profesor) {
        serviceProfesor.guardar(profesor);
        return Response.status(Response.Status.CREATED).build();
    }
    
    /*
        Crea un profesor
    */
    @Path("/eliminar/{numero}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminar(@Valid @PathParam("numero") Integer id) {
        serviceProfesor.eliminar(id);
        return Response.status(Response.Status.OK).build();
    }
    
    /*
        Crea un profesor
    */
    @Path("/buscarPorId/{numero}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@Valid @PathParam("numero") Integer id) throws ObjectNotFoundException {
        Profesor profesor = serviceProfesor.listarPorId(id);
        return Response.status(Response.Status.OK).entity(profesor).build();
    }
    
    /*
        Crea un profesor
    */
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listar() {
         List<Profesor> profesor = serviceProfesor.listar();
        return Response.status(Response.Status.OK).entity(profesor).build();
    }
    
    /*
        Crea un profesor
    */
    @Path("/editar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Profesor profesor) throws ObjectNotFoundException, ParamRequiredException, ParamUsedException {
        serviceProfesor.editar(profesor);
        return Response.status(Response.Status.OK).build();
    }
}