package com.reactive.application.sectionflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

import java.io.Serializable;

public class JustFluxSample {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.just(1, 2, 3);
    integerFlux.subscribe(
        UtilClass.onNextFunction(), UtilClass.oneErrorFunction(), UtilClass.oneCompleteFunction());
    integerFlux.subscribe(
            UtilClass.onNextFunction(), UtilClass.oneErrorFunction(), UtilClass.oneCompleteFunction());

    Flux<? extends Object> just = Flux.just(1, '2', "45");
    just.subscribe(
            UtilClass.onNextFunction(), UtilClass.oneErrorFunction(), UtilClass.oneCompleteFunction());
  }
}
