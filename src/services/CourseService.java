package services;
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
	
}
