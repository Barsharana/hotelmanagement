package org.jt.HotelService.service;
import org.jt.HotelService.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface HotelService {
    Hotel createHotel(Hotel hotel);
    //get single hotel
    Hotel getHotel(String hotelId);
    //get allHotel
    List<Hotel>getAllHotel();
}
