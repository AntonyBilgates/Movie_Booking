package com.BookingTicket.MovieBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookingTicket.MovieBooking.Entity.Booking;
import com.BookingTicket.MovieBooking.Service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestParam Long showId, @RequestParam int numberOfSeats) {
        return bookingService.createBooking(showId, numberOfSeats);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
    @DeleteMapping("/cancel")
    public String deleteBooking(@RequestParam Long showId, @RequestParam int numberOfSeats) {
        bookingService.cancelSeats(showId, numberOfSeats);
        return "Ticket(s) canceled successfully.";
    }

    }
