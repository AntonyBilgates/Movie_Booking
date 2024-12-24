package com.BookingTicket.MovieBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookingTicket.MovieBooking.Entity.Show;
import com.BookingTicket.MovieBooking.Repository.ShowRepository;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShowById(Long id) {
        return showRepository.findById(id).orElseThrow(() -> new RuntimeException("Show not found"));
    }

    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    public void updateSeats(Long showId, int seatsBooked) {
        Show show = getShowById(showId);
        if (show.getAvailableSeats() < seatsBooked) {
            throw new RuntimeException("Not enough seats available");
        }
        show.setAvailableSeats(show.getAvailableSeats() - seatsBooked);
        showRepository.save(show);
    }
}
