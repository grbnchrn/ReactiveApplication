package com.reactive.application.sectionsink;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class MonoSinkSample {

  public static void main(String[] args) {
      Sinks.One<Object> sink = Sinks.one();

      Mono<Object> mono = sink.asMono();


      mono.subscribe(UtilClass.getSubscriber());

      mono.subscribe(UtilClass.getSubscriber());
      UtilClass.sleepThreadMillis(10000);
      sink.emitValue(
              3,
              (signalType, emission) -> {
                  System.out.println(signalType.toString());
                  System.out.println(signalType.name());
                  System.out.println(emission.toString());
                  System.out.println(emission.name());
                  return false;
              });

      sink.emitValue(
              3,
              (signalType, emission) -> {
                  System.out.println(signalType.toString());
                  System.out.println(signalType.name());
                  System.out.println(emission.toString());
                  System.out.println(emission.name());
                  return false;
              });
  }


}
