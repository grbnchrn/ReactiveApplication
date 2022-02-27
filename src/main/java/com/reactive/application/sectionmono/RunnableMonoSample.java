package com.reactive.application.sectionmono;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;

public class RunnableMonoSample {
    public static void main(String[] args) {
        Mono<String> stringMono = Mono.fromRunnable(RunnableMonoSample::getName);
    stringMono.subscribe(
        UtilClass.onNextFunction(),
        UtilClass.oneErrorFunction(),
        () -> {
          System.out.println("email can be send now " + Thread.currentThread());
        });
    UtilClass.sleepThread(5);
    }
    public static Runnable getName(){
        System.out.println("Inside getName() ");
        return  ()->{
            //UtilClass.sleepThread(5);
            System.out.println(" Runnable " + Thread.currentThread());
        };

    }
}
