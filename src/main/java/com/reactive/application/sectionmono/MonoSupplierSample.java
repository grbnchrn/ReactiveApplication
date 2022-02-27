package com.reactive.application.sectionmono;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;

public class MonoSupplierSample {
  public static void main(String[] args) {
      Mono<String> stringMono = Mono.fromSupplier(MonoSupplierSample::getName);
      stringMono.subscribe(
              UtilClass.onNextFunction(),
              UtilClass.oneErrorFunction(),
              UtilClass.oneCompleteFunction()
      );

  }
  public static String getName(){
    System.out.println("Inside getName() ");
    return UtilClass.faker().name().fullName();
  }
}
