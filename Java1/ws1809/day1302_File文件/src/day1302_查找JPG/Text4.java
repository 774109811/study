package day1302_查找JPG;

import java.io.File;
import java.util.Scanner;

public class Text4 {
	public static void main(String[] args) {
		System.out.println("请输入文件：");
		String s= new Scanner(System.in).nextLine();
	
		File dir = new File(s);
		if(!dir.isDirectory()){
			 System.out.println("输入的不是文件夹");
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
