package org.acme.demo.controller;

import org.acme.demo.FarewellConfiguration;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/farewell")
public class FarewellResource {
    @Inject
    FarewellConfiguration farewellConfiguration;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getFarewellMessage() {
        return farewellConfiguration.message() + " " + farewellConfiguration.name();
    }
}
