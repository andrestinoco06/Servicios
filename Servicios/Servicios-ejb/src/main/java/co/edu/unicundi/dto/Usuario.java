/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johan
 */
public class Usuario implements Serializable{
    
    @NotNull (message="Campo requerido= Id")
    private int id;
    
    @NotNull (message="Campo requerido= Nombre")
    private String nombre;
    
    @NotNull (message="Campo requerido= Apellido")
    private String apellido;

    @NotNull (message="Campo requerido= Materias")
    private List<String> materias;
    
    @NotNull (message="Campo requerido= Correo")
    private String correo;
    
    @NotNull (message="Campo requerido= Cedula")
    @Min (value =9999, message= "Formato Incorrecto")
    private String cedula;
    
    public Usuario(){
        
    }
    
    public Usuario(int id, String nombre, String apellido, List<String> materias, String correo, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = materias;
        this.correo = correo;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}