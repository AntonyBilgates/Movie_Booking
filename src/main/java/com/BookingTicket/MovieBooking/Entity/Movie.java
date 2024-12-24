package com.BookingTicket.MovieBooking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String duration;
	public Movie() {
		
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public String getDuration() {
		return duration;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", duration=" + duration + "]";
	}
	

    
}
