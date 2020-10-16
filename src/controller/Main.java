package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

import service.Admin;
import service.User;

public class Main {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException,DateTimeParseException 
		{
			
		System.out.println(".................**************WELCOME TO LIBRARY**************.................");
		 loginAs();
		
		}
		
		public static void loginAs() throws ClassNotFoundException, IOException, SQLException {
			  int option = 1 ;	
	while(true) {		
		System.out.println("Login as\n1. Admin\n2. User\n3. Logout");
		System.out.println("Enter Choice");
		try{
			int op = Integer.parseInt(br.readLine());
			switch(op) 
			{
			case 1:
				Admin admin = new Admin();
				admin.login();
				break;
			
			case 2:
			   User user = new User();
			    user.login();
			    break;
			    
			case 3:
				option = 0;
				break;
			
			default : 
				System.out.println("Enter Valid Choice!!!");
			}
		
		}catch(NumberFormatException e) {
			System.out.println("Entered value is not a integer!!!");
		
		} 
	 
	if(option == 1)	{
		continue;
	}else
	 {
		System.out.println("*******************>>>>>>>>>>>Keep Visiting<<<<<<<<<<<***************************");
		System.exit(0);
	 }
	}	
	}
	}

