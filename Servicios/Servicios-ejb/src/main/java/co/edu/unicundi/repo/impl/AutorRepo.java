/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo.impl;

import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.repo.IAutor;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author johan
 */
@Stateless
public class AutorRepo implements IAutor {

    @PersistenceContext(unitName = "co.edu.unicundi_Servicios-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    @Override
    public List<Autor> listar(boolean filtro) {
        if (filtro == true) {
            TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);
            return listaAutor.getResultList();
        } else {
            TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);
            return listaAutor.getResultList();
        }
    }    
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Autor> listarOpcion3() {
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);                
        return listaAutor.getResultList();
    }

    @Override
    public Autor listarPorId(Integer id) {
        return this.entity.find(Autor.class, id);
    }

    @Override
    public void guardar(Autor autor) {
        this.entity.persist(autor);
    }

    @Override
    public void editar(Autor autor) {
        this.entity.merge(autor);
    }

    @Override
    public void eliminar(Autor autor) {
        this.entity.remove(autor);
    }

    @Override
    public void cambiarEstado(boolean estado, int id) {
        Query query = this.entity.createNamedQuery("Autor.cambiarEstado", Integer.class);
        query.setParameter("estado", estado);
        query.setParameter("id", id);
        /*Query q = entity.createQuery("UPDATE Autor p SET p.estado = :estado WHERE p.id = :id");
        q.setParameter("estado", estado);
        q.setParameter("id", id);
        int updated = q.executeUpdate();*/
    }

    @Override
    public boolean buscarLibrosAutor(int id) {
        Query query = this.entity.createNamedQuery("Autor.buscarCantidadLibros", Integer.class);
        query.setParameter("id", id);
        String p = query.getSingleResult().toString();
        if(parseInt(p)==0){
            return true;
        }else{
            return false;
        }
    }
}
