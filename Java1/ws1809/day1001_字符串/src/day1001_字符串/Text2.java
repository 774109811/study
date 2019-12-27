package day1001_字符串;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("输入字符串：");
		String s = new Scanner(System.in).nextLine();
		if(huiwen(s)){
			System.out.println("是回文");
		}else{
			System.out.println("不是回文");
		}
	}

	private static boolean huiwen(String s) {
		for(int i= 0,j=s.length()-1;i<j;i++,j--){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
//	
//	private static boolean huiwen(String s) {
//		for(int i=0,j=s.length()-1;i<j;i++,j--){
//			if(s.charAt(i)!=s.charAt(j)){
//				return false;
//			}
//		}
//		return true;
//	}
}
