package day0301;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("������һ��������");
		int n = new Scanner(System.in).nextInt();
		f(n);
		
	}
	static void f(int n){
		if(n==2){
			System.out.println("������");
			return;
		}
		if(n<2){
			System.out.println("��������");
			return;
		}
		double max =Math.sqrt(n)+1;
		
		boolean flag =true;
		for(int i=2;i<max;i++){
			if(n%i==0){
				System.out.println("��������");
//				return;
				flag =false;
				break;
			}
			
		}
		if(flag){
			System.out.println("������");
		}
		
	}

}
