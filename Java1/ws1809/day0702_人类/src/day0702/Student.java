package day0702;

public class Student extends Person {
	String school;

//	重写toString()方法
//	对继承的方法，进行改写
  public String toString() {
//	调用父类成员
//	  一般在方法重写时，调用父类同一个方法
	
	  return super.toString()+","+school;
}
	
}
