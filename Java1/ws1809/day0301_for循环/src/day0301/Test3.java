package day0301;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("����������");
		int n = new Scanner(System.in).nextInt();
		System.out.println("\n\n---������---");
		f1(n);
		System.out.println("\n\n---������---");
		f2(n);
		System.out.println("\n\n---����������---");
		f3(n);
		
	}
	static void f1(int n){
		for( int i =1;i<=n;i++){
			for( int j =1;j<=n;j++){
				System.out.print("*");
			}
		System.out.println();
		}
	}
	static void f2(int n){
		for( int i =1;i<=n;i++){
			for( int j =1;j<=i;j++){
				System.out.print("*");
			}
		System.out.println();
		}
	}
	
	static void f3(int n){
		for( int i =1;i<=n;i++){
			for( int j =1;j<=n-i;j++){
				System.out.print(" ");
			}
			for(int e = 1;e<=2*i-1;e++){
				System.out.print("*");
			}
		System.out.println();
		}
	}

}
