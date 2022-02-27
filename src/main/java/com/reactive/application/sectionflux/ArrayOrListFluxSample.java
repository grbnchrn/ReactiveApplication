package com.reactive.application.sectionflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class ArrayOrListFluxSample {

  public static void main(String[] args) {

    List<String> stringList = Arrays.asList("A", "B", "C");
    List<String> stringList2 = List.of("A", "B", "C");

    Flux<String> stringFlux = Flux.fromIterable(stringList);
    stringFlux.subscribe(
        UtilClass.onNextFunction(), UtilClass.oneErrorFunction(), UtilClass.oneCompleteFunction());

    Flux.range(3, 10)
        .subscribe(
            UtilClass.onNextFunction(),
            UtilClass.oneErrorFunction(),
            UtilClass.oneCompleteFunction());

    Flux.range(3, 10)
        .log()
        .map(i -> UtilClass.faker().name().fullName())
        .subscribe(
            UtilClass.onNextFunction(),
            UtilClass.oneErrorFunction(),
            UtilClass.oneCompleteFunction());


  }
}
