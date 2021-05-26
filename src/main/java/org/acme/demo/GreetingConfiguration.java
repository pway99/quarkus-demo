package org.acme.demo;

import io.quarkus.arc.config.ConfigProperties;

import java.util.Optional;

@ConfigProperties(prefix = "greeting")
public class GreetingConfiguration {
    public String message;
    public String name;
    public Optional<Integer> prize;
}
