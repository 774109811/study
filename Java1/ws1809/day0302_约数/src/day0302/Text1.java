package day0302;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("ÇëÊäÈëÕûÊı×Ö£º");
		int n = new Scanner(System.in).nextInt();
		f(n);
		
	}
	static void f(int x){
		for(int i=1;i<= x ; i++){
			if( x % i == 0 ){
			System.out.println(i);
				
		}
		
	}
	
}
}
