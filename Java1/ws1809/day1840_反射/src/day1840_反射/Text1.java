package day1840_����;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) throws Exception {
		System.out.println("��������");
		String s = new Scanner(System.in).nextLine();
		
		//��֪�����ĸ���������ã���
		Class<?> c = Class.forName(s);
		
		System.out.println(c.getPackage().getName());
		System.out.println(c.getName());//��������
		System.out.println(c.getSimpleName());//��������
	}
}
