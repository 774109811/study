package day1801;

import java.lang.reflect.Method;

public class Text4 {
	public static void main(String[] args) throws Exception, Exception {
		// 
		Class<Student> c = Student.class;//����һ��Student��
		   
		   Student s = new Student(5,"zhang��","��",16);
		   //������ķ����� ��÷���
		   //Method m = c.getDeclaredMethod(������,���������б�)
		   Method getName = c.getMethod("getName");
		   Method setName = c.getMethod("setName",String.class);
		   
		   
		   Object r = getName.invoke(s);
		   System.out.println(r);
		   setName.invoke(s, "����");
		   System.out.println(s.getName());
		   
		   
	}
}
