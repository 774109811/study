package day0203;

import java.util.Scanner;

public class Thashd {
	public static void main(String[]args){
		System.out.println("请输入年份：");
		long a = new Scanner(System.in).nextLong();
		String r = "平年";
		if(a%4 == 0 && a%100 !=0 ||a%400 == 0 ){
			r ="闰年";
		}
		System.out.println("是"+r);
	}
}
