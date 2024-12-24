package com.BookingTicket.MovieBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingTicket.MovieBooking.Entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	
}
