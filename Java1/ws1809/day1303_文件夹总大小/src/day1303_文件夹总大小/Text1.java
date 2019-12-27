package day1303_文件夹总大小;

import java.io.File;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("文件夹");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);//输入文件夹名字是s字符
		if(!dir.isDirectory()){//如果文件夹不存在
			System.out.println("输入的不是文件夹");
			return;
		}
		long size = dirlength(dir);//文件的字节长度
		System.out.println(size);
		
		
	}

	private static long dirlength(File dir) {
		 File[] files = dir.listFiles();//调用文件夹和文件保存到数组里
		 if(files==null){//如果这个文件和文件夹是空值则返回0
			 return 0;
		 }
		 long sum=0;//定义一个文件容量变量
		 for(File f : files){//遍历这个字符
			 if(f.isFile()){//如果是文件
				 sum+=f.length();//文件的字节+变量sum保存到sum
			 }else{//否则是文件夹
				 sum+=dirlength(f);
			 }
		 }
		 return sum;
	}
}
