package com.BookingTicket.MovieBooking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
	public Theater() {
		
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	

    // Getters and Setters
    
    
}
