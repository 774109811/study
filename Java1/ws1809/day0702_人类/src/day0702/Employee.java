package day0702;

public class Employee extends Person {
	double salary;
	
//	��дtoString()����
//	�Լ̳еķ��������и�д
	public String toString() {
		String s=super.toString();
		  return s+","+salary;
		
	}
}
