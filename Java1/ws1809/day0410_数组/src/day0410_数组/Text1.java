package day0410_数组;

import java.util.Arrays;

public class Text1 {
	public static void main(String[] args) {
		int []a=new int[5];
		a[2]=52;
//		Arrays.toString(a);
//		把数组中的值，链接成字符串
		System.out.println(Arrays.toString(a));
		char[] b={'a','b','c','d'};
		System.out.println(Arrays.toString(b));
		b=new char[]{'x','y','z'};
		System.out.println(Arrays.toString(b));
	}
}
