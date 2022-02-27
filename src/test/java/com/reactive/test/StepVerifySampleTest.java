package com.reactive.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

import java.time.Duration;
import java.time.LocalTime;
import java.util.TimeZone;

public class StepVerifySampleTest {

    @Test
    public void test1(){
        Flux<Integer> range = Flux.range(1, 5);
        StepVerifier.create(range)
                .expectNext(1)
                .expectNext(2,3,3,5)
                //.expectComplete()
                .verifyComplete();
    }

    @Test
    public void test2(){
        StepVerifierOptions scenarioName = StepVerifierOptions.create().scenarioName("Next Count");
        Flux<Integer> range = Flux.range(1, 50);
        StepVerifier.create(range, scenarioName)
                .expectNextCount(50)
                .verifyComplete();
    }

    @Test
    public void test3(){
        Flux<Integer> range = Flux.range(1, 50);
        StepVerifier.create(range)
                .thenConsumeWhile(i->i<51)
                .verifyComplete();
    }

    @Test
    public void test4(){
        Flux<Integer> just = Flux.just(1);
        StepVerifier.create(just)
                .assertNext(i->{
                    Assertions.assertTrue(i<2);
                })
                .verifyComplete();
    }

    @Test
    public void test5(){
        System.out.println("Started : " + LocalTime.now());
       // Flux<Integer> timeConsumingFlux = getIntegerFlux();
       // System.out.println("Flux Started : " + LocalTime.now());
        StepVerifier.withVirtualTime(()-> getIntegerFlux())
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(5))
                .thenAwait(Duration.ofSeconds(21))
                .expectNext(1,2,3,4,5)
                .verifyComplete();
        System.out.println("Completed "  + LocalTime.now());
    }

    private Flux<Integer> getIntegerFlux() {
       System.out.println("getIntegerFlux "  + LocalTime.now());
        return Flux.range(1, 5)
                    .delayElements(Duration.ofSeconds(5))
                    .map(i->i*1);
    }

    @Test
    public void test6(){
        Flux<Integer> just = Flux.just(1);
        StepVerifier.create(just)
                .expectNext(1)
                .as("Test - 1")
                .verifyComplete();
    }

    @Test
    public void test7(){
        System.out.println(getString());
    }
    private String getString(){
        String newString = "Hi";
        return newString.concat(" GRBN");
    }

    @Test
    public void test8(){
        StepVerifierOptions initialContext = StepVerifierOptions.create().withInitialContext(Context.of("user", "GRBN"));
        StepVerifier.create(getMessage(),initialContext)
                .expectNext("Hi GRBN")
                .verifyComplete();
    }

    private Mono<String> getMessage(){
        return Mono.deferContextual(ctx->{
            if(ctx.hasKey("user")){
                return Mono.just("Hi " + ctx.get("user"));
            }else {
                return Mono.error(new RuntimeException("Unauthenticated"));
            }
        });
    }


}
