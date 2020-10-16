package dao;

import java.sql.SQLException;

import model.Device1;

public interface Deviceinterface {
	public void Create(Device1 device1);
	public void Display() throws ClassNotFoundException, SQLException;
	public void Update (Device1 device2) throws ClassNotFoundException, SQLException; 
	public void Delete(int book_id2) throws ClassNotFoundException, SQLException;

}
