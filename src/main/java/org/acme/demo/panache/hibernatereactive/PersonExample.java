package org.acme.demo.panache.hibernatereactive;

import io.smallrye.mutiny.Uni;

public class PersonExample {
    {
        ReactivePerson reactivePerson = new ReactivePerson();
        Uni<Void> p0 = reactivePerson.persist();
        Uni<Void> p1 = reactivePerson.persistAndFlush();
    }

}