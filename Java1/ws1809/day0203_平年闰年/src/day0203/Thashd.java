package day0203;

import java.util.Scanner;

public class Thashd {
	public static void main(String[]args){
		System.out.println("��������ݣ�");
		long a = new Scanner(System.in).nextLong();
		String r = "ƽ��";
		if(a%4 == 0 && a%100 !=0 ||a%400 == 0 ){
			r ="����";
		}
		System.out.println("��"+r);
	}
}
