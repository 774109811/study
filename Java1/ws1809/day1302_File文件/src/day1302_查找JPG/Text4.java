package day1302_����JPG;

import java.io.File;
import java.util.Scanner;

public class Text4 {
	public static void main(String[] args) {
		System.out.println("�������ļ���");
		String s= new Scanner(System.in).nextLine();
	
		File dir = new File(s);
		if(!dir.isDirectory()){
			 System.out.println("����Ĳ����ļ���");
			 return;
		 }
	
		 File []files = dir.listFiles();//System.out.println(files);
		 for(File f:files){
			 if(f.isFile()){
				 String b=f.getName();
				 b=b.toLowerCase();
//				 System.out.println(b);
				 if(b.endsWith("jpg")||b.endsWith("png")||b.endsWith("gif")){
					 System.out.println(b);
				 }
			 }
		 }
	}
}
