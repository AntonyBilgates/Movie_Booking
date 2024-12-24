package com.BookingTicket.MovieBooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookingTicket.MovieBooking.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title); // Corrected
}
