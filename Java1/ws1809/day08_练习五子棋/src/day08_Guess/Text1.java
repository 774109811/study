package day08_Guess;

import java.util.Scanner;

import day08_��ϰ.GuessGame;

public class Text1 {
	public static void main(String[] args) {
		System.out.println("1.������");
		System.out.println("2.����ĸ");
		System.out.println("ѡ��");
		int c =new Scanner(System.in).nextInt();
		Guessgame game=null;
		switch(c){
		case 1:game=new GuessNumberGame();break;
		case 2:game=new GuessLetterGame();break;
		}
		game.start();
	}
}
