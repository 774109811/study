package day0301;

import java.util.Scanner;

public class Tdayin {
	public static void main(String[] args) {
		for(int e=1;e<11 ;e*=2){
			System.out.println(e);
		}
		System.out.println("请输入正方形的行：");
		int a = new Scanner(System.in).nextInt();
		
		f(a);
	}
	   static void f(int n){
		   for(int b=1;b<=n;b++){
			   for( int c=1;c<=n ;c++ ){
				   System.out.print("#");
				   
			   }
			   System.out.println();
			   
		   }
		   
	   }
	   
}
