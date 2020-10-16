package model;

public class Student1 {
	private int roll_no;
	private String name;
	private String clas;
	private String dept;
	private int book_id;
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public Student1(int roll_no, String name, String clas, String dept, int book_id) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.clas = clas;
		this.dept = dept;
		this.book_id = book_id;
	}
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", clas=" + clas + ", dept=" + dept + ", book_id="
				+ book_id + "]";
	}
	
	
	
	
	
	

}
