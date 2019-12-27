package day0203;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.print("输入年号：");
		int y = new Scanner (System.in).nextInt();
		String r = "平年";
//		如果可以被4整除
//		if(y%4 == 0){
////			并且不可以被100整除
//			if(y%100  !=0){
//				r="闰年";
//			}
//		if(y%400 == 0){
//			r = "闰年";
//		}
//		}
	    if( (y%4==0&& y%100!=0)||y%400 == 0   ){
	    	r = "闰年";
	    }
		System.out.println(y+"年是"+r);		
		
	}

}
