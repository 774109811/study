package day08_Á·Ï°;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("1.²ÂÊý×Ö");
		System.out.println("2.²Â×ÖÄ¸");
		System.out.println("Ñ¡Ôñ");
		int c =new Scanner(System.in).nextInt();
		GuessGame game=null;
		switch(c){
		case 1: game=new GuessLetterGame();
		case 2: game=new GuessNumberGame();
		}
		game.start();
	}
}
