package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Student1;
import utility.ConnectionManager;

public class StudentDAO implements Studentinterface{

	public void Create(Student1 student1) {
		ConnectionManager con = new ConnectionManager();
		if(con!=null)
		     System.out.println("Established");
		String sql = "insert into Student(roll_no,name,clas,dept,book_id) values(?,?,?,?,?)";
		PreparedStatement st;
		try {
			st = ConnectionManager.getConnection().prepareStatement(sql);
			st.setInt(1,student1.getRoll_no());
			st.setString(2,student1.getName());
			st.setString(3,student1.getClas());
			st.setString(4,student1.getDept());
			st.setInt(5,student1.getBook_id());
			st.executeUpdate();
			ConnectionManager.getConnection().close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void Display() {
		ConnectionManager con = new ConnectionManager();
		if(con!=null)
		{
			System.out.println("Established");
		}
		Statement st;
		try {
			st = ConnectionManager.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from Student");
			while(rs.next())
			{
				System.out.println("************************************************************");
				System.out.printf("%2S %7S %9S %13S %17S","ROLL_NO","NAME","CLASS","DEPT","BOOK_ID");
				System.out.println();
				System.out.println();
				System.out.printf("%2S %10S %9S %13S %15S",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				System.out.println();
				System.out.println("************************************************************");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	public void Update(Student1 student2) {
		int re = 0;
		ConnectionManager con  = new ConnectionManager();
		if(con!=null)
		System.out.println("Established");
			
	String sql = "update Student set roll_no = ?,name = ?,clas = ?,dept = ? where book_id = ?";
	PreparedStatement st;
	try {
		st = ConnectionManager.getConnection().prepareStatement(sql);
		st.setInt(1,student2.getRoll_no());
		st.setString(2,student2.getName());
		st.setString(3,student2.getClas());
		st.setString(4,student2.getDept());
		st.setInt(5,student2.getBook_id());
		
		
		re = st.executeUpdate();
		
		if(re == 1) {
				System.out.println("Student details have been succesfully updated");
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
		ConnectionManager con = new ConnectionManager();
		if(con!=null)
		{
			System.out.println("Established");
		}
		String sql = "delete from Student where book_id=?";
		PreparedStatement st;
		try {
			st = ConnectionManager.getConnection().prepareStatement(sql);
			st.setInt(1,book_id2);
			int re = st.executeUpdate();
			
			if(re == 1) {
					System.out.println("Student details have been succesfully deleted");
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
	}
	



