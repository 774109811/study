package day0203;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.print("������ţ�");
		int y = new Scanner (System.in).nextInt();
		String r = "ƽ��";
//		������Ա�4����
//		if(y%4 == 0){
////			���Ҳ����Ա�100����
//			if(y%100  !=0){
//				r="����";
//			}
//		if(y%400 == 0){
//			r = "����";
//		}
//		}
	    if( (y%4==0&& y%100!=0)||y%400 == 0   ){
	    	r = "����";
	    }
		System.out.println(y+"����"+r);		
		
	}

}
