package com.hotels.service.HotelsService.controller;


import com.hotels.service.HotelsService.entites.Hotel;
import com.hotels.service.HotelsService.repositories.HotelRepository;
import com.hotels.service.HotelsService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @Autowired
    private HotelRepository hotelRepository;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        System.out.println("hotel ++++++" + hotel.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

//    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok().body(hotelService.getAll());
    }

    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        return ResponseEntity.ok().body(hotelService.getHotel(hotelId));
    }




}
