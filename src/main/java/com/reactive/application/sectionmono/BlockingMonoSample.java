package com.reactive.application.sectionmono;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class BlockingMonoSample {

  public static Mono<String> getName() {
    System.out.println("Inside getName() ");
    return Mono.fromSupplier(
            () -> {
              System.out.println("Inside Supplier() ");
              UtilClass.sleepThread(5);
              return UtilClass.faker().name().fullName();
            })
        .map(String::toUpperCase);
  }

  public static void main(String[] args) {
      System.out.println(getName().subscribeOn(Schedulers.boundedElastic()).block());
      System.out.println(getName().subscribeOn(Schedulers.boundedElastic()).block());
      System.out.println(getName().subscribeOn(Schedulers.boundedElastic()).block());
      System.out.println(getName().subscribeOn(Schedulers.boundedElastic()).block());
  }
}
