package day0409;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
//		int a= new Random().nextInt();
//		System.out.println(a);
		int r=1+new Random().nextInt(1000);
		System.out.println(r);
		System.out.println("�Ѿ�������һ��[1��1001����Χ���������");
		System.out.println("�²�������Ǽ�");
		
		while(true){
			
			System.out.println("��");
			try {
				int c= new Scanner(System.in).nextInt();
				if(c>r ){
					System.out.println("��");
				}else if(c<r){
					System.out.println("С");
				}else{
					System.out.println("�¶�");
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("��ʽ����");
			}
		}
	}
}
