package services;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entity.*;
import exceptions.*;

public class CourseService {
	public static String addCourse(int id,entity.course obj,Map<Integer,course>map) {
		
		map.put(id, obj);
		
		return "Course Added Successfully";
		
	}
	
	public static void viewAll(Map<Integer,course> map) throws courseException {
		
		if(map!=null && map.size()>0) {
			for(Map.Entry<Integer, course> ma:map.entrySet()) {
				System.out.println(ma.getValue());
			}
		}
		
		else {
			throw new courseException("There is no course");
		}
	}

	public static String update(int id, Map<Integer, course> c, course cd) throws courseException{
		// TODO Auto-generated method stub
		List<Map<Integer,batch>> li = null;
		
			if(c.containsKey(id)) {
				li = c.get(id).getLi();
				
			}
		
		cd.setLi(li);
		c.put(id, cd);
		return "Course Updated Successfull";
	}

	public static Map<Integer, course> searchbyname(String name, Map<Integer, course> c) throws courseException {
		// TODO Auto-generated method stub
		Map<Integer, course> map = new LinkedHashMap<>();
		for(Map.Entry<Integer,course> m :c.entrySet()) {
			if(m.getValue().getName().equals(name)) {
				map.put(m.getKey(), m.getValue());
			}
		}
		
		if(map.size() == 0) {
			throw new courseException("No Result Found");
		}
		return map;
	}

	public static Map<Integer, course> searchbyduration(int min, int max, Map<Integer, course> c) throws courseException {
		// TODO Auto-generated method stub
		Map<Integer, course> map = new LinkedHashMap<>();
		for(Map.Entry<Integer,course> m :c.entrySet()) {
			if(m.getValue().getDurationMonth()>=min && m.getValue().getDurationMonth()<=max) {
				map.put(m.getKey(), m.getValue());
			}
		}
		
		if(map.size() == 0) {
			throw new courseException("No Result Found");
		}
		return map;
	}

	public static Map<Integer, course> searchbyfee(int min, int max, Map<Integer, course> c) throws courseException {
		// TODO Auto-generated method stub
		Map<Integer, course> map = new LinkedHashMap<>();
		for(Map.Entry<Integer,course> m :c.entrySet()) {
			if(m.getValue().getFee()>=min && m.getValue().getFee()<=max) {
				map.put(m.getKey(), m.getValue());
			}
		}
		
		if(map.size() == 0) {
			throw new courseException("No Result Found");
		}
		return map;
	}

	
	
}
