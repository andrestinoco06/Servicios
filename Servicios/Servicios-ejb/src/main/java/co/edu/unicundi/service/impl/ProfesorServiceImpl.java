/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service.impl;

import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.exception.ParamUsedException;
import co.edu.unicundi.repo.IProfesor;
import co.edu.unicundi.service.IProfesorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author johan
 */
@Stateless
public class ProfesorServiceImpl implements IProfesorService{

    @EJB
    private IProfesor repo;
    
    @Override
    public List<Profesor> listar() {
        return repo.listar();
    }

    @Override
    public Profesor listarPorId(Integer id) throws ObjectNotFoundException {
        Profesor profesor = repo.listarPorId(id);
        if(profesor!=null){
            return profesor;
        }else{
            throw new ObjectNotFoundException("Profesor no existe");
        }
    }

    @Override
    public void editar(Profesor profesor) throws ObjectNotFoundException, ParamRequiredException, ParamUsedException {
        if(profesor.getId() == null){
            throw new ParamRequiredException("Id requerido para la edición");
        }else{
            this.listarPorId(profesor.getId());
            Integer validacion = repo.validarCedula(profesor.getCedula(), profesor.getId());
            Integer validacionCorreo = repo.validarCorreo(profesor.getCorreo(), profesor.getId());
            if(validacion != 0){
                throw new ParamUsedException("Error, cedula existente");
            }
            if(validacionCorreo != 0){
                throw new ParamUsedException("Error, correo existente");
            }
            repo.editar(profesor);
        }
    }

    @Override
    public void guardar(Profesor profesor) throws ParamUsedException{
        Integer validacionCorreo = repo.buscarCorreo(profesor.getCorreo());
        Integer validacionCedula = repo.buscarCedula(profesor.getCedula());
        if(validacionCedula != 0){
            throw new ParamUsedException("Error, cedula existente");
        }
        if(validacionCorreo != 0){
            throw new ParamUsedException("Error, correo existente");
        }
        repo.guardar(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        try {
            Profesor profesor = this.listarPorId(id);
            if(profesor == null){
                throw new ObjectNotFoundException("Profesor no existe");
            }else{
                repo.eliminar(profesor);
            }
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(ProfesorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
