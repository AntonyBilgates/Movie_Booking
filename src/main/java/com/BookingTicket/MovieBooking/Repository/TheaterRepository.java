package com.BookingTicket.MovieBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingTicket.MovieBooking.Entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
	
}
