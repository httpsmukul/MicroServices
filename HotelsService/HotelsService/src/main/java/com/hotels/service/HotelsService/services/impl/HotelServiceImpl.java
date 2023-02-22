package com.hotels.service.HotelsService.services.impl;

import com.hotels.service.HotelsService.entites.Hotel;
import com.hotels.service.HotelsService.exception.ResourceNotFound;
import com.hotels.service.HotelsService.repositories.HotelRepository;
import com.hotels.service.HotelsService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;


    @Override
    public Hotel create(Hotel hotel) {
        System.out.println(hotel.getName() + "++++++++name");
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFound("hotel not found"));
    }
}
