package org.jt.rating.RatingService.service;

import org.jt.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create rating
    Rating createRating(Rating rating);
    //get all rating
    List<Rating>getAllRating();

    //get allRating By a single User
    List<Rating>getAllRatingBySingleUser(String userId);


    //get all rating that a single hotel get
    List<Rating>getAllRatingBySingleHotel(String hotelId);
}
