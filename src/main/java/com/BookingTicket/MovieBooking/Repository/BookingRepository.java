package com.BookingTicket.MovieBooking.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingTicket.MovieBooking.Entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	    Optional<Booking> findByShowId(Long showId);
	}

	

