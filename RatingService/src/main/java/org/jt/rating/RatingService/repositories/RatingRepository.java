package org.jt.rating.RatingService.repositories;

import org.jt.rating.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {
    //customize finder method to find the userId and hotelId
    List<Rating> findByUserId(String userId);
    List<Rating>findByHotelId(String hotelId);

}
