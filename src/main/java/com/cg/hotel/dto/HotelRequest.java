package com.cg.hotel.dto;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelRequest {
	@NotBlank(message="Hotel Name cannot be blank")
	private String hotelName;
//	@Min(value=100)
	private int price;
	
	private int AvailibilityOfRooms;
}
