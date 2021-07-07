package org.acme.demo.mongodb.panache;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

// https://github.com/quarkusio/quarkus/blob/0dd0cdc75f10aefe7a3565b183f42f245184ab7a/docs/src/main/asciidoc/mongodb-panache.adoc#reactive-entities-and-repositories
@Path("/persons")
@Consumes("application/json")
@Produces("application/json")
public class Resource {

    @GET
    public static Multi<ReactivePerson> streamPersons() {
        return ReactivePerson.streamAll();
    }

    @GET
    public static Uni<List<ReactivePerson>> list() {
        Uni<List<ReactivePerson>> persons = ReactivePerson.listAll();
        return persons;
    }

    @GET
    @Path("/{id}")
    public static Uni<ReactivePerson> get(@PathParam("id") String id) {
        Uni<ReactivePerson> personById = ReactivePerson.findById(new ObjectId(id));
        return personById;
    }

    @POST
    public static Response create(ReactivePerson person) {
        Uni<Void> p = person.persist();
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    public static void update(@PathParam("id") String id, ReactivePerson person) {
        Uni<Void> p = person.update();
    }

    @DELETE
    @Path("/{id}")
    public static void delete(@PathParam("id") String id) {
        Uni<Optional<ReactivePerson>> optional = ReactivePerson.findByIdOptional(id);
        Uni<ReactivePerson> person = optional.map(o -> o.orElseThrow(NotFoundException::new));
        person.onItem().transform(ReactivePanacheMongoEntityBase::delete);
    }

    @GET
    @Path("/search/{name}")
    public static Uni<ReactivePerson> search(@PathParam("name") String name) {
        Uni<ReactivePerson> person = ReactivePerson.findByName(name);
        return person;
    }

    @GET
    @Path("/count")
    public static Uni<Long> count() {
        Uni<Long> count = ReactivePerson.count();
        return count;
    }
}