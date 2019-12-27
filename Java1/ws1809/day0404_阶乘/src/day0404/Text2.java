package day0404;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("ÊäÈëÕûÊı£º");
		int a=new Scanner(System.in).nextInt();
		int r=a;
		for(int i=1;i<=a-1;i++){
			r=r*i;
			System.out.println(r);
		}
		System.out.println(r);
	}
}
