package day0207;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.print("请输入工资：");
		double s = new Scanner (System.in).nextDouble();


		if(s<=3500){
			System.out.println("不用交税");
			return;
		}
		s -= 3500;
		double r = 0;
		int k = 0;
		if(s<=1500){
			r=0.03;
			k=0;
		}else if(s<=4500 && s>1500 ){
			r=0.1;
			k=105;
		}else if(s<=9000 && s>4500){
			r=0.2;
			k=555;
		}else if(s<=35000 && s>9000){
			r=0.25;
			k=1005;
		}else if(s<=55000 && s>35000){
			r=0.3;
			k=2755;
		}else if(s<=80000 && s>55000){
			r=0.45;
			k=13505;
		}else
		{			r=0.03;
		k=0;

		}
		double tax = s*r -k;
		double n = s - tax ; 
		System.out.println("个人所得税："+n);
	}
}
