package model;


import java.time.LocalDate;

public class Device1 {
	private int roll_no;
	private  int book_id;
	private LocalDate date_of_issue;
	private String status;
	
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public LocalDate getDate_of_issue() {
		return date_of_issue;
	}
	public void setDate_of_issue(LocalDate date_of_issue) {
		this.date_of_issue = date_of_issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Device1(int roll_no, int book_id, LocalDate date_of_issue, String status) {
		super();
		this.roll_no = roll_no;
		this.book_id = book_id;
		this.date_of_issue = date_of_issue;
		this.status = status;
	}
	

}
