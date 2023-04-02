package services;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

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

	public static String addinbatch(int batchid, int id, Scanner sc, Map<Integer, batch> batch,
			Map<Integer, student> student) throws BatchException {
		// TODO Auto-generated method stub
		if(batch.containsKey(batchid)){
			List<Integer> li = batch.get(batchid).getLi();
			int count = batch.get(batchid).getCount();
			
			if(count>=60) {
				throw new BatchException("Batch is full!");
			}
			
			li.add(id);
			
			count++;
			batch.get(batchid).setCount(count);
			return "Your are Added in a batch "+ batch.get(batchid).getBatchname();
		}
		else {
			throw new BatchException("Batch With that ID is not present!");
		}
	}

	
}