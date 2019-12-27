package day0703;

public class Text1 {
	public static void main(String[] args) {
		


	  Point p1 =new Point(3,4);
	  Point3D p2=new Point3D (3,4,5);
	  System.out.println(p1.toString());
	  System.out.println(p1.distance());
	  System.out.println("-----------");
	  System.out.println(p2.toString());
	  System.out.println(p2.distance());
	  
	  f(p1);
	  f(p2);
//	  转型成父类型
}
	static void f(Point p){
		System.out.println("--当作父类型----");
		System.out.println(p.toString());
		System.out.println(p.distance());
	}
}