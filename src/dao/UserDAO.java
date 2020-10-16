package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User1;
import utility.ConnectionManager;

public class UserDAO implements Userinterface{

	public void addUser(User1 user1) throws ClassNotFoundException, SQLException {
		ConnectionManager con = new ConnectionManager();
		String sql = "insert into LibraryUsers(user_name,password,email_id,phone_number)values(?,?,?,?)";
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		
		st.setString(1, user1.getName());
		st.setString(2, user1.getPassword());
		st.setString(3, user1.getEmail());
		st.setLong(4,user1.getNumber());
		
		int re = st.executeUpdate();
		
		if(re == 1) {
			System.out.println("Details Added Successfully into Table!!!");
		}else
		{
			System.out.println("Details not Added into Table");
			
		}
	     ConnectionManager.getConnection().close();
	}

	public boolean loginUser(String name1, String password1) throws ClassNotFoundException, SQLException {
		ConnectionManager con = new ConnectionManager();
		
		Statement stmt = ConnectionManager.getConnection().createStatement();
		
		ResultSet rs = stmt.executeQuery("Select * from Libraryusers");
		
		while(rs.next())
		{
			if(rs.getString(1).equals(name1)&& rs.getString(2).equals(password1)) 
			{
				
				return true;
			}
			}
		return false;
		}

	
	

}
