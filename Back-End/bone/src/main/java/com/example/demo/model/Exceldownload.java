package com.example.demo.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldownload {

	
	public static String[] HEADERS = {
			"Ticket-id",
			"Movie-Id",
			"Username",
			"GoldSeatBooked",
			"SilverSeatBooked",
			"SlotOfShow",
			"Date-Of-Show",
			"Total-Price"
	};
	
	
	
	public static String SHEET_NAME = "ticket_data";
	
	public static ByteArrayInputStream dataToExcel(List<Tickettable> list) {
		
		try {
			
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			
			Sheet sheet = workbook.createSheet(SHEET_NAME);
			
			Row row = sheet.createRow(0);
			for(int i=0; i<HEADERS.length;i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}
			
			int rowIndex =1;
			
			for(Tickettable c:list) {
				Row dataRow = sheet.createRow(rowIndex);
				rowIndex++;
				
				dataRow.createCell(0).setCellValue(c.getTicketid());
				dataRow.createCell(1).setCellValue(c.getMovieid());
				dataRow.createCell(2).setCellValue(c.getUsername());
				dataRow.createCell(3).setCellValue(c.getGoldseatbooked());
				dataRow.createCell(4).setCellValue(c.getSilverseatbooked());
				dataRow.createCell(5).setCellValue(c.getSlotofshow());
				dataRow.createCell(6).setCellValue(c.getDateofshow());
				dataRow.createCell(7).setCellValue(c.getTotalprice());
			
				
				
			}
			
			workbook.write(out);
			
			return new ByteArrayInputStream(out.toByteArray());
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
			return(null);
		}finally {
			
		}
		
		
	}
	
	
}
