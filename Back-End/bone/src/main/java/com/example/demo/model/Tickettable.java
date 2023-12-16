package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 1001 , name ="ticketSeq" , sequenceName = "ticketSeq")
public class Tickettable {

@Id	
@GeneratedValue(strategy = GenerationType.SEQUENCE , generator= "ticketSeq")	
private int ticketid;

private int movieid;

private String username;

private String goldseatbooked;

private String silverseatbooked;

private LocalDate dateofshow;

private String slotofshow;

private int totalprice;

public int getTicketid() {
	return ticketid;
}

public void setTicketid(int ticketid) {
	this.ticketid = ticketid;
}

public int getMovieid() {
	return movieid;
}

public void setMovieid(int movieid) {
	this.movieid = movieid;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getGoldseatbooked() {
	return goldseatbooked;
}

public void setGoldseatbooked(String goldseatbooked) {
	this.goldseatbooked = goldseatbooked;
}

public String getSilverseatbooked() {
	return silverseatbooked;
}

public void setSilverseatbooked(String silverseatbooked) {
	this.silverseatbooked = silverseatbooked;
}

public LocalDate getDateofshow() {
	return dateofshow;
}

public void setDateofshow(LocalDate dateofshow) {
	this.dateofshow = dateofshow;
}

public String getSlotofshow() {
	return slotofshow;
}

public void setSlotofshow(String slotofshow) {
	this.slotofshow = slotofshow;
}

public int getTotalprice() {
	return totalprice;
}

public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}

public Tickettable(int movieid, String username, String goldseatbooked, String silverseatbooked, LocalDate dateofshow,
		String slotofshow, int totalprice) {
	super();
	this.movieid = movieid;
	this.username = username;
	this.goldseatbooked = goldseatbooked;
	this.silverseatbooked = silverseatbooked;
	this.dateofshow = dateofshow;
	this.slotofshow = slotofshow;
	this.totalprice = totalprice;
}

public Tickettable() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Tickettable [ticketid=" + ticketid + ", movieid=" + movieid + ", username=" + username + ", goldseatbooked="
			+ goldseatbooked + ", silverseatbooked=" + silverseatbooked + ", dateofshow=" + dateofshow + ", slotofshow="
			+ slotofshow + ", totalprice=" + totalprice + "]";
}




	
}
