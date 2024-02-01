package org.jt.user.UserService.external.services;

import org.jt.user.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelServices {
    @GetMapping("hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
