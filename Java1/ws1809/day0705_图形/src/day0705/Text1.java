package day0705;

import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("���س���ʼ");
		while(true){
			int r =new Random().nextInt(4);
			switch(r){
			case 0:System.out.println("�����಻�ܴ���ʵ��");break;
			case 1:f(new Line() );break;
			case 2:f(new Square());break;
			case 3:f(new Circle());break;
			}
		}
	}
	static void f(Shape s){
		 new Scanner(System.in).nextLine();
		 s.draw();
//		 s����ʵ������Line����
		 if(s instanceof Line){	
			 
//		 ��ϸת�ͣ���Line���Ͷ���������⴦��ǿ�ƣ���
		 Line line =(Line)s;
		 line.length();
		 }
	       new Scanner(System.in).nextLine();
		 s.clear();
		 
	}
}
