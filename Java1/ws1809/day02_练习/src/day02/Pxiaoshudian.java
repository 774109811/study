package day02;

import java.util.Scanner;

public class Pxiaoshudian {
	public static void main(String[] args) {
		System.out.println("请输入浮点数字：");
		double a = new Scanner(System.in).nextDouble();
		double b = a*1000;
		int c =(int)b;
		int d=  c %10 ;
		if(d>=5){
			c = c+10-d;
			
		}
		else{
			c= c- d;
		}
		double e = c/1000d;
		System.out.println("转化"+e);
		
	}
}
