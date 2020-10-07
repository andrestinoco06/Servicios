/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service;

import co.edu.unicundi.entity.Profesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface IProfesorService {
    
    public List<Profesor> listar();
    
    public Profesor listarPorId(Integer id);
    
    public void editar(Profesor profesor);
    
    public void guardar(Profesor profesor);
    
    public void eliminar(Integer id);
    
}