package entity;
import java.io.Serializable;

import exceptions.courseException;
import services.CourseService;

import java.util.*;

import utility.FileExists;

public class batch implements Serializable{
	
	int id;
	String batchname;
	String startdate;
	String endDate;
	String Course;
	int count = 0;
	
	
	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	List<Integer> li = new ArrayList<>();
	
	public batch(int id,String name, String dates,String datee,String course){
		this.id = id;
		this.batchname = name;
		this.startdate = dates;
		this.endDate = datee;
		this.Course = course;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setLi(List<Integer> li) {
		this.li = li;
	}



	public String getBatchname() {
		return batchname;
	}



	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}



	public String getStartdate() {
		return startdate;
	}



	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public String getCourse() {
		return Course;
	}



	public void setCourse(String course) {
		Course = course;
	}



//	@Override
//	public String toString() {
//		return "batch [batchname=" + batchname + ", startdate=" + startdate + ", endDate=" + endDate + ", Course="
//				+ Course + "]";
//	}



	public List<Integer> getLi() {
		return li;
	}



	@Override
	public String toString() {
		return "batch [id=" + id + ", batchname=" + batchname + ", startdate=" + startdate + ", endDate=" + endDate
				+ ", Course=" + Course + ", Student in a batch" + count + ", Student ID's" + li + "]";
	}



//	public List<batch> getLi() {
//		// TODO Auto-generated method stub
//		return null;
//	}



	
	
}
