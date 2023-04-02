package services;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import entity.batch;
import entity.course;
import entity.student;
import exceptions.BatchException;
import exceptions.courseException;
import utility.FileExists;

public class StudentService{
	public static String addstudent(int id, student cd, Map<Integer, student> map) throws courseException, BatchException, ClassNotFoundException, IOException{
				map.put(id, cd);
//				Map<Integer, batch> map2 = FileExists.batch();
				
	return "Sign-Up Successfull";
	}

	public static void viewall(Map<Integer, student> map) throws courseException {
		// TODO Auto-generated method stub
		if(map!=null && map.size()>0) {
			for(Map.Entry<Integer, student> ma:map.entrySet()) {
				System.out.println(ma.getValue());
			}
		}
		
		else {
			throw new courseException("There is no Student in a list");
		}
	}

	
}