package org.acme.factor.service;

import org.acme.factor.MyConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FactorConfigService {
    @Inject
    MyConfiguration myConfiguration;

    public String readConfig() {
        String configMessage = myConfiguration.message + " [" + myConfiguration.name + "] \n";
        if (myConfiguration.prize.isPresent()) {
          configMessage = configMessage.concat(" prize: " + myConfiguration.prize.get());
        }
        return configMessage;
    }
}
