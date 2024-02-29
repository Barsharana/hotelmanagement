package org.jt.HotelService.repositories;

import org.jt.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
