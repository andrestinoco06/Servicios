
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.exception.ObjectNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import co.edu.unicundi.controller.pojo.Error;

/**
 *
 * @author Gambito
 */

@Provider
public class ObjectNotFoundExceptionFilter implements ExceptionMapper<ObjectNotFoundException>{

    @Override
    public Response toResponse(ObjectNotFoundException ex) {
        
        Error error = new Error (ex.getMessage(), "404", "NOT_FOUND");
        return Response.status(Response.Status.NO_CONTENT).entity(error).build();
        
    }
    
}
