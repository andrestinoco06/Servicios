package co.edu.unicundi.exception.filter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import co.edu.unicundi.controller.pojo.Error;
import co.edu.unicundi.exception.ObjectRequeridException;

/**
 *
 * @author Gambito
 */

@Provider
public class ObjectRequeridExceptionFilter implements ExceptionMapper<ObjectRequeridException>{

    @Override
    public Response toResponse(ObjectRequeridException ex) {
        
        Error error = new Error (ex.getMessage(), "400", "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    
    
    
}
