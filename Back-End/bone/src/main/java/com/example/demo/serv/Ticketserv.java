package com.example.demo.serv;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Tickettable;

import net.sf.jasperreports.engine.JRException;

public interface Ticketserv {

	public List<Tickettable> getallTicket();
	
	public Tickettable addTicket(Tickettable tck);
	
	public List<Tickettable> getbyname(String uname);
	
	
	public ByteArrayInputStream getActualData();
	
	
	

	public ResponseEntity<Resource> generatePdf() throws JRException, FileNotFoundException;
	
	
	
}
