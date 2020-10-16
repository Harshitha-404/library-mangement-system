package service;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import model.Book1;

public class BookExcelGeneration {
String filename = "C:\\Users\\Harshitha M H\\Desktop\\repo\\books.xls";
	int i=1;
	FileOutputStream fileOutput;
	public void generation(List<Book1> bookList) {
	try {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Book Details");
		Row row = sheet.createRow(0);
	
	  row.createCell(0).setCellValue("Book_id");
	  row.createCell(1).setCellValue("Book Title");
	  row.createCell(2).setCellValue("Book Author");
	  row.createCell(3).setCellValue("Available");
	  
	  for(Book1 b : bookList) {
		  
		  Row nextRow = sheet.createRow(i);
		  
		  nextRow.createCell(0).setCellValue(b.getBook_id());
		  nextRow.createCell(1).setCellValue(b.getTitle());
		  nextRow.createCell(2).setCellValue(b.getAuthor());
		  nextRow.createCell(3).setCellValue(b.getAvailability());
		  i++;
		}
	  
	  fileOutput = new FileOutputStream(filename);
	  wb.write(fileOutput);
	  System.out.println("Excel generated!!!");
	  
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
		
	}

}
