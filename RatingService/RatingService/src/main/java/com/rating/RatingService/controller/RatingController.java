package com.rating.RatingService.controller;

import com.rating.RatingService.entites.Rating;
import com.rating.RatingService.repository.RatingRepository;
import com.rating.RatingService.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;
    @Autowired
    private RatingRepository ratingRepository;
    @PreAuthorize(" hasAuthority('Admin')")
    @PostMapping("/create")
    public ResponseEntity<Rating> create(@RequestBody  Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(rating));
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        return ResponseEntity.ok().body(ratingServices.getRatings());
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok().body(ratingServices.getRatingByUserId(userId));
    }

    @GetMapping("/hotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok().body(ratingServices.getRatingByHotelId(hotelId));
    }

}
