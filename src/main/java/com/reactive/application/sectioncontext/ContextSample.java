package com.reactive.application.sectioncontext;

import com.reactive.application.sectionutil.UtilClass;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class ContextSample {

    public static void main(String[] args){
        getMessage()
               .contextWrite(Context.of("user","GRBN"))
                .contextWrite(context -> {
                    Context put = context.put("user1", "GRBN");
                    return put;
                })
               /* .contextWrite(context -> {
                    context.put("user","hi");
                    return context;
                })*/
                .subscribe(UtilClass.getSubscriber());

    }

    private static Mono<String> getMessage(){
        return Mono.deferContextual(ctx->{
            if(ctx.hasKey("user")){
                return Mono.just("Hi" + ctx.get("user"));
            }else {
                return Mono.error(new RuntimeException("Unauthenticated"));
            }
        });
    }
}
