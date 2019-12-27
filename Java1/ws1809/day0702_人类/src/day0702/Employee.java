package day0702;

public class Employee extends Person {
	double salary;
	
//	重写toString()方法
//	对继承的方法，进行改写
	public String toString() {
		String s=super.toString();
		  return s+","+salary;
		
	}
}
