package day0203;

import java.util.Scanner;

public class Eif {
	public static void main(String[] args) {
		System.out.println("��������ݣ�");
		long r = new Scanner (System.in).nextLong();
		String j = "ƽ��";
		if(r%4 == 0  ){
			if(r%100 !=0  )
				j = "����";
			
		}
		if(r%400 ==0 ){
			j = "����";
		}
		System.out.println(j+"��"+r);
				
	
	}
}
