
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
        
        co.edu.unicundi.controller.pojo.Error error = new co.edu.unicundi.controller.pojo.Error (ex.getMessage(), "500", "INTERNAL_SERVER_ERROR");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        
    }
    
}
