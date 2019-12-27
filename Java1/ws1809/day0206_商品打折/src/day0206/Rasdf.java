package day0206;

import java.util.Scanner;

public class Rasdf {
	public static void main(String[]args){
		System.out.println("请输入价格：");
		double a = new Scanner(System.in).nextDouble();
		double b = 1;
		if(a>5000){
			b=0.7;
		}
		if(a>3000){
			b=0.8;
		}
		else if(a>2000){
			b=0.85;
		}
		b=a*b;
		System.out.println("价格"+b);
		
		
		
		
		
	}
	
	
}
