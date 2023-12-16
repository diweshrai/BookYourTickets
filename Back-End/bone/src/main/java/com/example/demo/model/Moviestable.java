package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 500 , name ="addSeq" , sequenceName = "addSeq")
public class Moviestable {

	
@Id	
@GeneratedValue(strategy = GenerationType.SEQUENCE , generator= "addSeq")
private int movieid;

private String moviename;

private int stars;

private LocalDate startdate;


private LocalDate enddate;

private String slot912;

private String slot1215;

private String slot1518;

private String slot1821;

private int goldprice;

private int silverprice;

private String imgurl;

private String language;

public int getMovieid() {
	return movieid;
}

public void setMovieid(int movieid) {
	this.movieid = movieid;
}

public String getMoviename() {
	return moviename;
}

public void setMoviename(String moviename) {
	this.moviename = moviename;
}

public int getStars() {
	return stars;
}

public void setStars(int stars) {
	this.stars = stars;
}

public LocalDate getStartdate() {
	return startdate;
}

public void setStartdate(LocalDate startdate) {
	this.startdate = startdate;
}

public LocalDate getEnddate() {
	return enddate;
}

public void setEnddate(LocalDate enddate) {
	this.enddate = enddate;
}

public String getSlot912() {
	return slot912;
}

public void setSlot912(String slot912) {
	this.slot912 = slot912;
}

public String getSlot1215() {
	return slot1215;
}

public void setSlot1215(String slot1215) {
	this.slot1215 = slot1215;
}

public String getSlot1518() {
	return slot1518;
}

public void setSlot1518(String slot1518) {
	this.slot1518 = slot1518;
}

public String getSlot1821() {
	return slot1821;
}

public void setSlot1821(String slot1821) {
	this.slot1821 = slot1821;
}

public int getGoldprice() {
	return goldprice;
}

public void setGoldprice(int goldprice) {
	this.goldprice = goldprice;
}

public int getSilverprice() {
	return silverprice;
}

public void setSilverprice(int silverprice) {
	this.silverprice = silverprice;
}

public String getImgurl() {
	return imgurl;
}

public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public Moviestable(String moviename, int stars, LocalDate startdate, LocalDate enddate, String slot912, String slot1215,
		String slot1518, String slot1821, int goldprice, int silverprice, String imgurl, String language) {
	super();
	this.moviename = moviename;
	this.stars = stars;
	this.startdate = startdate;
	this.enddate = enddate;
	this.slot912 = slot912;
	this.slot1215 = slot1215;
	this.slot1518 = slot1518;
	this.slot1821 = slot1821;
	this.goldprice = goldprice;
	this.silverprice = silverprice;
	this.imgurl = imgurl;
	this.language = language;
}

@Override
public String toString() {
	return "Moviestable [movieid=" + movieid + ", moviename=" + moviename + ", stars=" + stars + ", startdate="
			+ startdate + ", enddate=" + enddate + ", slot912=" + slot912 + ", slot1215=" + slot1215 + ", slot1518="
			+ slot1518 + ", slot1821=" + slot1821 + ", goldprice=" + goldprice + ", silverprice=" + silverprice
			+ ", imgurl=" + imgurl + ", language=" + language + "]";
}

public Moviestable() {
	super();
	// TODO Auto-generated constructor stub
}


	
}
