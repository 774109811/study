package day0601;

import java.util.Scanner;

public class Text1 {

	public static void main(String[] args) {
		System.out.print("求第几个斐波那契数");
		int n =new Scanner(System.in).nextInt();
		
		long a=g(n);
		System.out.println(a);
	}

	private static long g(int n) {
		long a=1;
		long b=1;
				
		for (int i = 3; i <=n; i++) {
			b=a+b;
			a=b-a;
		}
		return  b;
	}

//	private static long f(int n) {
//		if(n==1||n==2){
//			return 1;
//		}
//		return f(n-1)+f(n-2);
//	}
	
		
	

}
