package org.acme.demo.kafka;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@ApplicationScoped
public class KafkaProviders {
    @Inject
    @Named("default-kafka-broker")
    Map<String, Object> config;
}
