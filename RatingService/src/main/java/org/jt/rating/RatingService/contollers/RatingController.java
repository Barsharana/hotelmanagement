package org.jt.rating.RatingService.contollers;

import org.jt.rating.RatingService.entities.Rating;
import org.jt.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<Rating>createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }


    //get All rating
    @GetMapping
    public ResponseEntity<List<Rating>>getAllRating(){
        return  ResponseEntity.ok(ratingService.getAllRating());
    }

    //get rating by single user
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>>getRatingBySingleUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getAllRatingBySingleUser(userId));
    }

    //get rating by a single hotel
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingByAllHotel(String hotelId){
        return ResponseEntity.ok(ratingService.getAllRatingBySingleHotel(hotelId));
    }
}
