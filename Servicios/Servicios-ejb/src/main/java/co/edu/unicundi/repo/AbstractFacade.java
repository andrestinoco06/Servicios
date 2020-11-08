/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author johan
 */
public abstract class AbstractFacade<T, V> {
      
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();    
    
    /*public List<T> listar() {
        TAREA
    }*/
    
    public T listarPorId(V id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public void guardar(T entity) {
        getEntityManager().persist(entity);
    }
    
    public void editar(T entity) {
         getEntityManager().merge(entity);
    }
   
    public void eliminar(T entity) {
        getEntityManager().remove(entity);
    }
    
    public List<T> listarGenericoA(String nombreFuncion){
        TypedQuery<T> lista = this.getEntityManager().createNamedQuery(nombreFuncion, entityClass);                
        return lista.getResultList();
    }
    
}