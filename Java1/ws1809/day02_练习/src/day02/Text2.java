package day02;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("ÇëÊäÈë¸¡µãÊý£º");
		double a=new Scanner(System.in).nextDouble();
		a=a*1000;
		long b=(long)a;
		long c=b%10;
		if(c>=5){
			b=b-c+10;
		}else{
			b=b-c;
		}
		double d=b/1000d;
		System.out.println(d);
	}
	
}
