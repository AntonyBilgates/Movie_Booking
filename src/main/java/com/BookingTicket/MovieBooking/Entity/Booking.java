package com.BookingTicket.MovieBooking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Show show;

    private int numberOfSeats;

	public Booking() {
		
	}

	public Long getId() {
		return id;
	}

	public Show getShow() {
		return show;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", show=" + show + ", numberOfSeats=" + numberOfSeats + "]";
	}

	
	
    // Getters and Setters
    
}
