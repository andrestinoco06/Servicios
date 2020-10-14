/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo;

import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.Profesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gambito
 */
@Local
public interface IAutorRepo {
    
     public List<Autor> listar();
    
    public Profesor listarPorId(Integer id);
    
    public void editar(Autor autor);
    
    public void guardar(Autor autor);
    
    public void eliminar(Autor autor);
}
