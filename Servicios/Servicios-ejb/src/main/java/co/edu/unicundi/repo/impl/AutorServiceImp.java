/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo.impl;

import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.repo.IAutorRepo;
import co.edu.unicundi.repo.IAutorService;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Gambito
 */
public class AutorServiceImp implements IAutorService{
    
    @EJB
    private IAutorRepo repo;

    @Override
    public List<Autor> listar() {
        return repo.listar();
    }

    @Override
    public Profesor listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Autor autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(Autor autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
