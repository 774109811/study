package day0203;

import java.util.Scanner;

public class Rguo1 {
	public static void main(String[] args) {
		System.out.print("��������ݣ�");
		int y = new Scanner (System.in).nextInt();
		
		String r = "ƽ��";
		
		if( y%4 == 0 ){
			if(y%100 != 0)
				r = "����";
		}
		if( y%400 == 0 ){
			
				r = "����";
				
				
	}  
		System.out.println(y+"����"+r);
	}
		
		}

