package day0903_Object;

public class Text1 {
	public static void main(String[] args) {
		Point a = new Point(3,4); 
		Point b = new Point(3,4); 
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		
		System.out.println(a);
		//
		System.out.println(a == b);
		
		
		System.out.println(a.equals(b));
	}
}
