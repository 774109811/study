package day0404;

import java.util.Scanner;

public class Text3 {
	public static void main(String[] args) {
		System.out.println("ÊäÈëÕûÊı£º");
		int a=new Scanner(System.in).nextInt();
		long r=f(a);
		System.out.println(r);
	}
	static long f(int a){
		long r=a;
		for(int i=1;i<=a-1;i++){
			r=r*i;
		}
		return r;
	}
}
