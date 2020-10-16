package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

import controller.Main;
import dao.AdminDAO;


public class Admin {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
      public void login() throws IOException, ClassNotFoundException, SQLException {
		
        System.out.println("Enter the Admin Name");
		String adminName = br.readLine();
		System.out.println("Enter the Password");
		String adminPassword = br.readLine();
		AdminDAO admindao = new AdminDAO();
		boolean result = admindao.checkCredentials(adminName,adminPassword);
		
		if(result) { 
			System.out.println("Welcome "+adminName);
			   adminOperations1();
      }
		else
		{
			System.out.println("Check Passed Credentials!!");
		}
	
		
      }
	
		public static void adminOperations1() throws DateTimeParseException, ClassNotFoundException, IOException, SQLException{
		while(true) {	
	    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("1. Book\n2. Student\n3. Device\n4.Exit");
		System.out.println("Enter ur choice for CRUD");
		try {
		int opt = Integer.parseInt(br.readLine());
		switch(opt)
		{
		case 1:
			       Book book = new Book();
			       book.viewOperations();
			       break;
		
		case 2:
			       Student student =new Student();
			       student.viewOperations1();
			       break;
			       
		case 3:
			
			      Device device = new Device();
			      device.viewOperations2();
			      break;
			 
		case 4:
			     
			     Main main = new Main();
			     Main.loginAs();
			     break;
		default:
			   System.out.println("Enter valid choice!!");
		
		}
		}catch(NumberFormatException e) {
			System.out.println("Entered value is not a number!!!");
		}
		}

      
	}
}

