package org.acme.demo.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.MultiCollect;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Executor;

@ApplicationScoped
public class FactorService {

    public Uni<String> uniGreeting(String name) {
        return Uni.createFrom().item(name)
                .onItem().transform(n -> String.format("Factor this %s", n));
    }

    public Multi<String> greetings(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1))
                .onItem().transform(n -> String.format("hello %s - %d", name, n))
                .transform().byTakingFirstItems(count);
    }

    public Uni<List<String>> collectItems(int count, String name) {
        Multi<String> multi = greetings(count, name);
        Uni<List<String>> uni = multi.collectItems().asList();
        Executor e = command -> {
            System.out.print("something");
        };
        multi.subscribeOn(e);
        uni.subscribeOn(e);
        return uni;
    }

    public Multi<String> test(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1))
                .onItem().transform(n -> String.format("hello %s - %d", name, n))
                .transform().byFilteringItemsWith(u -> u.matches("bla"));
    }

    public MultiCollect<Long> hotStreamGreetings(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1))
                .transform()
                .toHotStream().collectItems();
    }

}
