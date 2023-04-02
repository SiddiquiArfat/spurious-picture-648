package services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import entity.batch;
import entity.course;
import exceptions.BatchException;
import exceptions.courseException;
import utility.FileExists;

public interface BatchService {
	public static String addbatch(int id, batch cd, Map<Integer, batch> map2) throws courseException, BatchException{
		Map<Integer,course> map = FileExists.course();
		
		boolean flag = false;
		for(Entry<Integer, course> ma:map.entrySet()) {
			if(ma.getValue().getName().equals(cd.getCourse())) {
				map2.put(id, cd);
				ma.getValue().getLi().add(map2);
				flag = true;
				break;
			}
		}
		if(!flag) {
			throw new BatchException("No Course Found With This Name! ");
		}
		
	return "Batch Added Successfullfy";
	}



	public static Map<Integer, batch> searchbyname(String name, Map<Integer, batch> c) throws BatchException {
		// TODO Auto-generated method stub
		
		Map<Integer,batch> map2 = new LinkedHashMap<>();
		for(Map.Entry<Integer,batch> m :c.entrySet()) {
			if(m.getValue().getBatchname().equals(name)) {
				map2.put(m.getKey(), m.getValue());
			}
		}
		if(map2.size() == 0) {
			throw new BatchException("No batch found with this name ");
		}
		return map2;
	}



	public static Map<Integer, batch> searchbycourse(String name, Map<Integer, batch> c) throws BatchException {
		// TODO Auto-generated method stub
		Map<Integer,batch> map2 = new LinkedHashMap<>();
		for(Map.Entry<Integer,batch> m :c.entrySet()) {
			if(m.getValue().getCourse().equals(name)) {
				map2.put(m.getKey(), m.getValue());
			}
		}
		if(map2.size() == 0) {
			throw new BatchException("No batch found with this name ");
		}
		return map2;
	}



	public static void viewAll(Map<Integer, batch> map) throws BatchException {
		
			
			if(map!=null && map.size()>0) {
				for(Map.Entry<Integer, batch> ma:map.entrySet()) {
					System.out.println(ma.getValue());
				}
			}
			
			else {
				throw new BatchException("There is no Batch");
			}
		
		
	}



	public static String update(int id, Map<Integer, batch> b, batch cd) {
		// TODO Auto-generated method stub
		b.put(id, cd);
		return "Course Updated Successfull";
	}
}
