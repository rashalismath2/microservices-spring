package com.example.catelog.Controllers;

import com.example.catelog.Models.CatelogItem;
import com.example.catelog.Models.MovieItem;
import com.example.catelog.Models.RatingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/catelog")
public class CatelogController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(value="/{id}")
    public Mono<CatelogItem> getAllCatelog(@PathVariable("id") int id){

       return webClientBuilder.build().get()
                .uri("http://localhost:8083/ratings/"+id)
                .retrieve()
                .bodyToMono(RatingItem.class)
                .flatMap(e->{

                   return  webClientBuilder.build().get()
                            .uri("http://localhost:8082/movies/"+id)
                            .retrieve()
                            .bodyToMono(MovieItem.class)
                            .flatMap(m->{
                                return  Mono.just(new CatelogItem(1,m.getTitle(),"its transformers",e.getRating()));
                            });

                });

    }

}
