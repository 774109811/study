package day08_��ϰ;

import java.util.Scanner;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("1.������");
		System.out.println("2.����ĸ");
		System.out.println("ѡ��");
		int c =new Scanner(System.in).nextInt();
		GuessGame game=null;
		switch(c){
		case 1: game=new GuessLetterGame();
		case 2: game=new GuessNumberGame();
		}
		game.start();
	}
}
