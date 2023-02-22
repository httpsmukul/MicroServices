package com.hotels.service.HotelsService.services;


import com.hotels.service.HotelsService.entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotel(String id);

}
