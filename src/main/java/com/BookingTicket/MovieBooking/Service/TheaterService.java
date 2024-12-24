package com.BookingTicket.MovieBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookingTicket.MovieBooking.Entity.Theater;
import com.BookingTicket.MovieBooking.Repository.TheaterRepository;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    // Get all theaters
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // Get a theater by ID
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found with id: " + id));
    }

    // Add a new theater
    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    // Update an existing theater
    public Theater updateTheater(Long id, Theater updatedTheater) {
        Theater theater = getTheaterById(id);
        theater.setName(updatedTheater.getName());
        theater.setLocation(updatedTheater.getLocation());
        return theaterRepository.save(theater);
    }

    // Delete a theater
    public void deleteTheater(Long id) {
        if (!theaterRepository.existsById(id)) {
            throw new RuntimeException("Theater not found with id: " + id);
        }
        theaterRepository.deleteById(id);
    }
}
