package co.edu.unicundi.exception.filter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import co.edu.unicundi.controller.pojo.Error;

/**
 *
 * @author Gambito
 */

@Provider
public class NullPointerExceptionFilter implements ExceptionMapper<NullPointerException>{

    @Override
    public Response toResponse(NullPointerException ex) {
        
        Error error = new Error (ex.getMessage(), "5010", "INTERNAL_SERVER_ERROR");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        
    }
    
    
}
