package org.acme.demo.controller;

import org.acme.demo.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/prize")
public class PrizeResource {

    @Inject
    GreetingService factorConfigService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPrizeMessage() {
        return factorConfigService.greetingMessage();
    }
}
