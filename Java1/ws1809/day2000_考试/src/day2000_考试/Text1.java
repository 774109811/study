package day2000_øº ‘;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Text1 {
	public static void main(String[] args) throws Exception {
		File f = new File("d:/a.txt");
		if(!f.isFile()) {
			 f.createNewFile();
		}
		
		File dir = new File("d:/Io/a.txt");
		
		copy(f,dir);
		File file = new File("d:/Io");
		File[] list = file.listFiles();
		for(File n:list) {
			System.out.println(n.getName());
		}
		
	}

	private static void copy(File f, File dir) throws Exception {
		FileInputStream in = new FileInputStream(f);
		FileOutputStream out = new FileOutputStream(dir);
		 byte[] b = new byte[8192];
		int a;
		while((a=in.read(b))!=-1) {
			out.write(b,0,a);
		}
		in.close();
		out.close();
	}
}
