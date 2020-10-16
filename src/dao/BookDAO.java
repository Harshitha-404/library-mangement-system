package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book1;
//import service.Book;
import utility.ConnectionManager;

public class BookDAO implements Bookinterface{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	List<Book1> bookList = new ArrayList<Book1>();

	public void Create(Book1 book1) {
		ConnectionManager con  = new ConnectionManager();
		if(con!=null)
		{
			System.out.println("Established");
		}
		
	String sql = "insert into Book(book_id,title,author,availability) values(?,?,?,?)";
	PreparedStatement st;
	try {
		st = ConnectionManager.getConnection().prepareStatement(sql);
		st.setInt(1,book1.getBook_id());
		st.setString(2,book1.getTitle());
		st.setString(3,book1.getAuthor());
		st.setInt(4,book1.getAvailability());
		
		st.executeUpdate();
		ConnectionManager.getConnection().close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	public List<Book1> DisplayBook() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ConnectionManager con = new ConnectionManager();
		
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from Book");
		
		System.out.println("Book_id\t\tTitle\t\tAuthor\t\tAvailability");
		while(rs.next())
		{
			
			int id = rs.getInt("Book_id");
			String title = rs.getString("Title");
			String author = rs.getString("Author");
			int availability = rs.getInt("Availability"); 
			Book1 book = new Book1(id,title,author,availability);
			bookList.add(book);
						
		}
		
		return bookList;
	}
	
	public void Update(int book_id1, String title1, String author1, int availability1) {
		int re = 0;
		ConnectionManager con  = new ConnectionManager();
		if(con!=null)
		System.out.println("Established");
			
	String sql = "update book set title = ?,author = ?,availability = ? where book_id = ?";
	PreparedStatement st;
	try {
		st = ConnectionManager.getConnection().prepareStatement(sql);
		st.setString(1,title1);
		st.setString(2,author1);
		st.setInt(3,availability1);
		st.setInt(4, book_id1);
		re = st.executeUpdate();
		
		if(re == 1) {
				System.out.println("Book details have been succesfully updated");
				 ConnectionManager.getConnection().close();
				}else
				{
				 System.out.println("Something went wrong try again!!!!");
				 ConnectionManager.getConnection().close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

	public void Delete(int book_id2) {
		int re = 0;
		ConnectionManager con  = new ConnectionManager();
		if(con!=null)
		System.out.println("Established");
		
		
	String sql = "delete from book where book_id=?";
	PreparedStatement st;
	try {
		
		 st = ConnectionManager.getConnection().prepareStatement(sql);
		 st.setInt(1,book_id2);
		 re = st.executeUpdate();
		ConnectionManager.getConnection().close();
		
	
	if(re == 1) {
			System.out.println("Book details have been deleted successfully!!!");
			}else
			{
		     System.out.println("Something is incorrect try again");
			}
		
	    } catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    

	
	}



}
	




