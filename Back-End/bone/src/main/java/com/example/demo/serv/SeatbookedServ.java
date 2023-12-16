package com.example.demo.serv;


import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Seatbookedtable;

public interface SeatbookedServ {
	
	public List<Seatbookedtable> getallSeatBooked();
	
	public Seatbookedtable addSeats(Seatbookedtable seat);
	
	public Seatbookedtable getseatbyid(int id);
	
	public Seatbookedtable insertautoData(int movieid, int totalgoldseats, int totalsilverseats, int availgoldseats,
    		int availsilverseats, String showdate, String slotofshow);

	public Seatbookedtable findSeatForBooking(int movid, LocalDate date, String slot);
	
	
	public Seatbookedtable addBookedSeats(int movid, LocalDate date, String slot, String gold, String silver, int goldavail, int silveravail);
	
}
