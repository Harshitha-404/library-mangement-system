package dao;

import java.sql.SQLException;

import model.User1;

public interface Userinterface {

	public void addUser(User1 user1) throws ClassNotFoundException, SQLException ;
	public boolean loginUser(String name1, String password1) throws ClassNotFoundException, SQLException ;
	
}
