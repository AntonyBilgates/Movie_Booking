package com.BookingTicket.MovieBooking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_show") 
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theater theater;

    private String showTime;
    private int availableSeats;
	public Show() {
		
	}
	public Long getId() {
		return id;
	}
	public Movie getMovie() {
		return movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public String getShowTime() {
		return showTime;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return "Show [id=" + id + ", movie=" + movie + ", theater=" + theater + ", showTime=" + showTime
				+ ", availableSeats=" + availableSeats + "]";
	}

	
   
}
