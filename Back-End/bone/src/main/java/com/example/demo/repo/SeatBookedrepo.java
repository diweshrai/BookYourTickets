package com.example.demo.repo;


import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Seatbookedtable;

public interface SeatBookedrepo  extends  JpaRepository<Seatbookedtable , Integer>{

	
	@Modifying
    @Query(value = "INSERT INTO Seatbookedtable (movieid, totalgoldseats, totalsilverseats, availgoldseats, "
    		+      "availsilverseats, showdate, slotofshow) VALUES (:movieid, :totalgoldseats, :totalsilverseats,"
    		+      " :availgoldseats, :availsilverseats, :showdate, :slotofshow)", nativeQuery = true)
    public Seatbookedtable insertSeatbookedtable(int movieid, int totalgoldseats, int totalsilverseats, int availgoldseats,
    		int availsilverseats, String showdate, String slotofshow);
	
	public Seatbookedtable findByMovieidAndShowdateAndSlotofshow(int movieid, LocalDate showdate, String slotofshow);

	
}
