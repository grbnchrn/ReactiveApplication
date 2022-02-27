package com.reactive.application.sectionflux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class CustomSubscriptionSample {

  public static void main(String[] args) {
    AtomicReference<Subscription> subscriptionAtomicReference = new AtomicReference<>();
    Flux.range(1, 10)
        .subscribeWith(
            new Subscriber<Integer>() {
              @Override
              public void onSubscribe(Subscription subscription) {
                System.out.println("Inside onSubscribe");
                subscriptionAtomicReference.set(subscription);
              }

              @Override
              public void onNext(Integer integer) {
                System.out.println("Inside onNext : " + integer);
              }

              @Override
              public void onError(Throwable throwable) {
                System.out.println("Inside onError : " + throwable.getMessage());
              }

              @Override
              public void onComplete() {
                System.out.println("Inside onComplete ..");
              }
            });

    subscriptionAtomicReference.get().request(3);
      subscriptionAtomicReference.get().request(7);
      subscriptionAtomicReference.get().cancel();
  }
}
