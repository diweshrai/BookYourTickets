package com.example.demo.implserv;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.model.Exceldownload;
import com.example.demo.model.Tickettable;
import com.example.demo.repo.Ticketrepo;
import com.example.demo.serv.Ticketserv;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class TicketImpl implements Ticketserv {

	@Autowired
	Ticketrepo tckrepo;
	
	@Override
	public List<Tickettable> getallTicket() {
		List<Tickettable> lst = tckrepo.findAll();
		return lst;
	}

	@Override
	public Tickettable addTicket(Tickettable tck) {
		Tickettable tck1 = tckrepo.save(tck);
		return tck1;
	}

	@Override
	public List<Tickettable> getbyname(String uname) {
List<Tickettable> lst = tckrepo.findByUsername(uname);
		return lst;
	}

	@Override
	public ByteArrayInputStream getActualData() {
		List<Tickettable> all = tckrepo.findAll();
		ByteArrayInputStream bytes = Exceldownload.dataToExcel(all);
		
		return bytes;
	}

	@Override
	 public ResponseEntity<Resource> generatePdf() throws JRException, FileNotFoundException{
		 List<Tickettable> alltck = tckrepo.findAll();

	        File file = ResourceUtils.getFile("classpath:Tickettable.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alltck);

	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("created by", "Diwesh rai");

	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

	        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
	        JasperExportManager.exportReportToPdfStream(jasperPrint, pdfStream);

	        byte[] pdfBytes = pdfStream.toByteArray();

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=Tickettable.pdf");

	        return ResponseEntity.ok()
	            .headers(headers)
	            .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
	            .body(new ByteArrayResource(pdfBytes));
	    }
	}


