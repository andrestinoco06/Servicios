/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.service.IProfesorService;

import java.io.Serializable;
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
    
}
