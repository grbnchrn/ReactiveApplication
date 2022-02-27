package com.reactive.application.sectionmono;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;

public class MonoErrorOrEmpty {
  public static void main(String[] args) {
    for (int i =1; i < 4; i++) {
        userRepository(i).subscribe(
                UtilClass.onNextFunction(),
                UtilClass.oneErrorFunction(),
                UtilClass.oneCompleteFunction()
        );
      System.out.println();
    }
    //
  }

  private static Mono<String> userRepository(int userId){
      if(userId==1){
         return Mono.just(UtilClass.faker().name().fullName()) ;
      }else if (userId==2){
          return Mono.empty();
      }else {
          return Mono.error(new Exception("Not found"));
      }
  }

}
