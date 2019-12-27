                                                                                                                                                                                                                                                                                                                           package day0401;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("输入整数：");
		int a=new Scanner(System.in).nextInt();
//	   Integer.toBinaryString(int)
//		把int整数，转成二进制数字字符串
//	    String s= 定义一个字符串
		String s =Integer.toBinaryString(a);
		System.out.println("二进制："+s);
		s=Integer.toHexString(a);
		System.out.println("十六进制："+s);
		s=Integer.toOctalString(a);
		System.out.println(s);
	}
}
