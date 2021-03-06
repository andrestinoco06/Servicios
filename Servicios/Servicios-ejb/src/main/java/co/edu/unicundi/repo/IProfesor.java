/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo;

import co.edu.unicundi.entity.Profesor;
import co.edu.unicundi.exception.ObjectNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface IProfesor {
    
    public List<Profesor> listar();
    
    public Profesor listarPorId(Integer id);
    
    public void editar(Profesor profesor);
    
    public void guardar(Profesor profesor);
    
    public void eliminar(Profesor profesor);
    
    public Integer validarCedula(String cedula, Integer id);
    
    public Integer validarCorreo(String correo, Integer id);
    
    public Integer buscarCorreo(String correo);
    
    public Integer buscarCedula(String cedula);
}
