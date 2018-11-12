package com.zhiqu.jerseyplayground;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * com.zhiqu.jerseyplayground.Main class.
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in this package
        final ResourceConfig rc = new ResourceConfig().packages("com.zhiqu.jerseyplayground");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * com.zhiqu.jerseyplayground.Main method.
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                                         + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}

