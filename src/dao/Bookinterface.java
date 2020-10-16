package dao;

import java.sql.SQLException;
import java.util.List;

import model.Book1;

public interface Bookinterface {
	public void Create(Book1 book1);
    public List<Book1> DisplayBook() throws ClassNotFoundException, SQLException ;
	public void Update(int book_id1, String title1, String author1, int availability1);
    public void Delete(int book_id2);
}
