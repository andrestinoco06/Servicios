/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo.impl;

import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.repo.IProfesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johan
 */
@Stateless
public class ProfesorRepo implements IProfesor{

    @PersistenceContext(unitName = "co.edu.unicundi_Servicios-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;
    
    @Override
    public List<Profesor> listar() {
        return null;
    }

    @Override
    public Profesor listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Profesor profesor) {
        this.entity.persist(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
