package com.BookingTicket.MovieBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookingTicket.MovieBooking.Entity.Show;
import com.BookingTicket.MovieBooking.Service.ShowService;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @PostMapping
    public Show addShow(@RequestBody Show show) {
        return showService.addShow(show);
    }
}
