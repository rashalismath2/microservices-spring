package com.example.rating.Controllers;

import com.example.rating.Models.RatingItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingControllers {

    @GetMapping("/{id}")
    public RatingItem getRatingForMovie(@PathVariable("id") int id){
            return new RatingItem(id,4);
    }
}
