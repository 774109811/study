package day0702;

public class Student extends Person {
	String school;

//	��дtoString()����
//	�Լ̳еķ��������и�д
  public String toString() {
//	���ø����Ա
//	  һ���ڷ�����дʱ�����ø���ͬһ������
	
	  return super.toString()+","+school;
}
	
}
