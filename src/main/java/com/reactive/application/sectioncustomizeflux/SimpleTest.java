package com.reactive.application.sectioncustomizeflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimpleTest {

    public static void main(String[] args){
        List<Long> list = new ArrayList<>();
        List<Long> listCopy = new CopyOnWriteArrayList<>();

        //FluxSink<Long>

    Flux.create(
            ( FluxSink<Long> fluxSink)-> {
              for (long i = 0; i < 100000; i++) {
                fluxSink.next(i);
              }
              fluxSink.complete();
            })
        .parallel()
        .runOn(Schedulers.parallel())
        .subscribe(
            (v) -> {
              list.add(v);
              listCopy.add(v);
            });
        UtilClass.sleepThread(5);
    System.out.println(list.size());
    System.out.println(listCopy.size());

    }

}
