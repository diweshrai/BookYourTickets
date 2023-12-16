package com.example.demo.contr;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Adminlogin;
import com.example.demo.model.Bonelogin;
import com.example.demo.model.Moviestable;
import com.example.demo.model.Seatbookedtable;
import com.example.demo.model.Tickettable;
import com.example.demo.serv.AdminServ;
import com.example.demo.serv.MoviestableServ;
import com.example.demo.serv.SeatbookedServ;
import com.example.demo.serv.Ser;
import com.example.demo.serv.Ticketserv;

import net.sf.jasperreports.engine.JRException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","http://192.168.1.20:3000"})


public class Contr {

	

	
@Autowired
Ser s;

@Autowired
AdminServ as;

//****************************************   User Api ************************************************

@PostMapping("/addUser")
public Bonelogin adduser(@RequestBody Bonelogin bb) {
	 System.out.println("Received username: " + bb.getName());
     System.out.println("Received password: " + bb.getPassword());

	return s.adduser(bb);
	
}

@GetMapping("/getUser")
public List<Bonelogin> getusers(){
	
	return s.getusers();
}



@PostMapping("/checkUser")
public boolean checkuser(@RequestBody Bonelogin check)
{
	
	boolean res = false;
	res = s.checkuser(check.getName(), check.getPassword());
	
	return res;
	
	
}



// ***************************************** Admin Api **********************************************************************


@PostMapping("/addAdmin")
public Adminlogin addAdmin(@RequestBody Adminlogin ad) {
	 System.out.println("Received username: " + ad.getName());
     System.out.println("Received password: " + ad.getPassword());

	return as.addAdmin(ad);
	
}

@GetMapping("/getAdmin")
public List<Adminlogin> getAdmin(){
	
	return as.getallAdmin();
}


@PostMapping("/checkAdmin")
public boolean checkAdmin(@RequestBody Adminlogin checkadmin)
{
	
	boolean res = false;
	res = as.checkAdmin(checkadmin.getName(), checkadmin.getPassword());
	//res = as.checkuser(checkadmin.getName(), checkadmin.getPassword());
	
	return res;
	
	
}


// ****************************************************  Movies Table Api ****************************************************

@Autowired
MoviestableServ movserv;

@GetMapping("/getMoviesTable")
public List<Moviestable> getallmovie(){
	List<Moviestable> lst = movserv.getallmovies();
	return lst;
}


@PostMapping("/addMovies")
public Moviestable addmovie(@RequestBody Moviestable movie) {
	return movserv.addMovies(movie);
}


@GetMapping("/getMovieById/{id}")
public Moviestable getmoviebyid(@PathVariable int id) {
	return movserv.findbymovieid(id);
}

//************************************************************** Seat Booked Table Api ***********************************************************


@Autowired
SeatbookedServ seatserv;

@GetMapping("/getAllSeatBooked")
public List<Seatbookedtable> getallSeats(){
	return seatserv.getallSeatBooked();
}

@PostMapping("/addSeatBooked")
public Seatbookedtable addseats(@RequestBody Seatbookedtable seats) {
	return seatserv.addSeats(seats);
}

@PostMapping("/insert")
public Seatbookedtable insertSeatbookedtableData(
        @RequestParam int movieid,
        @RequestParam int totalgoldseats,
        @RequestParam int totalsilverseats,
        @RequestParam int availgoldseats,
        @RequestParam int availsilverseats,
        @RequestParam String showdate,
        @RequestParam String slotofshow) {
    
        return seatserv.insertautoData(movieid, totalgoldseats, totalsilverseats, availgoldseats, availsilverseats, showdate, slotofshow);
    }



@GetMapping("/getSeatBooked/{movieid}/{date}/{slot}")
public Seatbookedtable getallSeatBooked(
		@PathVariable int movieid,
		@PathVariable String date,
		@PathVariable String slot
			) {
	 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    // Parse the date using the specified format
	    LocalDate localDate = LocalDate.parse(date, dateFormatter);
	
	Seatbookedtable ss1 = seatserv.findSeatForBooking(movieid, localDate, slot);
	
	return ss1;
}


//@RequestParam("movieid") int movieid,
//@RequestParam("date") String date,
//@RequestParam("slot")    String slot,
//@RequestParam("goldbooked")  String goldbooked,
//@RequestParam("silverbooked") String silverbooked,
//@RequestParam("availgold") int availgold,
//@RequestParam("availsilver") int  availsilver)

@PostMapping("/insertBookedSeats")
public Seatbookedtable insertBookedSeats(
		@RequestParam("movieid") int movieid,
		@RequestParam("date") String date,
		@RequestParam("slot")    String slot,
		@RequestParam("goldbooked")  String goldbooked,
		@RequestParam("silverbooked") String silverbooked,
		@RequestParam("availgold") int availgold,
		@RequestParam("availsilver") int  availsilver) {
	 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    // Parse the date using the specified format
	    LocalDate localDate = LocalDate.parse(date, dateFormatter);
    
	    Seatbookedtable ss1 = seatserv.addBookedSeats(movieid, localDate, slot, goldbooked, silverbooked, availgold, availsilver);
	    
        return  ss1;
    }

//***********************************************  Ticket table Api ******************************************************


@Autowired
Ticketserv tckserv;

@GetMapping("/getTicket")
public List<Tickettable> getallTicket(){
	return tckserv.getallTicket();
}

@PostMapping("/addTicket")	
public Tickettable addTicket(@RequestBody Tickettable tcck) {
	return tckserv.addTicket(tcck);
}


@GetMapping("/findByName/{uname}")
public List<Tickettable> getallticketbyname(@PathVariable String uname){
	List<Tickettable> lsst = tckserv.getbyname(uname);
	return lsst;
}



@RequestMapping("/excel")
public ResponseEntity<Resource> download(){
	String filename = "ticket.xlsx";
	ByteArrayInputStream actualData = tckserv.getActualData();
	InputStreamResource  file = new InputStreamResource(actualData);
	
	
	ResponseEntity<Resource> body = ResponseEntity.ok()
		    .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		    .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		    .body(file);
	
	return body;
	
		
}



@GetMapping("/pdf")
public ResponseEntity<Resource> exportPdf() throws FileNotFoundException {
    try {
        return tckserv.generatePdf();
    } catch (JRException e) {
        // Handle the exception appropriately
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}



}
