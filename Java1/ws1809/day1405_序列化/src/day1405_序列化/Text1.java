package day1405_序列化;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Text1 {
	public static void main(String[] args) throws Exception {
		Student s = new Student(9527,"唐伯虎","男",19);
		//OOS--FOS--f3
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:/abc/f3"));
		//序列化输出S
		out.writeObject(s);
		out.close();
		
		
	}


}
