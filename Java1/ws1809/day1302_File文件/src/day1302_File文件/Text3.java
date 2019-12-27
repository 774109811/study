package day1302_File文件;

import java.io.File;
import java.util.Scanner;

public class Text3 {
	public static void main(String[] args) {
		System.out.println("输入文件夹");
		String s= new Scanner(System.in).nextLine();
		File dir = new File(s);//新建文件	
		if(!dir.isDirectory()){//如果不是文件
		System.out.println("输入的不是文件夹");
		return;
		}
		String[] names = dir.list();//得到文件夹名称数组
		File[] files = dir.listFiles();//得到文件夹和文件数组
		if(names == null){
			System.out.println("无法获得列表");
			return;
		}
		for(String n : names){
			System.out.println(n);
		}
	
		System.out.println("\n--------------");
		
		for(File f:files ){
			System.out.println(f.getName()+"-"+f.length()+f);;
		}
	}
}
