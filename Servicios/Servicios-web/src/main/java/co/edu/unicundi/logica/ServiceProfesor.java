/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.logica;

import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ObjectRequeridException;
import co.edu.unicundi.lecturaEscritura.lecturaEscristuraProfesor;
import co.edu.unicundi.pojo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;

/**
 *
 * @author johan
 */
@Named(value = "ServiceProfesor")
@RequestScoped
public class ServiceProfesor {

    public Response crearProfesor(Usuario usuario) {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        boolean validacion = true;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(usuario.getCedula())) {
                System.out.println("ENTRO AL IF ");
                validacion = false;
            }
        }
        if (validacion == true) {
            lista.add(usuario);
            new lecturaEscristuraProfesor().crearArchivo(lista);
            return Response.status(Response.Status.CREATED).build();
        } else if(usuario.getCedula() == null){
            throw new ObjectRequeridException("Hay campos vacíos");
        } else {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity("El numero de cedula ya se encuentra registrado").build();
        }
    }

    public Response todosProfesores() {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        if (lista.size() != 0) {
            return Response.status(Response.Status.OK).entity(lista).build();
        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("No hay profesores registrados").build();
        }
    }

    public Response editarProfesor(Usuario usuario) {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        boolean validacion = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == usuario.getId()) {
                lista.get(i).setNombre(usuario.getNombre());
                lista.get(i).setApellido(usuario.getApellido());
                lista.get(i).setMaterias(usuario.getMaterias());
                lista.get(i).setCedula(usuario.getCedula());
                lista.get(i).setCorreo(usuario.getCorreo());
                validacion = true;
            }
        }
        if (validacion == true) {
            new lecturaEscristuraProfesor().crearArchivo(lista);
            return Response.status(Response.Status.OK).entity("Se ha modificado con éxito").build();
        } else if(usuario.getCedula() == null){
            throw new ObjectRequeridException("Hay campos vacios");
        }
        else {
            throw new ObjectNotFoundException("Materias no encontradas");
        }
    }

    //public Response eliminarProfesor(int id) {
    public void eliminarProfesor(int id) throws ObjectNotFoundException {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        boolean estado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                estado = true;
            }
        }

        if (estado == true) {
            new lecturaEscristuraProfesor().crearArchivo(lista);
            //return Response.status(Response.Status.OK).entity("Se elimino correctamente").build();
        } else {
            throw new ObjectNotFoundException("Profesor no encontrado");
            //return Response.status(Response.Status.EXPECTATION_FAILED).entity("No se encontro el profesor").build();
        }
    }

    public Response buscarProfesor(String numero) {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        Usuario datos = new Usuario();
        boolean estado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(numero)) {
                datos = lista.get(i);
                estado = true;
            }
        }
        if (estado == true) {
            return Response.status(Response.Status.OK).entity(datos).build(); 
        } else if(numero == null){
            throw new ObjectRequeridException("Hay campos vacios");
        }else {
            throw new ObjectNotFoundException("Profesor no encontrado");
            //return Response.status(Response.Status.EXPECTATION_FAILED).entity("No se encontro ningún profesor").build();
        }
    }

    public Response buscarMaterias(String nombre) {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        List<Usuario> busqueda = new ArrayList<>();
        boolean estado = false;
        
        for (int i = 0; i < lista.size(); i++) {
            List<String> materias = lista.get(i).getMaterias();
            for (int x = 0; x < materias.size(); x++) {
                if (materias.get(x).equals(nombre)) {
                    busqueda.add(lista.get(i));
                    estado = true;
                }
            }
        }
        if (estado == true) {
            return Response.status(Response.Status.OK).entity(busqueda).build();
        } else if(nombre == null){
            throw new ObjectRequeridException("Hay campos vacios");
        } else {
            throw new ObjectNotFoundException("Materias no encontradas");
            //return Response.status(Response.Status.EXPECTATION_FAILED).entity("No se encontro profesores").build();
        }
    }
}
