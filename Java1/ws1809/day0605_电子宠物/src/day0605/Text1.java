package day0605;

import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		while(true){
		System.out.println("给宠物取个名");
		String name= new Scanner(System.in).nextLine();
	
	    Dog dog=new Dog();
        Cat cat=new Cat("汤姆猫");
	
	    dog.name=name;
	    dog.happy=50;
	    dog.full=50;
	    System.out.println("恭喜你领养了一只新的宠物");
	    System.out.println("按回车继续");
	    play(dog);
}
	}
	private static void play(Dog dog) {
		while(true){
			 new Scanner(System.in).nextLine();
			 int a=new Random().nextInt(6);
			 switch(a){
			 case 0:dog.feed(); break;
			 case 1:dog.play(); break;
			 case 2:dog.punish(); break;
			 case 3:dog.feed(); break;
			 case 4:dog.play(); break;
			 case 5:dog.punish(); break;
			 
				 
			 }
			 if(dog.full==100){
				 return;
			 }
		}
		
	}
}