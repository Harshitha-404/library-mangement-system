package model;

public class User1 {
	private String name;
	private String password;
	private String email;
	private long number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public User1(String name, String password, String email, long number) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.number = number;
	}
	}
