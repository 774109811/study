package day06��ϰ;

import java.util.Random;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		
	
	Dog a=new Dog("������",70,70);
	System.out.println("��ϲ�������ɹ�");
	System.out.println("���س�����");
	play(a);
	
	}

	private static void play(Dog a) {
		while(true){
		new Scanner(System.in).nextLine();
		int b =new Random().nextInt(3);
		switch(b){
		case 0:a.feed();break;
		case 1:a.punish();break;
		case 2:a.play();break;
		
		
		
		}
		
		
		}
		
	}
	
}
