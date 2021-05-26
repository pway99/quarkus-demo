package org.acme.demo;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "farewell")
public interface FarewellConfiguration {
    String message();
    String name();
}
