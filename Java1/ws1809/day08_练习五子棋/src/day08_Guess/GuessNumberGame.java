package day08_Guess;

import java.util.Scanner;

import day08_练习.GuessGame;

public class GuessNumberGame extends Guessgame {

	@Override
	public String suiji() {
		int a =1+new Scanner(System.in).nextInt(500);
		String s=String.valueOf(a);
		return s;
	}

	@Override
	public void tishi() {
		System.out.println("已经生成了[1，500）随机整数");
		System.out.println("猜猜是几");
	}

	@Override
	public String bijiao(String c, String r) {
		int a=Integer.parseInt(c);
		int b=Integer.parseInt(r);
		if(a>b){
			return "大";
		}else if (a<b){
			return "小";
		}else{
			return "对";
		}
	}

	@Override
	public boolean caidui() {
		// TODO Auto-generated method stub
		return false;
	}

}
