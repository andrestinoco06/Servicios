package co.edu.unicundi.controller.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Gambito
 */
public class Error implements Serializable{
    
    private String error, codigo, nombreCodigo;
    private LocalDateTime fecha;

    public Error(String error, String codigo, String nombreCodigo) {
        this.error = error;
        this.codigo = codigo;
        this.nombreCodigo = nombreCodigo;
        this.fecha = LocalDateTime.now();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCodigo() {
        return nombreCodigo;
    }

    public void setNombreCodigo(String nombreCodigo) {
        this.nombreCodigo = nombreCodigo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
