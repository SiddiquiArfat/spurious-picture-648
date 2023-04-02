package entity;

import java.io.Serializable;

public class student implements Serializable{
	
	int studentId;
	String fname;
	String lname;
	String address;
	String number;
	String email;
	String password;
	
	public student(int id, String fname2, String lname2, String address2, String number2, String email2,
			String password2) {
		// TODO Auto-generated constructor stub
		this.studentId = id;
		this.fname = fname2;
		this.lname = lname2;
		this.address = address2;
		this.number = number2;
		this.email = email2;
		this.password = password2;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "student [studentId=" + studentId + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", number=" + number + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
