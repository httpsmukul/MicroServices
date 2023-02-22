package com.hotels.service.HotelsService.repositories;

import com.hotels.service.HotelsService.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
