package day0404;

import java.util.Scanner;

public class Text1 {

	public static void main(String[] args) {
		System.out.println("������������׳ˣ�");
		int n=new Scanner(System.in).nextInt();
//		
//		��N��ֵ�����ݵ�F����������������
//		�ڵõ������ķ���ֵ
//		���浽����r
		long r=f(n);
		System.out.println(r);		
	}
	static long f(int n){
//		
//		
//	
		long r=n;
		for(int i=1;i<=n-1;i++){
			r=r*i;
			
		}
		return r;
	}

}
