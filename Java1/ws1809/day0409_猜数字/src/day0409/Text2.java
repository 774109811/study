package day0409;

import java.util.Random;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		int a=1+new Random().nextInt(1000);
		System.out.println(a);
		
		System.out.println("�Ѿ�������һ��[1��1001����Χ���������");
		System.out.println("�²�������Ǽ�");
		
		while(true ){
			System.out.println("������");
			int b=new Scanner(System.in).nextInt();
			if(b>a){
				System.out.println("����");
			}else if(b<a){
				System.out.println("С��");
			}else{
				System.out.println("�¶�");
				return;
			}
		}
	}
}
