package day0605;

import java.util.Random;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		System.out.println("1.è");
		System.out.println("2.��");
		System.out.println("3.ţ");
		System.out.println("ѡ��");
		int c =new Scanner(System.in).nextInt();
		System.out.println("�������߸�����");
		String n= new Scanner(System.in).nextLine();
		//Cat cat= null;
		//Dog dog= null;
		Pet p  = null;
    
		switch(c){
		case 1:
			//�½������Ͷ��󣬵���������
			//�浽�����ͱ���
			p=new Cat(n);
			p.full=0;
			
//			play(p);
			break;
		case 2:
			p=new Dog(n);
			
//			play(p);
			break;
		case 3:
			p=new Niu(n);
			break;
		}
	
		play(p);
	}

//	private static void play(Cat cat) {
//		while(true){
//			  System.out.println("���س�����");
//			 new Scanner(System.in).nextLine();
//			 int a=new Random().nextInt(6);
//			 switch(a){
//			 case 0:cat.feed(); break;
//			 case 1:cat.play(); break;
//			 case 2:cat.punish(); break;
//			 case 3:cat.feed(); break;
//			 case 4:cat.play(); break;
//			 case 5:cat.punish(); break;
//			 
//				 
//			 }
//			 if(cat.full==100){
//				 return;
//			 }
//		}
//	}

	private static void play(Pet p) {
		while(true){
			  System.out.println("���س�����");
			 new Scanner(System.in).nextLine();
			 int a=new Random().nextInt(9);
			 switch(a){
			 case 0:p.feed(); break;
			 case 1:p.play(); break;
			 case 2:p.punish(); break;
			 case 3:p.feed(); break;
			 case 4:p.play(); break;
			 case 5:p.punish(); break;
			 case 6:p.feed();break;
			 case 7:p.play();break;
			 case 8:p.punish();break;
				 
			 }
			 if(p.full==100){
				 return;
			 }
		
	}
	}
	}
