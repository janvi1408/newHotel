package com.cg.hotel.model;

import com.cg.hotel.dto.HotelRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int hid;
private String hotelName;
private int price;
private int AvailibilityOfRooms;
}
