package day0203;

import java.util.Scanner;

public class Rguo1 {
	public static void main(String[] args) {
		System.out.print("请输入年份：");
		int y = new Scanner (System.in).nextInt();
		
		String r = "平年";
		
		if( y%4 == 0 ){
			if(y%100 != 0)
				r = "闰年";
		}
		if( y%400 == 0 ){
			
				r = "闰年";
				
				
	}  
		System.out.println(y+"年是"+r);
	}
		
		}

