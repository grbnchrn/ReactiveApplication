package com.reactive.application.sectionflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

public class MultipleFilterFluxSample {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.just(1, 2, 3, 3, 2, 4, 5 ,6);

    integerFlux.distinct().subscribe(UtilClass.onNextFunction());
    integerFlux.map(s->s*2).subscribe(UtilClass.onNextFunction());
    integerFlux.filter(s->s%2==0).subscribe(UtilClass.onNextFunction());

  }
}
