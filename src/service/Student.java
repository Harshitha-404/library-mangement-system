package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.StudentDAO;
import model.Student1;

public class Student {
BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	public void viewOperations1() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
	   System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	   System.out.println("1. Create Student Details\n2. Display Student Details\n3. Update Student Details\n4. Delete Student Details");
	   System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	   System.out.println("Select the Operation");
	   try {
	   int ch = Integer.parseInt(br.readLine());
	   switch(ch) 
	   {
	   case 1:
		   System.out.println("Enter the Roll-no of Student");
		   int roll_no = Integer.parseInt(br.readLine());
		   System.out.println("Enter Name of Student");
		   String name = br.readLine();
		   System.out.println("Enter the class of Student");
		   String clas = br.readLine();
		   System.out.println("Enter the Department of Student");
		   String dept = br.readLine();
		   System.out.println("Enter the Book_id which he/she Need");
		   int book_id = Integer.parseInt(br.readLine());
		   Student1 student1 = new Student1(roll_no, name, clas,dept,book_id);
		   StudentDAO studentdao = new StudentDAO();
		   studentdao.Create(student1);
		   break;   
	   case 2:
		  StudentDAO studentdao1= new StudentDAO(); 
		  studentdao1.Display();
	       break;
	   
	   case 3:
		   System.out.println("Enter the roll-no of Student to update");
		   int roll_no1 = Integer.parseInt(br.readLine());
		   System.out.println("Enter Name of Student to update");
		   String name1 = br.readLine();
		   System.out.println("Enter the class of Student to update");
		   String clas1 = br.readLine();
		   System.out.println("Enter the Department of Student to update");
		   String dept1 = br.readLine();
		   System.out.println("Enter the Book_id which he/she Need to update");
		   int book_id1 = Integer.parseInt(br.readLine());
		   Student1 student2 = new Student1(roll_no1, name1, clas1,dept1,book_id1);
		   StudentDAO studentdao2 = new StudentDAO();
		   studentdao2.Update(student2);
		   break;   
	   
	   case 4:
		   System.out.println("Enter the book_id to delete");
		   int book_id2 = Integer.parseInt(br.readLine());
	       StudentDAO studentdao3 = new StudentDAO();
	       studentdao3.Delete(book_id2);
	       break;
	   
	   default:
		   System.out.println("Enter Valid Choice!!!");
	   }
	   
	   }catch(NumberFormatException e)
	   {
		   System.out.println("It should be a Number");
	   }
	}

}
