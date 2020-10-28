
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.exception.ObjectNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import co.edu.unicundi.dto.Error;

/**
 *
 * @author Gambito
 */

@Provider
public class ObjectNotFoundExceptionFilter implements ExceptionMapper<ObjectNotFoundException>{

    @Override
    public Response toResponse(ObjectNotFoundException ex) {
        
        Error error = new Error (ex.getMessage(), "409", "CONFLICT");
        return Response.status(Response.Status.CONFLICT).entity(error).build();
        
    }
    
}
