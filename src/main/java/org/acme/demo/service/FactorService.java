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

    public static Uni<String> uniGreeting(String name) {
        return Uni.createFrom().item(name)
                .onItem()
                .apply(n -> String.format("Factor this %s", n));
    }

    public static Multi<String> greetings(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1))
                .onItem()
                .transform(n -> String.format("hello %s - %d", name, n))
                .transform()
                .byTakingFirstItems(count);
    }

    public static Uni<List<String>> collectItems(int count, String name) {
        Multi<String> multi = greetings(count, name);
        Uni<List<String>> uni = multi
                .collectItems()
                .asList();
        Executor e = command -> {
            System.out.print("something");
        };
        multi.subscribeOn(e);
        uni.subscribeOn(e);
        return uni;
    }

    public static Multi<String> test(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1))
                .onItem()
                .transform(n -> String.format("hello %s - %d", name, n))
                .transform()
                .byFilteringItemsWith(u -> u.matches("bla"));
    }

    public static MultiCollect<Long> hotStreamGreetings(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1))
                .transform()
                .toHotStream()
                .collectItems();
    }

}
