package day0301;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("请输入一个质数：");
		int n = new Scanner(System.in).nextInt();
		f(n);
		
	}
	static void f(int n){
		if(n==2){
			System.out.println("是质数");
			return;
		}
		if(n<2){
			System.out.println("不是质数");
			return;
		}
		double max =Math.sqrt(n)+1;
		
		boolean flag =true;
		for(int i=2;i<max;i++){
			if(n%i==0){
				System.out.println("不是质数");
//				return;
				flag =false;
				break;
			}
			
		}
		if(flag){
			System.out.println("是质数");
		}
		
	}

}
