package org.acme.demo.panache.mongodbreactive;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.smallrye.mutiny.Uni;

// https://github.com/quarkusio/quarkus/blob/0dd0cdc75f10aefe7a3565b183f42f245184ab7a/docs/src/main/asciidoc/mongodb-panache.adoc#reactive-entities-and-repositories
@MongoEntity(collection = "ThePerson")
public class ReactivePerson extends ReactivePanacheMongoEntity {
    @JsonProperty
    public String name;

    public static Uni<ReactivePerson> findByName(String name) {
        return find("name", name).firstResult();
    }
}