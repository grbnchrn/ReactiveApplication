package com.reactive.application.sectioncustomizeflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

public class FluxGenerateSample {
  public static void main(String[] args) {
   Flux.generate(synchronousSink -> {
       synchronousSink.next(1);
       synchronousSink.complete();

   }).subscribe(UtilClass.getSubscriber());



      Flux.generate(synchronousSink -> {
          StringBuilder sb = new StringBuilder();
          StringBuilder canada = new StringBuilder("Canada");
          sb.setLength(0);
          sb = sb.append(UtilClass.faker().country().name());
          synchronousSink.next(sb);
          if(0==sb.compareTo(canada)){
              synchronousSink.complete();
          }
      }).subscribe(UtilClass.getSubscriber());
  }
}
