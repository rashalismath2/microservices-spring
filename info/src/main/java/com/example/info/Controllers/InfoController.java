package com.example.info.Controllers;

import com.example.info.Models.MovieItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class InfoController {

    @GetMapping(value = "/")
    public List<MovieItem> getAllMovies(){
            List<MovieItem> list=new ArrayList<>();
            list.add(new MovieItem(1,"Transformers"));
            return list;
    }

    @GetMapping("/{id}")
    public MovieItem getMovieItem(@PathVariable("id") int id){
        return  new MovieItem(id,"Transformers");
    }
}
