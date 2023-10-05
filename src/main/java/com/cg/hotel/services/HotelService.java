package com.cg.hotel.services;

import com.cg.hotel.dto.HotelRequest;
import com.cg.hotel.exception.DuplicateEntryException;
import com.cg.hotel.exception.IdNotFoundException;
import com.cg.hotel.model.Hotel;

public interface HotelService {
public Hotel findById(int hid)throws IdNotFoundException;
public Hotel create(HotelRequest hotel)throws DuplicateEntryException;
public String delete(int hid)throws IdNotFoundException;
//public String updateHotel(int hid,String hotelName)throws IdNotFoundException;
}
