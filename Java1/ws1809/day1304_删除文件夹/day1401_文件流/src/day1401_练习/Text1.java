package day1401_Á·Ï°;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Text1 {
	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("d:/abc/f2");
		out.write(1);
		out.write(2);
		out.write(97);
		byte[]a={101,102,103,104,105,};
		out.write(a);
		out.write(a, 0, 3);
		out.close();
		FileInputStream in = new FileInputStream("d:/abc/f2");
		in.read();
		in.read();
		int b;
		while((b=in.read())!=-1){
			System.out.println(b);
		}
		System.out.println("\n-----------");
		FileInputStream i = new FileInputStream("d:/abc/f2");
		byte[] c =new byte[3];
		int n;
		while((n=i.read(c))!=-1){
			System.out.println(n+"-"+Arrays.toString(c));
		}
			in.close();
	}
}
