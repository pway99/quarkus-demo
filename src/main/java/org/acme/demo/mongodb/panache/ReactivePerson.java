package org.acme.demo.mongodb.panache;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.smallrye.mutiny.Uni;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDate;
import java.util.List;

// https://github.com/quarkusio/quarkus/blob/0dd0cdc75f10aefe7a3565b183f42f245184ab7a/docs/src/main/asciidoc/mongodb-panache.adoc#reactive-entities-and-repositories
@MongoEntity(collection = "ThePerson")
public class ReactivePerson extends ReactivePanacheMongoEntity {
    @JsonProperty
    public String name;
    @BsonProperty("birth")
    public LocalDate birthDate;
    public Status status;

    public static Uni<ReactivePerson> findByName(String name) {
        return find("name", name).firstResult();
    }

    public static Uni<List<ReactivePerson>> findAlive() {
        return list("status", Status.LIVING);
    }

    public static void deleteLoics() {
        delete("name", "Loïc");
    }
}