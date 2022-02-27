package com.reactive.application.sectionmono;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class FutureMonoSample {

    public static void main(String[] args) {
        Mono<String> stringMono = Mono.fromFuture(FutureMonoSample::getName);
        stringMono.subscribe(
                UtilClass.onNextFunction(),
                UtilClass.oneErrorFunction(),
                UtilClass.oneCompleteFunction()
        );

    }
    public static CompletableFuture<String> getName(){
        System.out.println("Inside getName() ");
        return   CompletableFuture.supplyAsync(UtilClass.faker().name()::fullName);

    }


}
