package com.hotel.servicesImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repositories.HotelRespository;
import com.hotel.services.HotelServices;

@Service
public class HotelServiceImpl implements HotelServices{

	@Autowired
	private HotelRespository hotelRespository;
	
	@Override
	public Hotel create(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRespository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRespository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id is not found on server !!: "+ id));
	}

}
