package com.reactive.application.sectioncustomizeflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

public class FluxCreateSample {

  public static void main(String[] args) {
     /* Flux.create(fluxSink -> {
          StringBuilder sb = new StringBuilder();
          StringBuilder canada = new StringBuilder("Canada");
          do{
              sb.setLength(0);
              sb = sb.append(UtilClass.faker().country().name());
             // fluxSink.next(sb);
          }while (0!=sb.compareTo(canada));
          fluxSink.complete();
      }).subscribe(UtilClass.getSubscriber());*/

      FluxSinkSample fluxSinkSample=new FluxSinkSample();

        Flux.create(fluxSinkSample).subscribe(UtilClass.getSubscriber());



      Runnable run =()-> fluxSinkSample.getCountries();

    for (int i = 0; i < 10; i++){
        new Thread(run).start();
      System.out.println(i);
      //
    }

UtilClass.sleepThread(10);


      //Flux.create(fluxSinkSample).subscribe(UtilClass.getSubscriber());
      fluxSinkSample.getCountries();
  }
}
