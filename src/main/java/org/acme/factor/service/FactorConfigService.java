package org.acme.factor.service;

import org.acme.factor.FactorConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FactorConfigService {
    @Inject
    FactorConfiguration factorConfiguration;

    public String readConfig() {
        String configMessage = factorConfiguration.message + " [" + factorConfiguration.name + "] \n";
        if (factorConfiguration.prize.isPresent()) {
          configMessage = configMessage.concat(" prize: " + factorConfiguration.prize.get());
        }
        return configMessage;
    }
}
