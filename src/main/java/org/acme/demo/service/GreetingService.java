package org.acme.demo.service;

import org.acme.demo.GreetingConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingService {
    @Inject
    GreetingConfiguration greetingConfiguration;

    public String greetingMessage() {
        String message = greetingConfiguration.message + " [" + greetingConfiguration.name + "] \n";
        if (greetingConfiguration.prize.isPresent()) {
            message = message.concat(" prize: " + greetingConfiguration.prize.get());
        }
        return message;
    }
}
