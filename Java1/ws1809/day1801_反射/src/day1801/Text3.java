package day1801;

import java.lang.reflect.Field;

public class Text3 {
	public static void main(String[] args) throws Exception {
	   Class<Student> c = Student.class;//创建一个类对象
	   
	   Student s = new Student(5,"zhang三","男",16);
	   //访问反射变量
	   Field id = c.getDeclaredField("id");//获取成员变量id
	   id.setAccessible(true);//这个方法可以访问私有变量
	   Object v  =id.get(s);//反射访问变量的值
	   System.out.println(v);
	   id.set(s, 999);//反射位变量复制
	   System.out.println(s.getId());
	   
}
}