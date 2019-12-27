package day02;

import java.util.Scanner;

public class Quyu {
	public static void main(String[]args){
		System.out.println("ÇëÊäÈëÊý×Ö£º");
		double a = new Scanner(System.in).nextDouble();
		double b = a*1000;
		long c = (long)b;
		long d =c%10;
		if(d>=5){
			c = c+10-d;
		}
		else{
			c = c-d;
		}
		double e = c/1000d;
		System.out.println(e);
		boolean k = 3>4;
		System.out.println(k);
	}
}
