package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import controller.Main;
import dao.BookDAO;
import dao.DeviceDAO;
import dao.StudentDAO;
import dao.UserDAO;
import model.Book1;
import model.User1;

public class User {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      UserDAO userdao = new UserDAO();
	List<Book1> bookList = new ArrayList<Book1>();
      public void login() throws IOException, ClassNotFoundException, SQLException {

    	while(true){
		System.out.println("1. SignUp\n2. SignIn ");
		System.out.println("Enter option");
		try {
		int opt = Integer.parseInt(br.readLine());
		switch(opt)
		{
		
		case 1:
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Enter the User Name");
		String name  = br.readLine();
		System.out.println("Enter the Password");
		String password = br.readLine();
		System.out.println("Enter the E-mailId");
		String email = br.readLine();
		System.out.println("Enter the PhoneNumber");
		Long number = Long.parseLong(br.readLine());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		
		String encryptPassword = getEncoded(password);
		//System.out.println(encryptPassword);
		User1 user1 = new User1(name,encryptPassword,email,number);
		userdao.addUser(user1);
		break;
		
		case 2:
			
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("UserName Please");
			String name1 = br.readLine();
			System.out.println("PassWord Please");
			String password1 = br.readLine();
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			
			boolean result= userdao.loginUser(name1,password1);
			if(result == true)
			{
				System.out.println("Welcome " +name1);
				userOperations();
			}else
			{
				System.out.println("Invalid UserName or PassWord");
			}
			break;
			
			
		default:
			System.out.println("Enter Valid Choice!!!");
		}
		System.out.println("Do you want to add/login as User\n1. YES\n2. NO");
		int opt1 = Integer.parseInt(br.readLine());
		
		if(opt1 == 1) {
			continue;
		}else {
			break;
		}
		}catch(NumberFormatException e) {
			System.out.println("Please Enter a number!!!!!!!!!");
		}
    	}
      }
	private String getEncoded(String password) {

		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	private void userOperations() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		
		System.out.println("1. View Bookdetails\n2. View Studentdetails\n3. View Devicedetails");
		int opt = Integer.parseInt(br.readLine());
		
		switch(opt) {
		
		case 1:
			BookDAO bookdao1 = new BookDAO();
			bookList = bookdao1.DisplayBook();
			for(Book1 b : bookList) {
				System.out.println(b.getBook_id()+"\t\t"+b.getTitle()+"\t\t"+b.getAuthor()+"\t\t"+b.getAvailability());
			}
			break;
			 
				
		case 2:
			StudentDAO studentdao1= new StudentDAO(); 
			  studentdao1.Display();
			  break;
			
		case 3:
			DeviceDAO devicedao1 = new DeviceDAO();
			devicedao1.Display();
			break;
		
		default:
			System.out.println("Enter Valid Choice!!!");
			
		
		}
		
	}
	
		
	

}
