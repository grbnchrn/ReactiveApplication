package com.reactive.application.sectionflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.reactive.application.sectionutil.UtilClass.*;

public class FluxFromMono {
  public static void main(String[] args) {
      Mono<String> stringMono = Mono.just("2");
      Flux<String> stringFlux = Flux.from(stringMono);

      Flux.range(1,10).next().subscribe(
              onNextFunction(),
              oneErrorFunction(),
              oneCompleteFunction());

      Flux.range(3, 5)
              .map(i -> i / (i - 4)).subscribe(
              onNextFunction(),
              oneErrorFunction(),
              oneCompleteFunction());;
  }
}
