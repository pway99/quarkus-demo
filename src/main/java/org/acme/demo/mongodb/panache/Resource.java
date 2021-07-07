package org.acme.demo.mongodb.panache;

import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/persons")
@Consumes("application/json")
@Produces("application/json")
public class Resource {

    @GET
    public List<Person> list() {
        return Person.listAll();
    }

    @GET
    @Path("/{id}")
    public Person get(@PathParam("id") String id) {
        return Person.findById(new ObjectId(id));
    }

    @POST
    public Response create(Person person) {
        person.persist();
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Person person) {
        person.update();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        Person person = Person.findById(new ObjectId(id));
        person.delete();
    }

    @GET
    @Path("/search/{name}")
    public Person search(@PathParam("name") String name) {
        return Person.findByName(name);
    }

    @GET
    @Path("/count")
    public Long count() {
        return Person.count();
    }
}