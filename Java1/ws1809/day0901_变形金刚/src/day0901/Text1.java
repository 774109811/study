package day0901;

import java.util.Random;
import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		Transformer t = new Transformer();
		Sword s = new Sword();
		Ak47 a = new Ak47();
		Lyb l = new Lyb();
		System.out.println("按回车执行");
		while(true){
			new Scanner(System.in).nextLine();
			int r =new Random().nextInt(4);
			switch(r){
	    	case 0: t.setWeapon(s);break;
			case 1: t.setWeapon(a);break;
			case 2: t.setWeapon(l);break;
			case 3: t.setWeapon(null);break;
		}
		t.attack();
	}
}
}