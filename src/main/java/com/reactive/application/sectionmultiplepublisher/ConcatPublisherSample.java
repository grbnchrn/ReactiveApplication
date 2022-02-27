package com.reactive.application.sectionmultiplepublisher;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

public class ConcatPublisherSample {
  public static void main(String[] args) {
    Flux<String> flux1 = Flux.just("a", "b");
    Flux<String> fluxError1 = Flux.error(new RuntimeException("Oops 1"));
    Flux<String> flux2 = Flux.just("c", "b");
    Flux<String> fluxError2 = Flux.error(new RuntimeException("Oops 2"));
    Flux<String> flux3 = Flux.just("a", "b");

    Flux<String> stringFlux = Flux.concatDelayError(flux1, fluxError1, flux2, fluxError2, flux3);
      stringFlux.subscribe(UtilClass.getSubscriber());
  }
}
