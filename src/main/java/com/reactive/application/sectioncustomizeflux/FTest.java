package com.reactive.application.sectioncustomizeflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.function.Consumer;

public class FTest {
  public static void main(String[] args) {

      getName()
              .subscribeOn(Schedulers.boundedElastic())
              .doOnNext(process())

              .subscribe(UtilClass.onNextFunction());

    for (int i = 0; i < 12; i++) {
        UtilClass.sleepThread(1);
        System.out.println("Main Thread - " +i);
    }
  }

  private static Consumer<? super Object> process(){
      return data -> {
          UtilClass.sleepThread(1);
          System.out.println("Process --  Thread " + Thread.currentThread().getName()+
                  "  Received data : " + data);
      };
  }

  private static Flux<Object> getName(){
      return Flux.create(stringFluxSink -> {
          for(int i = 0; i < 10; i++) {
              //UtilClass.sleepThread(1);
                System.out.println("Process --  Thread " + Thread.currentThread().getName());
                stringFluxSink.next(UtilClass.getName());
          }
          stringFluxSink.complete();
      })
             // .publishOn(Schedulers.boundedElastic())
              ;
  }
}
