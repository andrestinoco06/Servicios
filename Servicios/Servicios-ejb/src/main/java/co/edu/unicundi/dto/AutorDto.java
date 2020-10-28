/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.Libro;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johan
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AutorDto implements Serializable{
    
    private Integer id;
    
    private String nombre;
    
    private String apellido;
    
    private Date fecha;

    private boolean estado;
    
    @XmlTransient
    private List<LibroDto> libro;

    public AutorDto() {
    
    }
    
    public AutorDto(Integer id, String nombre, String apellido, Date fecha, List<LibroDto> libro, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.libro = libro;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<LibroDto> getLibro() {
        return libro;
    }

    public void setLibro(List<LibroDto> libro) {
        this.libro = libro;
    }           

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
