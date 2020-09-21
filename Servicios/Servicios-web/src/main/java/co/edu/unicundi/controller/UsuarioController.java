/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.logica.ServiceProfesor;
import co.edu.unicundi.pojo.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

    @Inject
    private ServiceProfesor serviceProfesor;
    
    /*
        Crea un profesor
    */
    @Path("/crearProfesor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario usuario) {
        return serviceProfesor.crearProfesor(usuario);
    }

    /*
     Retorna todos los profesores
     */
    @Path("/todosProfesores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response todosProfesores() {
        System.out.println("entro al servicio");
        return serviceProfesor.todosProfesores();
    }

    /*
     Edita a los profesores
     */
    @Path("/editarProfesor")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editarProfesor(Usuario usuario) {
        return serviceProfesor.editarProfesor(usuario);
    }

    /*
     Elimina a los profesores por id
     */
    @Path("/eliminarProfesor/{numero}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarProfesor(@PathParam("numero") int numero) {
        return serviceProfesor.eliminarProfesor(numero);
    }

    /*
     Busca por cedula al profesor
     */
    @Path("/buscaCedula/{numero}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarCedulaProfesor(@PathParam("numero") String numero) {
        return serviceProfesor.buscarProfesor(numero);
    }

    /*
     Busca a los profesores que corresponden a las materias 
     */
    @Path("/buscaMaterias/{nombre}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarMaterias(@PathParam("nombre") String nombre) {
        return serviceProfesor.buscarMaterias(nombre);
    }

}