package com.reactive.application.sectioncustomizeflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.FluxSink;


import java.util.function.Consumer;

public class FluxSinkSample implements Consumer<FluxSink<Object>> {

    FluxSink<Object> fluxSink;

    @Override
    public void accept(FluxSink<Object> objectsFluxSink) {
        this.fluxSink=objectsFluxSink;
    }

    public void getCountries(){
        StringBuilder sb = new StringBuilder();
       // StringBuilder canada = new StringBuilder("Canada");
        int count =0;
        /*do{

            count++;
        }while (0!=sb.compareTo(canada);*/
        sb.setLength(0);
        sb = sb.append(UtilClass.faker().country().name()).append(" : ").append(Thread.currentThread().getName());
        fluxSink.next(sb);
        UtilClass.sleepThread(1);
        fluxSink.complete();
    }

}
