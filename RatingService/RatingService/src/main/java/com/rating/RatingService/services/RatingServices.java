package com.rating.RatingService.services;

import com.rating.RatingService.entites.Rating;

import java.util.List;

public interface RatingServices {

    Rating  create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
