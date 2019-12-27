package day15_作业转换编码;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("输入原文件（GBK）：");
		String s1= new Scanner(System.in).nextLine();
		 File from = new File(s1);
		if(!from.isFile()){
			System.out.println("请输入文件");
			return;
		}
		System.out.println("输入转码目标文件（UTF-8）");
		String s2= new Scanner(System.in).nextLine();
		File to = new File(s2);
		if(to.isDirectory()){
			System.out.println("请输入文件：");
			return;
		}
		try {
			zhuanma(from,to);
			System.out.println("成功");
		} catch (Exception e) {
			System.out.println("失败");
			e.printStackTrace();
		}
		
	}

	private static void zhuanma(File from, File to) throws Exception {
		InputStreamReader in = new InputStreamReader(new FileInputStream(from),"GBK");

		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(to),"UTF-8");
		int n;
		while((n=in.read())!=-1){
			out.write(n);
		}
		in.close();
		out.close();
	}

}
