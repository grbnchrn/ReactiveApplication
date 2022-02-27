package com.reactive.application.sectionflux;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Flux;

import java.util.List;

import static com.reactive.application.sectionutil.UtilClass.*;

public class FluxVsListSample {
  public static void main(String[] args) {
      List<String> namesListWithDelay = getNamesListWithDelay(5);
    System.out.println(namesListWithDelay);
      Flux<String> fluxList = getNamesFluxWithDelay(5);

      fluxList.subscribe(
              onNextFunction(),
              oneErrorFunction(),
              oneCompleteFunction());
  }


}
