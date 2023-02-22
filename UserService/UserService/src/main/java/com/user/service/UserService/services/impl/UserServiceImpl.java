package com.user.service.UserService.services.impl;

import com.user.service.UserService.entity.Hotel;
import com.user.service.UserService.entity.Rating;
import com.user.service.UserService.entity.User;
import com.user.service.UserService.exception.ResourceNotFoundException;
import com.user.service.UserService.extrnal.HotelService;
import com.user.service.UserService.repositories.UserRepository;
import com.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserRepository userRepository;

    @Autowired
    HotelService hotelService;

    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        Rating[] rating = restTemplate.getForObject("http://RATING-SERVICE/rating/userId/"+userId , Rating[].class);//getting pure array from here

        List<Rating> listOfRating  = Arrays.stream(Objects.requireNonNull(rating)).toList();  // cast array to list

        List<Rating> finalListOfRating = listOfRating.stream().map(e -> {
            Hotel response = hotelService.getHotel(e.getHotelId());
//            ResponseEntity<Hotel> response = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/" + e.getHotelId(), Hotel.class);
//            Hotel hotel = response.getBody();
            e.setHotel(response);
            return e;
        }).collect(Collectors.toList());


        User user =  userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found with this UserID  " + userId));
           user.setRatings(finalListOfRating);
        return user;
    }
}
