package org.acme.demo.mongodb.panache;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDate;
import java.util.List;

@MongoEntity(collection = "ThePerson")
public class Person extends PanacheMongoEntity {
    @JsonProperty
    public String name;
    // will be persisted as a 'birth' field in MongoDB
    @BsonProperty("birth")
    public LocalDate birthDate;
    public Status status;

    // entity methods
    public static Person findByName(String name) {
        return find("name", name).firstResult();
    }

    public static List<Person> findAlive() {
        return list("status", Status.LIVING);
    }

    public static void deleteLoics() {
        delete("name", "Loïc");
    }
}