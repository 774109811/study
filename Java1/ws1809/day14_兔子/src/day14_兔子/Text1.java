package day14_����;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("�����������������ӵ���������");
		int n =new Scanner(System.in).nextInt();
		long i=f(n);
		System.out.println(i);
	}

	private static int f(int y) {
		
		if(y==0)return 0;	
		if(y==1||y==2||y==3){
			return 1;
		}else if(y==4||y==5||y==6){
			return 2;}
		
	return f(y++);
		
	}
}
