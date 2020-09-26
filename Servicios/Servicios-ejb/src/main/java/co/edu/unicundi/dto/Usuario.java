/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author johan
 */
public class Usuario implements Serializable{
    
    private int id;
    
    private String nombre;
    
    private String apellido;

    private List<String> materias;
    
    private String correo;
    
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