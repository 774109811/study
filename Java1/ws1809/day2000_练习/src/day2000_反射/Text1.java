package day2000_����;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) throws Exception {
		System.out.println("����������");
		String s= new Scanner(System.in).nextLine();
		
		
		Class<?> c = Class.forName(s);
		System.out.println(c.getPackage().getName());//��ȡ���İ���
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		
		System.out.println("\n\n----��ȡ��Ա����---------");
		f1(c);
		System.out.println("\n\n-------��ȡ���췽��-----");
		f2(c);
	}

	private static void f2(Class<?> c) {
	    Constructor<?>[] a = c.getDeclaredConstructors();
	    for(Constructor <?>f:a) {
	    	String name = c.getSimpleName();
	    }
		
	}

	private static void f1(Class<?> c) {
	  Field[] a = c.getDeclaredFields();//��ȡStudent�����Գ�Ա����
	  for(Field f:a) {//������Ա����
		  Class<?> type = f.getType();
		  String name = f.getName();
		  System.out.println(type.getSimpleName()+" "+f.getName());
		       
		  
	  }
		
	}
}
