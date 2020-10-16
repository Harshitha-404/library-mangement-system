package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UnknownFormatConversionException;

import model.Device1;
import utility.ConnectionManager;

public class DeviceDAO implements Deviceinterface{

	public void Create(Device1 device1) {
		ConnectionManager con  = new ConnectionManager();
		if(con!=null)
		{
			System.out.println("Established");
		}
		
	String sql = "insert into system(roll_no,book_id,date_of_issue,status) values(?,?,?,?)";
	PreparedStatement st;
	try {
		st = ConnectionManager.getConnection().prepareStatement(sql);
		st.setInt(1,device1.getRoll_no());
		st.setInt(2,device1.getBook_id());
		st.setDate(3,java.sql.Date.valueOf(device1.getDate_of_issue()));
		st.setString(4,device1.getStatus());
		
		st.executeUpdate();
		ConnectionManager.getConnection().close();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


		
	}

	public void Display() throws ClassNotFoundException, SQLException ,UnknownFormatConversionException{
		ConnectionManager con = new ConnectionManager();
		if(con!=null)
		{
			System.out.println("Established");
		}
		
		Statement st;
	
			st = ConnectionManager.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from system");
			while(rs.next())
			{
				System.out.println("************************************************************");
				System.out.printf("%2S %9S %17S %18S","ROLL_NO","BOOK_ID","DATE_OF_ISSUE","STATUS");
				System.out.println();
				System.out.println();
				System.out.printf("%2S %9S %19S %18S ",rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4));
				System.out.println();
				System.out.println("************************************************************");
			}
			
		}
		
	

	public void Update(Device1 device2) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ConnectionManager con = new ConnectionManager();
		if(con!=null)
		{
			System.out.println("Established");
		}
		
		String sql = "update system set roll_no = ?,date_of_issue=?,status=? where book_id = ?";
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		
		st.setInt(1,device2.getRoll_no());
        st.setDate(2,java.sql.Date.valueOf(device2.getDate_of_issue()));
		st.setString(3,device2.getStatus());
		st.setInt(4,device2.getBook_id());
		
		int re=st.executeUpdate();
		ConnectionManager.getConnection().close();
		if(re == 1) {
			System.out.println("Details have been succesfully updated");
			 ConnectionManager.getConnection().close();
			}else
			{
			 System.out.println("Something went wrong try again!!!!");
			 ConnectionManager.getConnection().close();
			}
		 
	}

	public void Delete(int book_id2) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ConnectionManager con = new ConnectionManager();
		if(con!=null)
		{
			System.out.println("Established");
		}
		
		String sql = "delete from system where book_id = ?";
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		st.setInt(1, book_id2);
		int re=st.executeUpdate();
		ConnectionManager.getConnection().close();
		if(re == 1) {
			System.out.println("Details have been succesfully deleted");
			 ConnectionManager.getConnection().close();
			}else
			{
			 System.out.println("Something went wrong try again!!!!");
			 ConnectionManager.getConnection().close();
			}
		 
	}
			
    }

	


