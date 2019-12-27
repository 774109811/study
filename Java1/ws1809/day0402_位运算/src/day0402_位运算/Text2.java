package day0402_位运算;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("请输入整数：");
		int a =new Scanner(System.in).nextInt();
		String r="";
		for(int i=0;i<32;i++){
			int t=1<<i;
			t=t&a;
			if(t==0){
				r=0+r;
				
			}else{
				r=1+r;
			}
		}
	System.out.println(r);
	}
}
