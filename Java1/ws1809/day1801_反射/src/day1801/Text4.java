package day1801;

import java.lang.reflect.Method;

public class Text4 {
	public static void main(String[] args) throws Exception, Exception {
		// 
		Class<Student> c = Student.class;//创建一个Student类
		   
		   Student s = new Student(5,"zhang三","男",16);
		   //反射类的方法， 获得方法
		   //Method m = c.getDeclaredMethod(方法名,参数类型列表)
		   Method getName = c.getMethod("getName");
		   Method setName = c.getMethod("setName",String.class);
		   
		   
		   Object r = getName.invoke(s);
		   System.out.println(r);
		   setName.invoke(s, "李四");
		   System.out.println(s.getName());
		   
		   
	}
}
