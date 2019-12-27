package day1840_反射;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) throws Exception {
		System.out.println("输入类名");
		String s = new Scanner(System.in).nextLine();
		
		//不知道用哪个类的类名用？号
		Class<?> c = Class.forName(s);
		
		System.out.println(c.getPackage().getName());
		System.out.println(c.getName());//完整类名
		System.out.println(c.getSimpleName());//不含包名
	}
}
