/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.listarTodo", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.validarCedula", query = "SELECT COUNT(p.cedula)  FROM Profesor p WHERE p.cedula = :cedula AND p.id <> :id"),
    @NamedQuery(name = "Profesor.validarCorreo", query = "SELECT COUNT(p.correo)  FROM Profesor p WHERE p.correo = :correo AND p.id <> :id"),
    @NamedQuery(name = "Profesor.buscarCedula", query = "SELECT COUNT(p.cedula) FROM Profesor p WHERE p.cedula = :cedula"),
    @NamedQuery(name = "Profesor.buscarCorreo", query = "SELECT COUNT(p.correo) FROM Profesor p WHERE p.correo = :correo")
})
public class Profesor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message="Nombre requerido")
    @Size(max=25)
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @NotNull(message="Apellido requerido")
    @Size(max=25)
    @Column(name = "apellido", length = 25, nullable = false)
    private String apellido;
    
    @NotNull(message="Cedula requerido")
    @Size(max=10)
    @Column(name = "cedula", length = 10, nullable = false, unique = true)
    private String cedula;
    
    @NotNull(message="Correo requerido")
    @Pattern(message = "Error, correo del profesor invalido", regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")
    @Column(name = "correo", length = 60, nullable = false, unique = true)
    private String correo;
    
    @NotNull(message="Edad requerido")
    @Min(value = 18, message="Minimo 18")
    @Column(name = "edad", nullable = false)
    private Integer edad;

    @NotNull(message="Fecha de nacimiento requerida")
    @Pattern(message = "Error, formato de fecha dd/mm/aaaa", regexp = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$")
    @Column(name = "fecha", length = 25, nullable = false)
    private String fecha;
    
    public Profesor(){
        
    }
    
    public Profesor(Integer id, String nombre, String apellido, String cedula, String correo, Integer edad, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.edad = edad;
        this.fecha = fecha;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}