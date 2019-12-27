package day12_学生分数;

import java.util.HashMap;

public class Text1 {
	public static void main(String[] args) {
	Student s1 = new Student(01,11,"二狗","男");
	Student s2 = new Student(01,11,"二狗","男");
	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());
	System.out.println(s1.equals(s2));
	
	 HashMap<Student, String> map = new HashMap<>();
	 map.put(s1, "50");
	 map.put(s2, "40");
	 System.out.println(map);
	}
}
