package day0404;

import java.util.Scanner;

public class Text1 {

	public static void main(String[] args) {
		System.out.println("输入整数，求阶乘：");
		int n=new Scanner(System.in).nextInt();
//		
//		把N的值，传递到F（）方法进行运算
//		在得到方法的返回值
//		保存到变量r
		long r=f(n);
		System.out.println(r);		
	}
	static long f(int n){
//		
//		
//	
		long r=n;
		for(int i=1;i<=n-1;i++){
			r=r*i;
			
		}
		return r;
	}

}
