package com.reactive.application.sectionsink;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FluxSinkSample {
  public static void main(String[] args) {
      Sinks.Many<Integer> sink = Sinks.many().unicast().onBackpressureBuffer();
      Flux<Integer> flux = sink.asFlux();
      List<Integer> list = new ArrayList<>();
      flux.subscribe(list::add);
      //flux.subscribe(UtilClass.getSubscriber());

     for(int i = 0; i < 500; i++) {
          final int j=i;
      CompletableFuture.runAsync(
          () -> {
            sink.emitNext(j,
                (signalType, emission) -> {
                    System.out.println(signalType.toString());
                    System.out.println(emission.toString());
                  return true;
                });
          });
      }

      UtilClass.sleepThread(5);
    System.out.println(list.size());
     // sink.tryEmitComplete();





  }
}
