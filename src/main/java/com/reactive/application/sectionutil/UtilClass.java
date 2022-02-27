package com.reactive.application.sectionutil;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UtilClass {

  public static final Faker FAKER = Faker.instance();

  public static Consumer<Object> onNextFunction() {
    return o -> {

      System.out.println("Thread " + Thread.currentThread().getName()+
              "  Received data : " + o);
    };
  }

  public static Consumer<Throwable> oneErrorFunction() {
    return e -> {
      System.out.println("Error Message Received : " + e.getMessage());
    };
  }

  public static Runnable oneCompleteFunction() {
    return () -> {
      System.out.println("Completed Transfer..." );
    };
  }

  public static void sleepThread(long s){
    try {
      Thread.sleep(1000*s);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void sleepThreadMillis(long ms){
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public static Faker faker(){
    return FAKER;
  }

  public static String getName(){
    return faker().name().fullName();
  }

  public static String getNameWithDelay(){
    sleepThread(2);
    return faker().name().fullName();
  }

  public static List<String> getNamesList(int count){
    List<String> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(getName());
    }
    return list;
  }



  public static List<String> getNamesListWithDelay(int count){

    List<String> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      list.add(getNameWithDelay());
    }
    return list;
  }

  public static Flux<String> getNamesFluxWithDelay(int count){
    return Flux.range(0, count)
            .map(i -> getNameWithDelay());
  }

  public static Subscriber<Object> getSubscriber(){
    return new DefaultSubscriberUtil();
  }

  public static Subscriber<Object> getSubscriber(String name){
    return new DefaultSubscriberUtil(name);
  }


}
