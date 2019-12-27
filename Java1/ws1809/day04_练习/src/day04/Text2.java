package day04;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("二进制数字符：");
		String a=new Scanner(System.in).nextLine();
		int s =Integer.parseInt(a,2);
		System.out.println(s);
	}
}
