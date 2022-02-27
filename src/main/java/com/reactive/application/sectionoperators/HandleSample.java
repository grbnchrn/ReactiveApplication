package com.reactive.application.sectionoperators;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class HandleSample {
  public static void main(String[] args) {
/*    Flux.range(1, 200)
        .handle(
            (integer, synchronousSink) -> {
              synchronousSink.next(integer);
            })
        .subscribe(UtilClass.getSubscriber());*/

      Flux.range(1, 20)
              .log()
              .limitRate(4,3)
              .subscribe(UtilClass.getSubscriber());

      Flux.range(1, 20)
              .log()
              .delayElements(Duration.ofSeconds(1))
              .subscribe(UtilClass.getSubscriber());
  }
}
