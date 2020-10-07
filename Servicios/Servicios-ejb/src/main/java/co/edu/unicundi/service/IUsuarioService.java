/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service;

import co.edu.unicundi.dto.Usuario;
import co.edu.unicundi.exception.ObjectExistingException;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ObjectRequeridException;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.Response;

/**
 *
 * @author johan
 */
@Local
public interface IUsuarioService {
    
    public void crearProfesor(Usuario usuario) throws ObjectRequeridException, ObjectExistingException;
    
    public List<Usuario> todosProfesores() throws ObjectNotFoundException;
    
    public void editarProfesor(Usuario usuario) throws ObjectRequeridException, ObjectExistingException, ObjectNotFoundException;
    
    public void eliminarProfesor(int id) throws ObjectNotFoundException;
    
    public List<Usuario> buscarProfesor(String numero) throws ObjectRequeridException, ObjectNotFoundException;
    
    public List<Usuario> buscarMaterias(String nombre) throws ObjectRequeridException, ObjectNotFoundException;    
}