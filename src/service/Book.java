package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDAO;
import model.Book1;

public class Book {
BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
List<Book1> bookList1 = new ArrayList<Book1>();
List<Book1> bookList2 = new ArrayList<Book1>(); 
	public void viewOperations() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		System.out.println("1. Create Book Details\n2. Display Book Details\n3. Update Book Details\n4. Delete Book Details\n5. Update Excel Sheet\n6. Exit");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Select the Operation");
		try {
		int ch = Integer.parseInt(br.readLine());
		
		switch(ch)
		{
		case 1:
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Enter book_id");
			int book_id = Integer.parseInt(br.readLine());
			System.out.println("Enter the title");
			String title = br.readLine();
			System.out.println("Enter the Authorname");
			String author = br.readLine();
			System.out.println("Enter number of books Available");
			int availability = Integer.parseInt(br.readLine());
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			Book1 book1 = new Book1(book_id, title, author,availability);
			BookDAO bookdao = new BookDAO();
			bookdao.Create(book1);
			 break;
			   
			   
		case 2:
			
			BookDAO bookdao1 = new BookDAO();
			bookList1 = bookdao1.DisplayBook();
			for(Book1 b : bookList1) {
				System.out.println(b.getBook_id()+"\t\t"+b.getTitle()+"\t\t"+b.getAuthor()+"\t\t"+b.getAvailability());
			}
			break;
			
		case 3 : 
			System.out.println("Enter the book_id to update");
			int book_id1 = Integer.parseInt(br.readLine());
			System.out.println("Enter the title to update");
			String title1 = br.readLine();
			System.out.println("Enter the Author to update");
			String author1 = br.readLine();
			System.out.println("Enter number of Books Available to update");
			int availability1 = Integer.parseInt(br.readLine());
			
			BookDAO bookdao2 = new BookDAO();
		    bookdao2.Update(book_id1, title1, author1,availability1);
			break;
			
		case 4:

			System.out.println("Enter the Book_id to delete,the details with reference to giving Book_id");
			int book_id2 = Integer.parseInt(br.readLine());
	
			
			BookDAO bookdao3 = new BookDAO();
		    bookdao3.Delete(book_id2);
			break;
			
		case 5:
			BookDAO bookdao11 = new BookDAO();
		    bookList2 = bookdao11.DisplayBook();
			BookExcelGeneration bookexcel = new BookExcelGeneration();
			bookexcel.generation(bookList2);
			break;
			
			
		case 6:
		
			Admin.adminOperations1();
			break;
		
			
		default :
			
			System.out.println("Enter Valid Choice!!!");
		}
			
		}catch (NumberFormatException e) {
			System.out.println("Entered value is not a integer!!!");
		}
	}
	
		}
	
	
	



