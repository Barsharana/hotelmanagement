package org.jt.user.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

        private String ratingId;
        private String userId;
        private int rating;
        private String hotelId;
        private String feedback;
        private Hotel hotel;
    }


