package day1203;

import java.util.HashMap;

public class Text3 {
	public static void main(String[] args) {
		Point a = new Point(1,3.2);
		Point b = new Point(1,3.2);
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.equals(b));
//		System.out.println(a.toString());
		
		HashMap<Point, String> map = new HashMap<>();
		map.put(a, "3.25вк");
		map.put(b, "3.25вк");
		System.out.println(map);
		
	}
}
