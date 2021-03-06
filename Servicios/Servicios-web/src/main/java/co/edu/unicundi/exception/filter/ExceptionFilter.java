
package co.edu.unicundi.exception.filter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Gambito
 */

@Provider
public class ExceptionFilter implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception ex) {
        
        co.edu.unicundi.dto.Error error = new co.edu.unicundi.dto.Error (ex.getMessage(), "508", "INTERNAL_SERVER_ERROR");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        
    }
    
}
