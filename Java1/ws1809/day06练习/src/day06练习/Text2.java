package day06练习;

import java.util.Random;
import java.util.Scanner;

public class Text2 {
	public static void main(String[] args) {
		
	
	Dog a=new Dog("二狗子",70,70);
	System.out.println("恭喜你领养成功");
	System.out.println("按回车继续");
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
