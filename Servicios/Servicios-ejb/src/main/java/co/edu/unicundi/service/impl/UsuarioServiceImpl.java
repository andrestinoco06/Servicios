/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service.impl;

import co.edu.unicundi.dto.Usuario;
import co.edu.unicundi.exception.ObjectExistingException;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ObjectRequeridException;
import co.edu.unicundi.lecturaEscritura.lecturaEscristuraProfesor;
import co.edu.unicundi.service.IUsuarioService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ws.rs.core.Response;

/**
 *
 * @author johan
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UsuarioServiceImpl implements IUsuarioService{

    @Override
    public void crearProfesor(Usuario usuario) throws ObjectRequeridException, ObjectExistingException {
        System.out.println("entro  ------ ");
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        System.out.println("lee lista  ------ ");
        boolean validacion = true;
        if (usuario.getCedula() == null || usuario.getNombre() == null || usuario.getApellido() == null || usuario.getCorreo() == null || usuario.getCorreo() == null || usuario.getId() == 0) {
            validacion = false;
            System.out.println("campos vacios  ------ ");
            throw new ObjectRequeridException("Hay campos vacíos");
        }
        /*if (validacion == true) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCedula() != null) {
                    if (lista.get(i).getCedula().equals(usuario.getCedula())) {
                        validacion = false;
                        throw new ObjectExistingException("Cedula existente");
                    }
                }
                if (usuario.getId() != 0) {
                    if (lista.get(i).getId() == usuario.getId()) {
                        validacion = false;
                        throw new ObjectExistingException("Id existente");
                    }
                }
            }
        }*/
        lista.add(usuario);
        new lecturaEscristuraProfesor().crearArchivo(lista);
        
    }

    @Override
    public List<Usuario> todosProfesores() {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        if (lista.size() == 0) {
            throw new ObjectNotFoundException("No hay profesores registrados");
        }
        return lista;
    }

    @Override
    public void editarProfesor(Usuario usuario) {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        boolean validacion = false;
        if (usuario.getCedula() == null || usuario.getNombre() == null || usuario.getApellido() == null || usuario.getCorreo() == null || usuario.getCorreo() == null || usuario.getId() == 0) {
            throw new ObjectRequeridException("Hay campos vacios");
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula() == usuario.getCedula() && lista.get(i).getId() != usuario.getId()) {
                throw new ObjectExistingException("Cedula existente");
            }
        }
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
        } else {
            throw new ObjectNotFoundException("Materias no encontradas");
        }
    }

    @Override
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
        } else {
            throw new ObjectNotFoundException("Profesor no encontrado");
        }
    }

    @Override
    public List<Usuario> buscarProfesor(String numero) {
        
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        Usuario datos = new Usuario();
        boolean estado = false;
        if (numero == null) {
            throw new ObjectRequeridException("Hay campos vacios");
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(numero)) {
                datos = lista.get(i);
                estado = true;
            }
        }
        if (estado == true) {
            return lista;
        } else {
            throw new ObjectNotFoundException("Profesor no encontrado");
        }
        
    }

    @Override
    public List<Usuario> buscarMaterias(String nombre) {
        List<Usuario> lista = new lecturaEscristuraProfesor().verProfesor();
        List<Usuario> busqueda = new ArrayList<>();
        boolean estado = false;

        if (nombre == null) {
            throw new ObjectRequeridException("Hay campos vacios");
        }

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
            return busqueda;
        } else {
            throw new ObjectNotFoundException("Materias no encontradas");
        }
    }
}