/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;


import co.edu.unicundi.service.IUsuarioService;
import co.edu.unicundi.service.impl.UsuarioServiceImpl;
import co.edu.unicundi.dto.Usuario;
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
@Path("/usuario")
public class UsuarioController{

    @EJB
    public IUsuarioService serviceProfesor;
    
    /*
        Crea un profesor
    */
    @Path("/crearProfesor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(@Valid Usuario usuario) {
        serviceProfesor.crearProfesor(usuario);
        return Response.status(Response.Status.CREATED).build();
    }

    /*
     Retorna todos los profesores
     */
    @Path("/todosProfesores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response todosProfesores() {
        return Response.status(Response.Status.OK).entity(serviceProfesor.todosProfesores()).build();
    }

    /*
     Edita a los profesores
     */
    @Path("/editarProfesor")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editarProfesor(@Valid Usuario usuario) {
        serviceProfesor.editarProfesor(usuario);
        return Response.status(Response.Status.OK).entity("Se modifico correctamente").build();
    }

    /*
     Elimina a los profesores por id
     */
    @Path("/eliminarProfesor/{numero}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProfesor(@PathParam("numero") int numero) {
        serviceProfesor.eliminarProfesor(numero);
        return Response.status(Response.Status.OK).entity("Se elimino correctamente").build();
    }

    /*
     Busca por cedula al profesor
     */
    @Path("/buscaCedula/{numero}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarCedulaProfesor(@Pattern(regexp = "^([0-9])*$", message = "Formato de cedula incorrecto, indicar valores numéricos sin espacios") @Valid @PathParam("numero") String numero) {
        return Response.status(Response.Status.OK).entity(serviceProfesor.buscarProfesor(numero)).build();
    }

    /*
     Busca a los profesores que corresponden a las materias 
     */
    @Path("/buscaMaterias/{nombre}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarMaterias(@PathParam("nombre") String nombre) {
        return Response.status(Response.Status.OK).entity(serviceProfesor.buscarMaterias(nombre)).build();
    }
  
}