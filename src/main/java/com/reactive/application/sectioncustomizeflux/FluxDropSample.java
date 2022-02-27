package com.reactive.application.sectioncustomizeflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FluxDropSample {

  public static void main(String[] args) {

      System.setProperty("reactor.bufferSize.small", "16");

    Flux.create(
            (FluxSink<Integer> fluxSink) -> {
              for (int i = 1; i <= 30; i++) {
                System.out.println("Pushing : "+i);
                fluxSink.next(i);
              }
              fluxSink.complete();
            })
            .onBackpressureLatest()
            .doOnNext((c)->{
                //UtilClass.sleepThreadMillis(20);
            })

            .publishOn(Schedulers.boundedElastic())
        .subscribe(
            (v) -> {
                //UtilClass.sleepThreadMillis(1);
              System.out.println("Received : " + v);
            });
          UtilClass.sleepThread(10);

      }

}
