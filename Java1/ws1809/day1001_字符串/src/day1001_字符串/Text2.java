package day1001_�ַ���;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("�����ַ�����");
		String s = new Scanner(System.in).nextLine();
		if(huiwen(s)){
			System.out.println("�ǻ���");
		}else{
			System.out.println("���ǻ���");
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
