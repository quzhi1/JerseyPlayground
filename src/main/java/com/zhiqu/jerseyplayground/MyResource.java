package com.zhiqu.jerseyplayground;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("hello")
public class MyResource {

    /**
     * Get it method
     *
     * @return "Got it!"
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    /**
     * URL parameter
     *
     * @return param in URL
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/echo/{param}")
    public String urlParam(@PathParam("param") String param) {
        return param;
    }
}
