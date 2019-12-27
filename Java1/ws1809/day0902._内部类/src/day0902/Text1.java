package day0902;

import day0902.A.Inner1;
import day0902.A.Inner2;
import day0902.A.Inner3;

public class Text1 extends A {
	public static void main(String[] args) {
		Inner1 i1=new Inner1();
	
		System.out.println(i1);
		System.out.println("\n----------");
		A a = new A();
		Inner2 i2= a.new Inner2();
		System.out.println(i2);
		Inner3 i3= a.new Inner3();
		System.out.println(i3);
	}
}
class A{
	static class Inner1{

	}
	class Inner2{
		
	}
	class Inner3{
		
	}
}