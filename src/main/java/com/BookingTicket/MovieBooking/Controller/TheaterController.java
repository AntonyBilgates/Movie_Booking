package com.BookingTicket.MovieBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookingTicket.MovieBooking.Entity.Theater;
import com.BookingTicket.MovieBooking.Repository.TheaterRepository;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepository;

    // 1. Get all theaters
    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // 2. Get a theater by ID
    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        return theaterRepository.findById(id)
                .map(theater -> ResponseEntity.ok(theater))
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Add a new theater
    @PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterRepository.save(theater);
    }

    // 4. Update an existing theater
    @PutMapping("/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody Theater updatedTheater) {
        return theaterRepository.findById(id)
                .map(theater -> {
                    theater.setName(updatedTheater.getName());
                    theater.setLocation(updatedTheater.getLocation());
                    Theater savedTheater = theaterRepository.save(theater);
                    return ResponseEntity.ok(savedTheater);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Delete a theater
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        if (theaterRepository.existsById(id)) {
            theaterRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
