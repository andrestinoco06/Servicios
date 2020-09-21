/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.exception.ObjectExistingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import co.edu.unicundi.controller.pojo.Error;


/**
 *
 * @author johan
 */
public class ObjetcExistingExceptionFilter implements ExceptionMapper<ObjectExistingException>{

    @Override
    public Response toResponse(ObjectExistingException ex) {
        Error error = new Error (ex.getMessage(), "412", "PRECONDITION_FAILED");
        return Response.status(Response.Status.PRECONDITION_FAILED).entity(error).build();
    }
    
}
