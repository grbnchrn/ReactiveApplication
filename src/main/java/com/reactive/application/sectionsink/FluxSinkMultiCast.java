package com.reactive.application.sectionsink;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FluxSinkMultiCast {

  public static void main(String[] args) {

      Sinks.Many<Integer> sink = Sinks.many().multicast().onBackpressureBuffer();
      Flux<Integer> flux = sink.asFlux();
      List<Integer> list = new ArrayList<>();


      for(int i = 0; i < 500; i++) {
          final int j=i;
          CompletableFuture.runAsync(
                  () -> {
                      UtilClass.sleepThreadMillis(100);
                      sink.emitNext(j,
                              (signalType, emission) -> {
                                 // System.out.println(signalType.toString());
                                  //System.out.println(emission.toString());
                                  return true;
                              });
                  });
      }
      flux.subscribe(list::add);
      flux.subscribe(UtilClass.getSubscriber());

      UtilClass.sleepThread(30);

    System.out.println(list.size());
  }
}
