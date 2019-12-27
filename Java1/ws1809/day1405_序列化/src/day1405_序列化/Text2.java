package day1405_–Ú¡–ªØ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Text2 {
	public static void main(String[] args) throws Exception {
		//
		 ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:/abc/f3"));
		Student s = (Student) in.readObject();
		System.out.println(s);
		in.close();
		
		
	}


}
