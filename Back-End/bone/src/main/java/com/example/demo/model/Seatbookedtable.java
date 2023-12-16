package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 800 , name ="addbook" , sequenceName = "addbook")
public class Seatbookedtable {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE , generator= "addbook")
private int sbid;	

private int movieid;

private int totalgoldseats;


private int totalsilverseats;

@Column(nullable = true) 
private String goldseatbooked;

@Column(nullable = true) 
private String silverseatbooked;

private int availgoldseats;

private int availsilverseats;

private LocalDate showdate;

private String slotofshow;

public int getSbid() {
	return sbid;
}

public void setSbid(int sbid) {
	this.sbid = sbid;
}

public int getMovieid() {
	return movieid;
}

public void setMovieid(int movieid) {
	this.movieid = movieid;
}

public int getTotalgoldseats() {
	return totalgoldseats;
}

public void setTotalgoldseats(int totalgoldseats) {
	this.totalgoldseats = totalgoldseats;
}

public int getTotalsilverseats() {
	return totalsilverseats;
}

public void setTotalsilverseats(int totalsilverseats) {
	this.totalsilverseats = totalsilverseats;
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

public int getAvailgoldseats() {
	return availgoldseats;
}

public void setAvailgoldseats(int availgoldseats) {
	this.availgoldseats = availgoldseats;
}

public int getAvailsilverseats() {
	return availsilverseats;
}

public void setAvailsilverseats(int availsilverseats) {
	this.availsilverseats = availsilverseats;
}

public LocalDate getShowdate() {
	return showdate;
}

public void setShowdate(LocalDate showdate) {
	this.showdate = showdate;
}

public String getSlotofshow() {
	return slotofshow;
}

public void setSlotofshow(String slotofshow) {
	this.slotofshow = slotofshow;
}

public Seatbookedtable(int movieid, int totalgoldseats, int totalsilverseats, String goldseatbooked, String silverseatbooked,
		int availgoldseats, int availsilverseats, LocalDate showdate, String slotofshow) {
	super();
	this.movieid = movieid;
	this.totalgoldseats = totalgoldseats;
	this.totalsilverseats = totalsilverseats;
	this.goldseatbooked = goldseatbooked;
	this.silverseatbooked = silverseatbooked;
	this.availgoldseats = availgoldseats;
	this.availsilverseats = availsilverseats;
	this.showdate = showdate;
	this.slotofshow = slotofshow;
}

@Override
public String toString() {
	return "Seatbookedtable [sbid=" + sbid + ", movieid=" + movieid + ", totalgoldseats=" + totalgoldseats
			+ ", totalsilverseats=" + totalsilverseats + ", goldseatbooked=" + goldseatbooked + ", silverseatbooked="
			+ silverseatbooked + ", availgoldseats=" + availgoldseats + ", availsilverseats=" + availsilverseats
			+ ", showdate=" + showdate + ", slotofshow=" + slotofshow + "]";
}

public Seatbookedtable() {
	super();
	// TODO Auto-generated constructor stub
}






}
