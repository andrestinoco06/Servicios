/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service;

import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.exception.ParamUsedException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface IProfesorService {
    
    public List<Profesor> listar();
    
    public Profesor listarPorId(Integer id) throws ObjectNotFoundException;
    
    public void editar(Profesor profesor) throws ObjectNotFoundException, ParamRequiredException, ParamUsedException;
    
    public void guardar(Profesor profesor) throws ParamUsedException;
    
    public void eliminar(Integer id);
    
}