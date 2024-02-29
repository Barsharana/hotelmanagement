package org.jt.HotelService.service.impl;


import org.jt.HotelService.entities.Hotel;
import org.jt.HotelService.exception.ResourceNotFoundException;
import org.jt.HotelService.repositories.HotelRepository;
import org.jt.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() ->new ResourceNotFoundException("Hotel not found in give id...!!"));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }
}
