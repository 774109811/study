package day2000_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) throws Exception {
		System.out.println("输入类名：");
		String s= new Scanner(System.in).nextLine();
		
		
		Class<?> c = Class.forName(s);
		System.out.println(c.getPackage().getName());//获取它的包名
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		
		System.out.println("\n\n----获取成员变量---------");
		f1(c);
		System.out.println("\n\n-------获取构造方法-----");
		f2(c);
	}

	private static void f2(Class<?> c) {
	    Constructor<?>[] a = c.getDeclaredConstructors();
	    for(Constructor <?>f:a) {
	    	String name = c.getSimpleName();
	    }
		
	}

	private static void f1(Class<?> c) {
	  Field[] a = c.getDeclaredFields();//获取Student的所以成员变量
	  for(Field f:a) {//变量成员变量
		  Class<?> type = f.getType();
		  String name = f.getName();
		  System.out.println(type.getSimpleName()+" "+f.getName());
		       
		  
	  }
		
	}
}
