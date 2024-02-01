package org.jt.user.UserService.service.impl;

import org.jt.user.UserService.entities.Hotel;
import org.jt.user.UserService.entities.Rating;
import org.jt.user.UserService.entities.User;
import org.jt.user.UserService.exception.ResourcesNotFoundException;
import org.jt.user.UserService.external.services.HotelServices;
import org.jt.user.UserService.repositories.UserRepository;
import org.jt.user.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelServices hotelServices;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUsers(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    //this method used to find alluser
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //this method is used to find single user
    @Override
    public User getUser(String userId) {
        //get user from database with the help of user repository
        User user= userRepository.findById(userId)
                .orElseThrow(() -> new
                        ResourcesNotFoundException("given user id is not found in the server...!" + userId));
       //http://localhost:8088/ratings/users/b6e9aca1-5182-4bcc-86b9-0da7374da4b3
        // we use RATING-SERVICE to chAngE the hardcode to soft code
        Rating[] ratingsOfUser= restTemplate
                .getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ",ratingsOfUser);



        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating>ratingList=ratings.stream().map(rating ->{
            //1st we set the api of hotel
            // http://localhost:8087/hotels/ff0d3d83-e55c-4a78-b6f1-20a0a1859a52
            //we use HOTEL-SERVICE to chAngE the hardcode to soft code
            // ResponseEntity<Hotel> forEntity = restTemplate
            // .getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

            //this is use by FiegnClient
         Hotel hotel = hotelServices.getHotel(rating.getHotelId());


            //logger.info("response status code {} "+forEntity.getStatusCode());

            //2ND Set the hotel to rating
            rating.setHotel(hotel);

            return rating;

        }).collect(Collectors.toList());

       user.setRatings(ratingList);

        return  user;
    }

}