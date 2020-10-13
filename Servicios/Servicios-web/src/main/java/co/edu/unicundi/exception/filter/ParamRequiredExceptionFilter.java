/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception.filter;


import co.edu.unicundi.exception.ObjectRequeridException;
import co.edu.unicundi.exception.ParamRequiredException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author johan
 */
public class ParamRequiredExceptionFilter implements ExceptionMapper<ParamRequiredException>{
    
    @Override
    public Response toResponse(ParamRequiredException ex) {
        co.edu.unicundi.dto.Error error = new co.edu.unicundi.dto.Error (ex.getMessage(), "400", "Parametro requerido para la modificación");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    
}
