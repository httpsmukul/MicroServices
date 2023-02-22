package com.user.service.UserService.controllers;


import com.user.service.UserService.entity.Rating;
import com.user.service.UserService.entity.User;
import com.user.service.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

//    int retry = 0;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name= "ratingHotelBr eaker", fallbackMethod = "ratingHotelFallback")

//    @Retry(name = "ratingHotel", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User>getUser(@PathVariable String userId){
//        System.out.println("Retry count ++"+  retry);
//        retry++;
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    //fall back method for ratingHotelBreaker
    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
        ex.printStackTrace();
        System.out.println("FallBack is executed because service is down "+ ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(User.builder().id(null).ratings(null).about("this service is down").email("email@gmail.com").name("dummy").build());
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
         return ResponseEntity.ok(userService.getAllUsers()); //we can write like this as well
    }


}
