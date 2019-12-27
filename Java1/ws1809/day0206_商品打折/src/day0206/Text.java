package day0206;

import java.util.Scanner;

public class Text {
	public static void main(String[] args) {
		System.out.println("输入商品价格：");
		double p =
		 new Scanner (System.in).nextDouble();
		double r = 1;
		if(p>=5000){
			r = 0.7;
		}else if(p>=2000){
			r = 0.8;
		}else if(p>=1000){
			r = 0.85;
		}else if(p>=500){
			r = 0.9;
		}
		p*=r; 
//		p = p*r;
		System.out.println("实际价格："+p);
	}
}
