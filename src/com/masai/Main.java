package com.masai;

import entity.*;
import services.*;
import utility.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import exceptions.*;
import utility.*;


class Main{
	
	public static void admin(Scanner sc,Map<Integer,course> c,Map<Integer,batch> b,Map<Integer,student> s) throws invalidadmindetails {
		
		adminlogin(sc);
		
		
		int choise = 0;
		try {
		do {
			
			System.out.println("Press 1 for Add New Course");
			System.out.println("Press 2 for Search information about Course");
			System.out.println("Press 3 for Update Details about Course");
			System.out.println("Press 4 for Create New Batch");
			System.out.println("Press 5 for Search information about Batch");
			System.out.println("Press 6 for Update Details about Batch");
			System.out.println("Press 7 for View student details");
			System.out.println("Press 8 for View the student list of a batch");
			System.out.println("Press 9 for View the courses list");
			System.out.println("Press 10 for View the batch list");
			choise = sc.nextInt();
			
			switch(choise) {
			case 1: System.out.println(addcourse(sc,c));
			break;
			
			case 9: viewAll(c);
			break;
			
			case 2: search(sc,c);
			break;
			
			case 3: System.out.println(updateCourse(sc,c));
			break;
			
			case 4: System.out.println(addbatch(sc,b));
			break;
			
			case 5: searchbatch(sc,b);
			break;
			
			case 6: updatebatch(sc,b);
			break;
			case 8: displaystudent(s);
			break;
			case 10: viewAl(b);
			break;
			
			case 0: System.out.println("Loged Out");
			break;
			
			default : throw new Illegalargumentexception("Illegal Argument Entered "+choise);
			}
			
		}while(choise<=10);
		
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	
		private static void displaystudent(Map<Integer, student> s) throws courseException {
		// TODO Auto-generated method stub
			
			StudentService.viewall(s);
		
		}

		private static String updatebatch(Scanner sc, Map<Integer, batch> b) throws courseException {
		// TODO Auto-generated method stub
			System.out.println("Enter the ID of the batch you want update");
			int id = sc.nextInt();
			if(!b.containsKey(id)) {
				throw new courseException("There is no course with this key");
			}
			
			System.out.println("Please Enter Name of batch : ");
			String name = sc.next();
			
			System.out.println("Enter the Starting date of the batch ");
			String dura = sc.next();
			
			System.out.println("Enter the Ending date of the batch ");
			String Fee = sc.next();
			
			System.out.println("Enter the course name : ");
			String des = sc.next();
			
			batch cd = new batch(id,name,dura,Fee,des);
			String str = BatchService.update(id,b,cd);
			return str;
		}

		private static void search(Scanner sc, Map<Integer, course> c) throws courseException {
		// TODO Auto-generated method stub
			
			System.out.println("Press 1-->Search by name Press 2--->Search by Course Duration Press 3-->Search by Fee Range");
			int choise = sc.nextInt();
			if(choise>3 || choise<1) {
				throw new courseException("Invalid Choise");
			}
			 
			Map<Integer,course> map = null;
			if(choise == 1) {
				System.out.println("Please Enter the Course Name");
				String name = sc.next();
				map = CourseService.searchbyname(name,c);
			}
			else if(choise == 2) {
				System.out.println("Please Enter the Duration in months range(min-max)");
				int min = sc.nextInt();
				int max = sc.nextInt();
				map = CourseService.searchbyduration(min,max,c);
			}
			else if(choise == 3) {
				System.out.println("Please Enter the Fee in range(min-max)");
				int min = sc.nextInt();
				int max = sc.nextInt();
				map = CourseService.searchbyfee(min,max,c);
			}
			viewAll(map);
	}

		private static String updateCourse(Scanner sc, Map<Integer, course> c) throws courseException {
		// TODO Auto-generated method stub
			System.out.println("Enter the ID of the course you want tot update");
			int id = sc.nextInt();
			if(!c.containsKey(id)) {
				throw new courseException("There is no course with this key");
			}
			
			System.out.println("Please Enter Name of Course : ");
			String name = sc.next();
			
			System.out.println("Enter the Duration of the course in months : ");
			int dura = sc.nextInt();
			
			System.out.println("Enter the Fee of the course : ");
			int Fee = sc.nextInt();
			
			System.out.println("Enter the Description of the course : ");
			String des = sc.next();
			course cd = new course(id,dura,name,Fee,des);
			String str = CourseService.update(id,c,cd);
			return str;
	}

		public static void viewAll(Map<Integer,course> c) throws courseException {
		// TODO Auto-generated method stub
		 CourseService.viewAll(c);
		}
	

	public static String addcourse(Scanner sc,Map<Integer,course> map) {
		System.out.println("Please Enter New COurse Details");
		System.out.println("Please Enter Name of Course : ");
		String name = sc.next();
		
		System.out.println("Enter the Duration of the course in months : ");
		int dura = sc.nextInt();
		
		System.out.println("Enter the Fee of the course : ");
		int Fee = sc.nextInt();
		
		System.out.println("Enter the Description of the course : ");
		String des = sc.next();
		int id = IdGen.idGen();
		course cd = new course(id,dura,name,Fee,des);
		
		String str = CourseService.addCourse(id,cd,map);
		return str;	
	}
	
	public static String addbatch(Scanner sc,Map<Integer,batch> map) throws courseException, BatchException {
		System.out.println("Please Enter New Batch Details");
		System.out.println("Please Enter Name of name : ");
		String name = sc.next();
		
		System.out.println("Enter the Starting date (dd-mm-yyyy) : ");
		String dura = sc.next();
		
		System.out.println("Enter the Ending date (dd-mm-yyyy) : ");
		String Fee = sc.next();
		System.out.println("Enter the Course Name : ");
		String course = sc.next();
		int id = IdGen.idGen();
		batch cd = new batch(id,name,dura,Fee,course);
		String str = BatchService.addbatch(id,cd,map);
		return str;
	}
	
	
	
	private static void searchbatch(Scanner sc, Map<Integer, batch> c) throws courseException, BatchException {
		// TODO Auto-generated method stub
			
			System.out.println("Press 1-->Search by name Press 2--->Search by Course name");
			int choise = sc.nextInt();
			if(choise>2 || choise<1) {
				throw new courseException("Invalid Choise");
			}
			 
			Map<Integer,batch> map = null;
			if(choise == 1) {
				System.out.println("Please Enter the Batch Name");
				String name = sc.next();
				map = BatchService.searchbyname(name,c);
			}
			else if(choise == 2) {
				System.out.println("Please Enter the Course Name ");
				String name = sc.next();
				map = BatchService.searchbycourse(name,c);
			}
			
			viewAl(map);
	}
	
	
	
	
	private static void viewAl(Map<Integer, batch> map) throws BatchException {
		// TODO Auto-generated method stub
		BatchService.viewAll(map);
	}

	public static void adminlogin(Scanner sc) throws invalidadmindetails {
		// TODO Auto-generated method stub
		System.out.println("Please Enter User Name : ");
		String name = sc.next();
		System.out.println("Enter Password Here : ");
		String pass = sc.next();
		if(name.equals(Admin.usn) && pass.equals(Admin.pass)) {
			System.out.println("Successfully Loged in");
		}
		else {
			throw new invalidadmindetails("Wrong Admin Credentials");
		}
	  }
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		Map<Integer,course> course = FileExists.course();
		Map<Integer,batch> batch = FileExists.batch();
		Map<Integer,entity.student> student  = FileExists.student();
		
		Scanner sc = new Scanner(System.in);
		try {
			
			int choice = 0;
			do {
				System.out.println("Welcome, Student Registration System");
				System.out.println("Press 1---> Admin Login, Press 2---> Student Login, Press 3---> Student Sign Up, Press 0--->Exit");
				choice = sc.nextInt();
				switch(choice) {
				case 1: admin(sc,course,batch,student);
				break;
				
				case 2: studentfun(sc,course,batch,student);
				break;
				case 3: System.out.println(signUp(sc,student));
				case 0: System.out.println("Successfully exited");
				break;
				default: throw new Illegalargumentexception("Invalid choise");
				}
			}while(choice!=0);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.ser"));
			oos.writeObject(course);
			
			ObjectOutputStream ooss = new ObjectOutputStream(new FileOutputStream("batch.ser"));
			ooss.writeObject(batch);
			
			ObjectOutputStream oosss = new ObjectOutputStream(new FileOutputStream("student.ser"));
			oosss.writeObject(student);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	private static void studentfun(Scanner sc, Map<Integer, course> course, Map<Integer, batch> batch,
			Map<Integer, student> student) {
		// TODO Auto-generated method stub
		
	}

	private static String signUp(Scanner sc, Map<Integer, student> student) throws courseException, BatchException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Please Enter your first name ");
		String fname = sc.next();
		System.out.println("Please Enter your Last name ");
		String lname = sc.next();
		System.out.println("Please Enter Your complete Address ");
		String address = sc.next();
		System.out.println("Please Enter Your Mobile Number ");
		String number = sc.next();
		System.out.println("Please Enter Your Email ");
		String email = sc.next();
		System.out.println("Please Enter Your Password ");
		String password = sc.next();
		int id = IdGen.idGen();
		student s = new student(id,fname,lname,address,number,email,password);
		String str = StudentService.addstudent(id,s,student);
		return str;
	}

	

	
}
