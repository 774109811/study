                                                                                                                                                                                                                                                                                                                           package day0401;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("����������");
		int a=new Scanner(System.in).nextInt();
//	   Integer.toBinaryString(int)
//		��int������ת�ɶ����������ַ���
//	    String s= ����һ���ַ���
		String s =Integer.toBinaryString(a);
		System.out.println("�����ƣ�"+s);
		s=Integer.toHexString(a);
		System.out.println("ʮ�����ƣ�"+s);
		s=Integer.toOctalString(a);
		System.out.println(s);
	}
}
