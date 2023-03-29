package utility;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entity.*;


public class FileExists {

	public static Map<Integer,course> course(){
		File d= new File("course.ser");
		Map<Integer,course> map= null;
		try {
			boolean flag = false;
			if(!d.exists()) {
				d.createNewFile();
				flag = true;
			}
			if(flag) {
				map = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(d));
				oos.writeObject(map);
				return map;
			}
			else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(d));
				map = (Map<Integer, entity.course>) ois.readObject();
				return map;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	
	
	public static Map<Integer,batch> batch() throws IOException, ClassNotFoundException{
		
		File d = new File("batch.ser");
		Map<Integer,batch> map = null;
		boolean flag = false;
		try {
		if(!d.exists()) {
			d.createNewFile();
			flag = true;
		}
		if(flag) {
			map = new LinkedHashMap<>();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(d));
			oos.writeObject(map);
			return map;
		}
		else {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(d));
			map = (Map<Integer, entity.batch>) ois.readObject();
			return map;
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
		
	}
	
	public static Map<Integer,entity.student> student(){
		
		boolean flag = false;
		File f = new File("student.ser");
		Map<Integer,entity.student>map = new LinkedHashMap<>();
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag = false;
			}
			if(flag) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(map);
				return map;
			}
			else {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				map = (Map<Integer,entity.student>) ois.readObject();
				return map;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return map;
		
	}

	
}
