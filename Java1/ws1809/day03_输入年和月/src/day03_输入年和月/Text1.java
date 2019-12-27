package day03_输入年和月;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.print("请输入年：");
		int a=new Scanner(System.in).nextInt();
		System.out.print("请输入月：");
		int b=new Scanner(System.in).nextInt();
		int t=b;
		switch(t){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			t=31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			t=30;
			break;
		case 2:
			if((a%4==0&&a%100!=0)||a%400==0){
				t=28;
				break;
			}else{
				t=29;
				break;
			}
		
		
		}
		System.out.println(t+"天");
	}
}
