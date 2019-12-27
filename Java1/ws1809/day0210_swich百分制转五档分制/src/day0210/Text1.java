package day0210;

import java.util.Scanner;

public class Text1 {
	static void f(int a){
		if(a<0 || a>100){
			System.out.println("百分之分数有误");
			return;

		}
		char r = 0;

		switch(a/10){
		case 10:	
		case 9:
			r = 'A';
			break;
		case 8:
		case 7:
			r = 'B';
			break;
		case 6:
			r = 'C';
			break;
		case 5:
		case 4:
		case 3:
		case 2:
			r = 'D';
			break;
		case 1:
		case 0:	
			r = 'E';
			break;
		}
		System.out.println("五档分制："+r);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("输入百分制分数：");
		int s = new Scanner (System.in).nextInt();
		f(s);
		f(s);
	}
	

}
