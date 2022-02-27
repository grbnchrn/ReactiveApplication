package com.reactive.application.sectionhotcoldpublishers;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class HotPublisherSampler {

  public static Stream<String> getMovie() {
    System.out.println("Requesting movie");
    return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5");
  }

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.fromStream(HotPublisherSampler::getMovie)
            .delayElements(Duration.ofSeconds(1)).publish().refCount(1);

    stringFlux.subscribe(UtilClass.getSubscriber("SAM"));
    UtilClass.sleepThread(6);
      stringFlux.subscribe(UtilClass.getSubscriber("MAN"));

      UtilClass.sleepThread(20);
  }
}
