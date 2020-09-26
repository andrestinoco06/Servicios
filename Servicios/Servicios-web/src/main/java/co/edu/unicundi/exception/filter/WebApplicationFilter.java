package co.edu.unicundi.exception.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Gambito
 */

@Provider
public class WebApplicationFilter implements ExceptionMapper<WebApplicationException>{

    @Override
    public Response toResponse(WebApplicationException ex) {
        co.edu.unicundi.dto.Error error = new co.edu.unicundi.dto.Error (ex.getMessage(), "404", "NOT_FOUND");
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        
    }
    
}
