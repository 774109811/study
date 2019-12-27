package day0409;

import java.util.Random;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		int a=1+new Random().nextInt(1000);
		System.out.println(a);
		
		System.out.println("已经产生了一个[1，1001）范围的随机整数");
		System.out.println("猜猜这个数是几");
		
		while(true ){
			System.out.println("猜数：");
			int b=new Scanner(System.in).nextInt();
			if(b>a){
				System.out.println("大了");
			}else if(b<a){
				System.out.println("小了");
			}else{
				System.out.println("猜对");
				return;
			}
		}
	}
}
