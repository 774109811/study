package day0405;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println(" ‰»Îa£∫");
		int a=new Scanner(System.in).nextInt();
		System.out.println(" ‰»Îb£∫");
		int b=new Scanner(System.in).nextInt();
		int zdgys=f1(a,b);
		long zxgbs=f2(a,b);
		System.out.println(zdgys);
		System.out.println(zxgbs);
	}
	static int f1(int a,int b ){
		int min=a<b?a:b;
		for(int i=min;i>=1;i--){
			if(a%i==0&&b%i==0){
				return i;
			}
		}
		return 1;
	}
	static long f2(int a,int b ){
		int max= a>b?a:b;
		for(int i=max;;i=i+max){
			if(i%a==0&&i%b==0){
				return i;
			}
		}
	}
}
