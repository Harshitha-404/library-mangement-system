package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.ConnectionManager;

public class AdminDAO {

	public boolean checkCredentials(String adminName, String adminPassword) throws ClassNotFoundException, SQLException {
		ConnectionManager con = new ConnectionManager();
		if(con!=null)
			System.out.println("Connection Established");
		
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from admin");
		while(rs.next())
		{
			if(rs.getString(1).equals(adminName) && rs.getString(2).equals(adminPassword))
			{
				return true;
			}
		}
		return false;
	}
	}
