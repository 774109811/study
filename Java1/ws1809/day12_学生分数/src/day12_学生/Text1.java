package day12_学生;

import java.util.HashMap;

public class Text1 {
	public static void main(String[] args) {
		  Student s1 = new Student(1,2,"阿斯顿","马丁");
		  Student s2 = new Student(1,2,"阿斯顿","马丁");
		  
		  System.out.println(s1.hashCode());
		  System.out.println(s2.hashCode());
		  System.out.println(s1.equals(s2));
		  HashMap<Student, String> map = new HashMap<>();
		  map.put(s1, "18");
		  map.put(s2, "30 ");
		  System.out.println(map);
	}
}
