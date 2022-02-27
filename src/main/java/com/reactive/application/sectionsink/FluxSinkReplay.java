package com.reactive.application.sectionsink;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FluxSinkReplay {

  public static void main(String[] args) {
      Sinks.Many<Integer> sink = Sinks.many().replay().all();
      Flux<Integer> flux = sink.asFlux();
      List<Integer> list = new ArrayList<>();
      int i = 0;
      for(; i < 5; i++) {
          final int j=i;
          CompletableFuture.runAsync(
              () -> {
                sink.emitNext(j,(signalType, emission) -> {
                 return true;
               });
              });
      }

      flux.subscribe(list::add);
      flux.subscribe(UtilClass.getSubscriber());

      for(; i < 10; i++) {
          final int j=i;
          CompletableFuture.runAsync(
                  () -> {
                      sink.emitNext(j,(signalType, emission) -> {
                          return true;
                      });
                  });
      }

      flux.subscribe(UtilClass.getSubscriber());


  }
}
