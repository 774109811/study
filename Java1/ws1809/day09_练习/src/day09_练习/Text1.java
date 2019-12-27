package day09_练习;

import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		Transformer t = new Transformer();
		Fist f = new Fist();
		Lyb l =new Lyb();
		M41 m =new M41();
		
		System.out.println("按回车继续");
		while(true){
			 new Scanner(System.in).nextLine();
			 int r =new Random().nextInt(4);
			 switch(r){
			 case 0:t.setWeapon(f);break;
			 case 1:t.setWeapon(l);break;
			 case 2:t.setWeapon(m);break;
			 case 3:t.setWeapon(null);break;	 
			 }
			t.attack();
		}
		
	}
}
