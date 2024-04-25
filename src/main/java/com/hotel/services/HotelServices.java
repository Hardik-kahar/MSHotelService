package com.hotel.services;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelServices {

//	create
	Hotel create(Hotel hotel);

//	getall 
	List<Hotel> getAll();

//	get single hotel
	Hotel get(String id);

}
