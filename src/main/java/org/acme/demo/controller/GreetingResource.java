package org.acme.demo.controller;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.acme.demo.service.FactorService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.reactive.RestSseElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Inject
    FactorService factorService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy already";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public Uni<String> greeting(@PathParam String name) {
        return factorService.uniGreeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{count}/{name}")
    public Multi<String> greetings(@PathParam int count, @PathParam String name) {
        return factorService.greetings(count, name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RestSseElementType(MediaType.TEXT_PLAIN)
    @Path("/stream/{count}/{name}")
    public Multi<String> greetingsAsStream(@PathParam int count, @PathParam String name) {
        return factorService.greetings(count, name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RestSseElementType(MediaType.APPLICATION_JSON)
    @Path("/uni/{count}/{name}")
    public Uni<List<String>> uniList(@PathParam int count, @PathParam String name) {
        return factorService.collectItems(count, name);
    }

}