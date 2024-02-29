package org.jt.HotelService.controllers;
import org.jt.HotelService.entities.Hotel;
import org.jt.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    //create
    @PostMapping
    public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    //get single hotel
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel>getSingleHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
    }

    //get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>>getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }
}
