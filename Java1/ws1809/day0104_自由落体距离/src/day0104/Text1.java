package day0104;

import java.util.Scanner;

public class Text1 {
	public static void main(String[]args){
		System.out.print("���뽵��ʱ�䣨�룩��"  );
//		�Ȼ�������ֵ�ڴ浽����t
		double t = new Scanner(System.in).nextDouble(); 
//		�׹�ʽ������룬�ٰѼ��������浽����d
		double d = 0.5*9.8*t*t;
//	          ��ӡ���
		System.out.println(t+"�뽵����"+d+"��");
	}

}
