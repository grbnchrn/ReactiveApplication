package com.reactive.application.sectioncustomizeflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

public class FluxPushSample {

  public static void main(String[] args) {
    Flux.push(
            synchronousSink -> {
              synchronousSink.next(1);
             // synchronousSink.complete();
            })
        .subscribe(UtilClass.getSubscriber());
        }
}
