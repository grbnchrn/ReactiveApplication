package com.reactive.application.sectionutil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import static com.reactive.application.sectionutil.UtilClass.*;

public class DefaultSubscriberUtil implements Subscriber<Object> {
  private String name = "DEFAULT";

  private static long count = 0;

  public DefaultSubscriberUtil() {}

  public DefaultSubscriberUtil(String name) {
    this.name = name;
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    subscription.request(Long.MAX_VALUE);
  }

  @Override
  public void onNext(Object o) {
    count+=1;
    System.out.println("Count : "+count + " ::Name " + name + " ::Thread " + Thread.currentThread().getName()+" ::Received data : " + o);
  }

  @Override
  public void onError(Throwable throwable) {
    System.out.println("Error Message Received : " + throwable.getMessage());
  }

  @Override
  public void onComplete() {
    System.out.println("Completed Transfer..." );
  }
}
