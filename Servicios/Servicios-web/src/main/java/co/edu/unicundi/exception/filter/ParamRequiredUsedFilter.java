/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.exception.ParamUsedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author johan
 */
@Provider
public class ParamRequiredUsedFilter implements ExceptionMapper<ParamUsedException>{

    @Override
    public Response toResponse(ParamUsedException ex) {
        co.edu.unicundi.dto.Error error = new co.edu.unicundi.dto.Error (ex.getMessage(), "400", "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    
}
