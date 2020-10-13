/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo.impl;

import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.repo.IProfesor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
        TypedQuery<Profesor> listaProfesor = this.entity.createNamedQuery("Profesor.listarTodo", Profesor.class);
        return listaProfesor.getResultList();
    }

    @Override
    public Profesor listarPorId(Integer id){
        return this.entity.find(Profesor.class, id);
    }

    @Override
    public void editar(Profesor profesor) {
        entity.merge(profesor);
    }

    @Override
    public void guardar(Profesor profesor) {
        this.entity.persist(profesor);
    }

    @Override
    public void eliminar(Profesor profesor) {
        this.entity.remove(profesor);
    }

    @Override
    public Integer validarCedula(String cedula, Integer id) {
        Query query = this.entity.createNamedQuery("Profesor.validarCedula", Integer.class);
        query.setParameter("cedula", cedula);
        query.setParameter("id", id);
        return (Integer) query.getSingleResult();
    }
    
}
