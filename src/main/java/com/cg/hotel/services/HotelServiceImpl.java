package com.cg.hotel.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.hotel.dao.Hoteldao;
import com.cg.hotel.dto.HotelRequest;
import com.cg.hotel.exception.DuplicateEntryException;
import com.cg.hotel.exception.IdNotFoundException;
import com.cg.hotel.model.Hotel;
@Component
public class HotelServiceImpl implements HotelService{

	@Autowired private Hoteldao repo;
	
	@Override
	public Hotel findById(int hid) throws IdNotFoundException {
	return repo.findById(hid).orElseThrow(()-> new IdNotFoundException(hid+" Not Found"));
		
	}

	@Override
	public Hotel create(HotelRequest hotel) throws DuplicateEntryException {
	if(repo.existsByHotelName(hotel.getHotelName())) {
		throw new DuplicateEntryException("Duplicate Entry not possible"+hotel.getHotelName()+" already exists");
	}Hotel hotels=new Hotel();
	BeanUtils.copyProperties(hotel, hotels);
	return repo.save(hotels);
	}

	@Override
	public String delete(int hid) throws IdNotFoundException {
	Hotel hotel=repo.findById(hid).orElseThrow(()-> new IdNotFoundException(hid +" Not Found"));
	repo.delete(hotel);
	return "Successful Deleted";
		
	}

//	@Override
//	public String updateHotel(int hid, String hotelName) throws IdNotFoundException {
//		Hotel hotels=repo.findById(hid).orElseThrow(()-> new IdNotFoundException(hid +" Not Found"));
//		hotels.setHotelName(hotelName);
//		repo.save(hotels);
//		return hotelName;
//		
//	}

}
