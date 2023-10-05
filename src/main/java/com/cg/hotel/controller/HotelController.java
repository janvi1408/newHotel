package com.cg.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.cg.hotel.dto.HotelRequest;
import com.cg.hotel.exception.DuplicateEntryException;
import com.cg.hotel.exception.IdNotFoundException;
import com.cg.hotel.model.Hotel;
import com.cg.hotel.services.HotelService;

import jakarta.validation.Valid;


@RestController
public class HotelController {
@Autowired private HotelService service;
	@PostMapping(value="/")
	@ResponseStatus(HttpStatus.CREATED)
	public Hotel create(@RequestBody HotelRequest hotel) throws DuplicateEntryException {
		return service.create(hotel);
	}
	
	@GetMapping(value="/{hotelId}")
	@ResponseStatus(HttpStatus.OK)
	public Hotel findHotel(@PathVariable int hotelId) throws IdNotFoundException {
		return service.findById(hotelId);
	}
	
	@DeleteMapping(value="/{hotelId}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String deleteHotel(@PathVariable int hotelId) throws IdNotFoundException {
		return service.delete(hotelId);
	}
	
//	@GetMapping(value="/{hotelId}/{hotelName}")
//	public ResponseEntity<String>updatePin(@PathVariable int hotelId,@PathVariable String hotelName)throws IdNotFoundException  {
//		return new ResponseEntity<String>(service.updateHotel(hotelId, hotelName),HttpStatus.OK);
//	}
}
