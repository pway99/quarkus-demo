package org.acme.factor.controller;

import org.acme.factor.service.FactorConfigService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/prize")
public class PriceController {

    @Inject
    FactorConfigService factorConfigService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPriceConfig() {
        return factorConfigService.readConfig();
    }
}
