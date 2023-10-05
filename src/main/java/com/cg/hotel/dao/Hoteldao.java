package com.cg.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotel.model.Hotel;

public interface Hoteldao extends JpaRepository<Hotel, Integer>{
boolean existsByHotelName(String hotelName);
}
