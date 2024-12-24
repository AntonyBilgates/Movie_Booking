package com.BookingTicket.MovieBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookingTicket.MovieBooking.Entity.Booking;
import com.BookingTicket.MovieBooking.Repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowService showService;

    public Booking createBooking(Long showId, int numberOfSeats) {
        showService.updateSeats(showId, numberOfSeats);

        Booking booking = new Booking();
        booking.setShow(showService.getShowById(showId));
        booking.setNumberOfSeats(numberOfSeats);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public void cancelSeats(Long showId, int numberOfSeats) {
        // Retrieve the booking for the specified showId
        Booking booking = bookingRepository.findByShowId(showId)
                .orElseThrow(() -> new RuntimeException("Booking not found for the given Show ID"));

        // Validate if enough seats were booked to cancel
        if (booking.getNumberOfSeats() < numberOfSeats) {
            throw new IllegalArgumentException("Cannot cancel more seats than booked.");
        }

        // Update the remaining seats in the Show entity
        showService.updateSeats(showId, -numberOfSeats); // Adding seats back

        // Update or delete the booking record
        if (booking.getNumberOfSeats() == numberOfSeats) {
            bookingRepository.delete(booking); // Remove booking if all seats are canceled
        } else {
            booking.setNumberOfSeats(booking.getNumberOfSeats() - numberOfSeats);
            bookingRepository.save(booking);
        }
    }
}
