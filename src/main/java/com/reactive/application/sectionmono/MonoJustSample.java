package com.reactive.application.sectionmono;

import com.github.javafaker.Faker;
import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class MonoJustSample {

  public static void main(String[] args) {
      Mono<Integer> integerMono = Mono.just(456);

    integerMono.subscribe(
        item -> System.out.println(item.toString()),
        e -> System.out.println(e.getMessage()),
        () -> System.out.println("receiving msg completed"));

    integerMono.subscribe(
            UtilClass.onNextFunction(),
            UtilClass.oneErrorFunction(),
            UtilClass.oneCompleteFunction()
    );

      Mono<Integer> nullMono = Mono.just(456).map(s->s/0);
      nullMono.subscribe(
              item -> System.out.println(item.toString()),
              e -> System.out.println(e.getMessage()),
              () -> System.out.println("receiving msg completed"));

    List<String> animalName = new ArrayList<>();
    for (int i = 0; i < 15000; i++){
      animalName.add(Faker.instance().animal().name());
    }
    long count = animalName.stream().distinct().count();
    System.out.println(count);
  }
}
