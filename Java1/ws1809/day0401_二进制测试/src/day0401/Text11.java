     package day0401;

import java.util.Scanner;

public class Text11 {
	public static void main(String[] args) {
		System.out.print("请输入数字：");
		int a = new Scanner(System.in).nextInt();
//		把int类型转成2进制字符串
		String s=Integer.toBinaryString(a);
		
		System.out.println(s);
		System.out.println("输入二进制字符：");
		String b =new Scanner(System.in).nextLine();
		int c =Integer.parseInt(b,16);
		System.out.println(c);
	}
	
}
