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
  


class Main{
	
	
	
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
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		Map<Integer,course> course = FileExists.course();
		
		
		Scanner sc = new Scanner(System.in);
		try {
			
			int choice = 0;
			do {
				System.out.println("Welcome, Student Registration System");
				System.out.println("Press 1---> Admin Login, Press 2---> Student Login, Press 3---> Student Sign Up, Press 0--->Exit");
				choice = sc.nextInt();
				switch(choice) {
				case 1: adminlogin(sc);
				break;
				case 0: System.out.println("Successfully exited");
				break;
				}
			}while(choice!=0);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("course.ser"));
			oos.writeObject(course);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	

	
}
