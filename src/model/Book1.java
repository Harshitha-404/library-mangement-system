package model;

public class Book1 {
	private int book_id;
	private String title;
	private String author;
	private int availability;

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public Book1(int book_id, String title, String author, int availability) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.availability = availability;
	}
	
	}
	
	
	
	
	
	


