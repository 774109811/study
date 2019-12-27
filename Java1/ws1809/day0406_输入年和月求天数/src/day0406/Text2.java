package day0406;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("年");
		int y =new Scanner(System.in).nextInt();
		System.out.println("月");
		int m =new Scanner(System.in).nextInt();
		if(m>12||m<1){
			System.out.println("输入错误：");
			return;
		}
		int r=f(y,m);
		System.out.println(y+"年"+m+"月"+r+"天");
	}
	static int f(int y,int m){
		int r=0;
		switch(m){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			r=31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			r=30;
			break;
		case 2:
			if((y%4==0&&y%100!=0)||y%400==0){
				r=29;
			}else{
				r=28;
			}
		}
		return r;
	}
}
