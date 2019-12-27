package day0401;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("二进制数字：");
//		line字符串
		String s=new Scanner(System.in).nextLine();
//		Integer.parseInt("10101",2)
//		以二进制，来解析数字字符串
		int a= Integer.parseInt(s,2);
		System.out.println("十进制："+a);
		System.out.println("输入八进制数字：");
		String d=new Scanner(System.in).nextLine();
//		以八进制，来解析数字字符串
		int b= Integer.parseInt(d,8);
		System.out.println(b);
		System.out.println("输入十进制数字：");
		String t =new Scanner(System.in).nextLine();
//		以十进制，来解析数字字符串
		int c= Integer.parseInt(t,10);
		System.out.println(c);
		System.out.println("输入十六进制数字：");
		String y=new Scanner(System.in).nextLine();
//		以十进制，来解析数字字符串
		int f= Integer.parseInt(y,16);
		System.out.println(f);
		String q= new Scanner(System.in).nextLine();
		int e =Integer.parseInt(q);
		System.out.println(e);
		
		
	}
	
		
	
}
