package day2000_øº ‘;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class Text2 {
	public static void main(String[] args) throws Exception {
		File file = new File("d:/Io/a.txt");
		
		  BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))  ;
		  
		 String line;
		
		 while((line=in.readLine())!=null) {
			System.out.println(line);
		 }
		 in.close();
	}
}
