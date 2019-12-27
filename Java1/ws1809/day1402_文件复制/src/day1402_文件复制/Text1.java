package day1402_文件复制;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.imageio.stream.FileImageOutputStream;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("原文件");
		String s1= new Scanner(System.in).nextLine();
		File from =new File(s1);//
		if(!from.isFile()){//不是文件
			System.out.println("输入的不是文件");
			return;
		}
		System.out.println("目标文件");
		String s2= new Scanner(System.in).nextLine();
		File to =new File(s2);
		if(to.isDirectory()){//是不是一个文件夹
			System.out.println("不能输入文件夹，请输入文件");
			return;
		}
		try {
			copy(from,to);
			System.out.println("完成");
		} catch (Exception e) {
			System.out.println("失败");
			e.printStackTrace();
		}
	}

	private static void copy(File from, File to) throws Exception {
		FileInputStream in = new FileInputStream(from);
		FileOutputStream out = new FileOutputStream(to);
//		int b;
//		while((b=in.read())!=-1){
//			out.write(b);
//		}
		byte[] buff = new byte[8192];
		int n;
		while((n=in.read(buff))!=-1){
			out.write(buff, 0, n);
		}
		
		in.close();
		out.close();
		
	}

}
