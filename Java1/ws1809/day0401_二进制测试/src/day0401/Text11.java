     package day0401;

import java.util.Scanner;

public class Text11 {
	public static void main(String[] args) {
		System.out.print("���������֣�");
		int a = new Scanner(System.in).nextInt();
//		��int����ת��2�����ַ���
		String s=Integer.toBinaryString(a);
		
		System.out.println(s);
		System.out.println("����������ַ���");
		String b =new Scanner(System.in).nextLine();
		int c =Integer.parseInt(b,16);
		System.out.println(c);
	}
	
}
