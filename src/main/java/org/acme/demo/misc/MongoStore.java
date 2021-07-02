package org.acme.demo.misc;

import com.mongodb.client.MongoClient;
import io.quarkus.mongodb.runtime.MongoClientName;

import javax.inject.Inject;

public class MongoStore {
    @Inject
    @MongoClientName("clientName")
    MongoClient mongoClient;
}