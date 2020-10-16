package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dao.DeviceDAO;

import model.Device1;

public class Device {
BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	public void viewOperations2() throws IOException, ClassNotFoundException, SQLException,DateTimeParseException {
System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		System.out.println("1. Create Device Details\n2. Display Device Details\n3. Update Device Details\n4. Delete Device Details");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Select the Operation");
		try {
		int ch = Integer.parseInt(br.readLine());
		
		switch(ch)
		{
		case 1:
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Enter Student Roll_no");
			int roll_no = Integer.parseInt(br.readLine());
			System.out.println("Enter the Book_id");
			int book_id = Integer.parseInt(br.readLine());
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Enter the Date_of_issue");
			String localdate = br.readLine();
			LocalDate date = LocalDate.parse(localdate, formatter);
			System.out.println(date);
			
			System.out.println("Status");
			String status =br.readLine(); 
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>BOOK ISSUED/RETURNED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			
			
			Device1 device1 = new Device1(roll_no,book_id,date,status);
            DeviceDAO devicedao = new DeviceDAO();
            devicedao.Create(device1);
            break;
            
		case 2:
			DeviceDAO devicedao1 = new DeviceDAO();
			devicedao1.Display();
			break;
			
		case 3:
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Enter Student Roll_no to update");
			int roll_no1 = Integer.parseInt(br.readLine());
			System.out.println("Enter the Book_id to update the referenced details with the id");
			int book_id1 = Integer.parseInt(br.readLine());
			
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Enter the Date_of_issue to update");
			String localdate1 = br.readLine();
			LocalDate date1 = LocalDate.parse(localdate1, formatter1);
			System.out.println(date1);
			
			System.out.println("Status");
			String status1 =br.readLine(); 

            Device1 device2 = new Device1(roll_no1,book_id1,date1,status1);
            DeviceDAO devicedao2 = new DeviceDAO();
            devicedao2.Update(device2);
            break;
			
		case 4:
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Enter the book_id to delete the details with reference to giving book_id");
			int book_id2 = Integer.parseInt(br.readLine());
			DeviceDAO devicedao3 = new DeviceDAO();
			devicedao3.Delete(book_id2);
			break;
			
		default :
			System.out.println("Enter Valid Choice!!!");
		}
		}catch(NumberFormatException e)
		{
			System.out.println("Please enter integer value!!!");
	}

	}
}
