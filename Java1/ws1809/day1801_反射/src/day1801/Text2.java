package day1801;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) throws Exception {
		System.out.println("��������");
		String s = new Scanner(System.in).nextLine();
		//�����������
		Class<?> c = Class.forName(s);
		//�вκ��޲ι��촴������
		
		System.out.println("\n\n----�޲ι��졪����������");
		f1(c);
		System.out.println("\n\n----�вι��졪��int������������");
		f2(c);
		
	}

	private static void f1(Class<?> c) {
		try {
			//ִ���޲ι��죬���û���޲ι�������쳣
			//�����½��޲ι��췽��
			Object obj = c.newInstance();
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println("�޷�ִ���޲ι��췽��");
		}
		
	}

	private static void f2(Class<?> c) {
	try {
		//��ý���int�����Ĺ��췽������������ڳ��� �쳣
		//�Ȼ�ȡ���췽��
		Constructor<?> t = c.getConstructor(int.class);
		//�ù��췽���½�ʵ��
		Object obj = t.newInstance(100);
		System.out.println(obj);
	} catch (Exception e) {
		System.out.println("�޷�ִ��int���췽��");
	}
	//	java.lang.Integer
	//	java.util.Date
	//	java.util.ArrayList
	//	day1801.Student
	}
}
