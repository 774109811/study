package day0410_����;

import java.util.Arrays;

public class Text1 {
	public static void main(String[] args) {
		int []a=new int[5];
		a[2]=52;
//		Arrays.toString(a);
//		�������е�ֵ�����ӳ��ַ���
		System.out.println(Arrays.toString(a));
		char[] b={'a','b','c','d'};
		System.out.println(Arrays.toString(b));
		b=new char[]{'x','y','z'};
		System.out.println(Arrays.toString(b));
	}
}
