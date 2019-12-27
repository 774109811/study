package day0203;

import java.util.Scanner;

public class Eif {
	public static void main(String[] args) {
		System.out.println("请输入年份：");
		long r = new Scanner (System.in).nextLong();
		String j = "平年";
		if(r%4 == 0  ){
			if(r%100 !=0  )
				j = "闰年";
			
		}
		if(r%400 ==0 ){
			j = "闰年";
		}
		System.out.println(j+"是"+r);
				
	
	}
}
