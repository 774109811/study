package day10;

import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("�������ַ�����");
		String a= new Scanner(System.in).nextLine();
		System.out.println("�������ַ�");
		String b= new Scanner(System.in).nextLine();
//		int i=0;
//		while(a.indexOf(b,i)!=-1){
//			System.out.println(a.indexOf(b,i));
//			i=a.indexOf(b,i)+1;
//		}
		int i=0;
		while(true ){
			i=a.indexOf(b,i);
			if(i==-1){
				System.out.println("�������");	
			}
			i++;
			
			System.out.println("�ִ�λ���ǣ�"+i); 
			break;
		}
	}
}
