/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS-PC
 */
@Entity
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Table(name = "autor")
@NamedQueries({
    @NamedQuery(name = "Autor.listarTodo", query = "SELECT a FROM Autor a "),
    @NamedQuery(name = "Autor.listarAutores", query = "SELECT a.id, a.nombre, a.apellido, a.fecha FROM Autor a"),
    @NamedQuery(name = "Autor.buscarCantidadLibros", query = "SELECT COUNT(a.autor) FROM Libro a WHERE a.autor = :id"),
    @NamedQuery(name = "Autor.cambiarEstado", query = "UPDATE Autor p SET p.estado = :estado WHERE p.id = :id")
})
public class Autor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @XmlTransient
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Libro> libro;

    @Column(name = "estado", nullable = false)
    private boolean estado;
    
    public Autor() {
    
    }
    
    public Autor(Integer id, String nombre, String apellido, Date fecha, List<Libro> libro, boolean estado) {
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
        /*DateFormat df = new SimpleDateFormat("yy:MM:dd:HH:mm:ss");
        return df.format(fecha);*/
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }            

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }   
}