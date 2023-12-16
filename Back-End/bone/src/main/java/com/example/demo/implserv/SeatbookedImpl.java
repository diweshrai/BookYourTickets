package com.example.demo.implserv;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Seatbookedtable;
import com.example.demo.repo.SeatBookedrepo;
import com.example.demo.serv.SeatbookedServ;

@Service
public class SeatbookedImpl implements SeatbookedServ {

	@Autowired
	SeatBookedrepo seatrepo;
	
	@Override
	public List<Seatbookedtable> getallSeatBooked() {
		List<Seatbookedtable> lst = seatrepo.findAll();
		return lst;
	}

	@Override
	public Seatbookedtable addSeats(Seatbookedtable seat) {
		Seatbookedtable seat1 = seatrepo.save(seat);
		return seat1;
	}

	@Override
	public Seatbookedtable getseatbyid(int id) {
	Seatbookedtable seat1 = seatrepo.findById(id).get();
	
		return seat1;
	}

	@Override
	public Seatbookedtable insertautoData(int movieid, int totalgoldseats, int totalsilverseats, int availgoldseats,
			int availsilverseats, String showdate, String slotofshow) {
		Seatbookedtable s1 = seatrepo.insertSeatbookedtable(movieid, totalgoldseats, totalsilverseats, availgoldseats,
				availsilverseats, showdate, slotofshow);
		return s1;
	}

	@Override
	public Seatbookedtable findSeatForBooking(int movid, LocalDate date, String slot) {
		Seatbookedtable s1= seatrepo.findByMovieidAndShowdateAndSlotofshow(movid, date, slot);
		
		return s1;
	}

	@Override
	public Seatbookedtable addBookedSeats(int movid, LocalDate date, String slot, String gold, String silver ,int goldavail, int silveravail) {
		Seatbookedtable s11 = seatrepo.findByMovieidAndShowdateAndSlotofshow(movid, date, slot);
		s11.setGoldseatbooked(gold);
		s11.setSilverseatbooked(silver);
		s11.setAvailgoldseats(goldavail);
		s11.setAvailsilverseats(silveravail);
		
		
		return seatrepo.save(s11);
	}

}
