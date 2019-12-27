package day1801;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) throws Exception {
		System.out.println("��������");
		String s = new Scanner(System.in).nextLine();
		
		//�������󣬱��浽c
		//��֪�����ĸ���������ã���    �����Ķ���
		/*
	       * "java.lang.String"
	       * "java.util.ArrayList"
	       * "java.io.File"
	       * "day1801.Student"
	       */
		Class<?> c = Class.forName(s);
		
		System.out.println(c.getPackage().getName());//����
		System.out.println(c.getName());//��������
		System.out.println(c.getSimpleName());//�����������
		
		System.out.println("\n\n----��Ա����-----------");
		f1(c);
		System.out.println("\n\n----���췽��----------");
		f2(c);
		System.out.println("\n\n----����-----------");
		f3(c);
	}

	private static void f1(Class<?> c) {
		//field��װһ����Ա�����Ķ�����Ϣ
		//��װ��Field���η� private static final double f;
		//��ñ����ж�������б���������˽�У��������̳е�
		Field[] a = c.getDeclaredFields();
		//������˵Ӵ�еı���
		for(Field f:a) {
			Class<?> type = f.getType();//��ó�Ա����������  
			String name = f.getName();//��ó�Ա����������
			System.out.println(type.getSimpleName()+" "+name);
		}
	}

	private static void f2(Class<?> c) {
		//��װ���췽���Ķ�����Ϣ
		//public A(int,String) throws X,Y,Z
		Constructor<?>[] a = c.getDeclaredConstructors();//������еĹ��췽������˽��
		for(Constructor<?> t: a) {
			String name = c.getSimpleName();
			Parameter[] p = t.getParameters();
			System.out.println(name+"("+Arrays.toString(p)+")");
		}
		
	}

	private static void f3(Class<?> c) {
		
		//��װһ�������Ķ�����Ϣ
		Method[] a = c.getDeclaredMethods();
		for(Method m :a) {
			String r = m.getReturnType().getSimpleName();
			String n = m.getName();
			Class<?>[] p = m.getParameterTypes();
			System.out.println(r+" "+n+"("+Arrays.toString(p)+")");
		}
		
	}
}
