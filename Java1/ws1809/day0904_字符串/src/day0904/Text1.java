package day0904;

public class Text1 {
	public static void main(String[] args) {
		char[] a  = {'a','b','c',};
		String s1 = new String(a);//�·�����ڴ�
		String s2 = "abc";//�������½�
		String s3 = "abc";//������ͬһ������
	System.out.println(s1 == s2);
	System.out.println(s2 == s3);
	System.out.println(s1.equals(s2));
	System.out.println(s1);
	System.out.println(s2);
	System.out.println(s3);
	String s0 = "abcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();	
     
}
}
