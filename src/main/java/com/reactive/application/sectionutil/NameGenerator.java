package com.reactive.application.sectionutil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.SynchronousSink;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NameGenerator {

    private List <String>listOfNames = new CopyOnWriteArrayList();

  public Flux<String> getNames() {
    return Flux.generate((SynchronousSink<String> synchronousSink) ->{
        String name= UtilClass.getName();
        listOfNames.add(name);
        synchronousSink.next(name);
    } ).startWith(listOfNames);

  }
}
