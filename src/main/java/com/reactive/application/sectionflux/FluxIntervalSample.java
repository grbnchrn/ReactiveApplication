package com.reactive.application.sectionflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class FluxIntervalSample {
  public static void main(String[] args) {
   Flux.range(1,10)
           .map(i->{
               UtilClass.sleepThreadMillis(100);
               return i;
           })
            .parallel().runOn(Schedulers.boundedElastic())
            .subscribe(UtilClass.getSubscriber());


      Flux.range(1,10)
              .map(i->{
                  UtilClass.sleepThreadMillis(100);
                  return i;
              })
               .subscribeOn(Schedulers.boundedElastic())
              .subscribe(UtilClass.getSubscriber());

      /*Flux.range(1,10)

              .subscribe(UtilClass.getSubscriber());*/
      UtilClass.sleepThread(2);

  }
}
