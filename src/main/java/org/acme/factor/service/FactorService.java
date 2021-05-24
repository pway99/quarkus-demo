package org.acme.factor.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Executor;

@ApplicationScoped
public class FactorService {
    public String factorIt(String thing) {

        return thing + " factored";
    }

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
        Executor e = new Executor() {
            @Override
            public void execute(Runnable command) {
            }
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


}
