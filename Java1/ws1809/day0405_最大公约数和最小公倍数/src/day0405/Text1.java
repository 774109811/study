package day0405;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("请输入a：");
		int a =new Scanner(System.in).nextInt();
		System.out.println("请输入b：");
		int b =new Scanner(System.in).nextInt();
//		a和b的值，传递到f1（）方法
//		在得到方法
		int zdgys=f1(a,b);
		long zxgbs=f2(a,b);
		System.out.println("最大公约数："+zdgys);
		System.out.println("最小公倍数"+zxgbs);
	}
	static int f1(int a,int b){
		int min=a<b?a:b;
		for(int i=min;i>=1;i--){
			if(a%i==0&&b%i==0){
				return i;
			}
		}
		return 1;
	}
	
	static long f2(int a,int b){
		int max=a>b?a:b;
		for(int i=max;;i=i+max){
			if(i%a==0&&i%b==0){
				return i;
			}
		}
	}
}
