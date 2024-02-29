package org.jt.rating.RatingService.service.impl;

import org.jt.rating.RatingService.entities.Rating;
import org.jt.rating.RatingService.repositories.RatingRepository;
import org.jt.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingBySingleUser(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingBySingleHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
