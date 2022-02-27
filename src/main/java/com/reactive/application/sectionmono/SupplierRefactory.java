package com.reactive.application.sectionmono;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class SupplierRefactory {

  public static void main(String[] args) {

      getName().subscribeOn(Schedulers.boundedElastic())
              .subscribe(UtilClass.onNextFunction(),
              UtilClass.oneErrorFunction(),
              UtilClass.oneCompleteFunction());
      getName().subscribeOn(Schedulers.boundedElastic())
              .subscribe(UtilClass.onNextFunction(),
              UtilClass.oneErrorFunction(),
              UtilClass.oneCompleteFunction());
      getName().subscribeOn(Schedulers.boundedElastic())
              .subscribe(UtilClass.onNextFunction(),
              UtilClass.oneErrorFunction(),
              UtilClass.oneCompleteFunction());
      getName().subscribeOn(Schedulers.boundedElastic())
              .subscribe(UtilClass.onNextFunction(),
              UtilClass.oneErrorFunction(),
              UtilClass.oneCompleteFunction());
      getName();

      UtilClass.sleepThread(6);
      System.out.println("Exiting main ");
  }


    public static Mono<String> getName(){
        System.out.println("Inside getName() ");
        return  Mono.fromSupplier(()->{
            System.out.println("Inside Supplier() ");
            UtilClass.sleepThread(5);
            return  UtilClass.faker().name().fullName();
        }).map(String::toUpperCase);


    }

}
