package day1801;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) throws Exception {
		System.out.println("输入类名");
		String s = new Scanner(System.in).nextLine();
		
		//获得类对象，保存到c
		//不知道用哪个类的类名用？号    获得类的对象
		/*
	       * "java.lang.String"
	       * "java.util.ArrayList"
	       * "java.io.File"
	       * "day1801.Student"
	       */
		Class<?> c = Class.forName(s);
		
		System.out.println(c.getPackage().getName());//包名
		System.out.println(c.getName());//完整类名
		System.out.println(c.getSimpleName());//获得它的类名
		
		System.out.println("\n\n----成员变量-----------");
		f1(c);
		System.out.println("\n\n----构造方法----------");
		f2(c);
		System.out.println("\n\n----方法-----------");
		f3(c);
	}

	private static void f1(Class<?> c) {
		//field封装一个成员变量的定义信息
		//封装在Field修饰符 private static final double f;
		//获得本类中定义的所有变量，包括私有，不包含继承的
		Field[] a = c.getDeclaredFields();
		//遍历它说哟有的变量
		for(Field f:a) {
			Class<?> type = f.getType();//获得成员变量的类型  
			String name = f.getName();//获得成员变量的名字
			System.out.println(type.getSimpleName()+" "+name);
		}
	}

	private static void f2(Class<?> c) {
		//封装构造方法的定义信息
		//public A(int,String) throws X,Y,Z
		Constructor<?>[] a = c.getDeclaredConstructors();//获得所有的构造方法包括私有
		for(Constructor<?> t: a) {
			String name = c.getSimpleName();
			Parameter[] p = t.getParameters();
			System.out.println(name+"("+Arrays.toString(p)+")");
		}
		
	}

	private static void f3(Class<?> c) {
		
		//封装一个方法的定义信息
		Method[] a = c.getDeclaredMethods();
		for(Method m :a) {
			String r = m.getReturnType().getSimpleName();
			String n = m.getName();
			Class<?>[] p = m.getParameterTypes();
			System.out.println(r+" "+n+"("+Arrays.toString(p)+")");
		}
		
	}
}
