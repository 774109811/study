package day0401;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("���������֣�");
//		line�ַ���
		String s=new Scanner(System.in).nextLine();
//		Integer.parseInt("10101",2)
//		�Զ����ƣ������������ַ���
		int a= Integer.parseInt(s,2);
		System.out.println("ʮ���ƣ�"+a);
		System.out.println("����˽������֣�");
		String d=new Scanner(System.in).nextLine();
//		�԰˽��ƣ������������ַ���
		int b= Integer.parseInt(d,8);
		System.out.println(b);
		System.out.println("����ʮ�������֣�");
		String t =new Scanner(System.in).nextLine();
//		��ʮ���ƣ������������ַ���
		int c= Integer.parseInt(t,10);
		System.out.println(c);
		System.out.println("����ʮ���������֣�");
		String y=new Scanner(System.in).nextLine();
//		��ʮ���ƣ������������ַ���
		int f= Integer.parseInt(y,16);
		System.out.println(f);
		String q= new Scanner(System.in).nextLine();
		int e =Integer.parseInt(q);
		System.out.println(e);
		
		
	}
	
		
	
}
