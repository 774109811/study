package day0409;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
//		int a= new Random().nextInt();
//		System.out.println(a);
		int r=1+new Random().nextInt(1000);
		System.out.println(r);
		System.out.println("已经产生了一个[1，1001）范围的随机整数");
		System.out.println("猜猜这个数是几");
		
		while(true){
			
			System.out.println("猜");
			try {
				int c= new Scanner(System.in).nextInt();
				if(c>r ){
					System.out.println("大");
				}else if(c<r){
					System.out.println("小");
				}else{
					System.out.println("猜对");
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("格式错误");
			}
		}
	}
}
