package com.reactive.application.sectionmono;

import java.util.stream.Stream;

public class LectStreamOne {
  public static void main(String[] args) {
      Stream<Integer> integerStream = Stream.of(1).map(s->{
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return  s*2;});

      integerStream.sorted().forEach(System.out::println);
  }
}
