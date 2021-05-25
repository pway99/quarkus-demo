package org.acme.factor;

import io.quarkus.arc.config.ConfigProperties;

import java.util.Optional;

@ConfigProperties(prefix = "greeting")
public class FactorConfiguration {

    public String message;
    public String suffix = "!";
    public String name;
    public Optional<Integer> prize;
}
