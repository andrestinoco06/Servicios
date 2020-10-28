/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service;

import co.edu.unicundi.dto.AutorDto;
import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.exception.ObjectNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface IAutorService {
    
    public List<AutorDto> listar(boolean filtro);
    
    public Autor listarPorId(Integer id) throws ObjectNotFoundException;
    
    public void guardar(Autor autor);
    
    public void editar(Autor autor);
   
    public void eliminar(Integer id) throws  ObjectNotFoundException;
    
    public void cambiarEstado(boolean estado, int id) throws  ObjectNotFoundException;
    
    
}
